package com.ruijie.spl.billingEngine.billing.service;

import com.ruijie.spl.billingEngine.billing.beans.BillingFee;
import com.ruijie.spl.billingEngine.billing.beans.BillingFeePackage;
import com.ruijie.spl.billingEngine.billing.dataEnum.AccountStateEnum;
import com.ruijie.spl.billingEngine.billing.dataEnum.BillingFeeOperationTypeEnum;
import com.ruijie.spl.billingEngine.billing.entityWrapper.AccountWrapper;
import com.ruijie.spl.billingEngine.billing.entityWrapper.PersonWrapper;
import com.ruijie.spl.billingEngine.billing.entityWrapper.TariffStrategyWrapper;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.*;
import com.ruijie.spl.billingEngine.billing.repository.BookingRelationRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.AccountInfoRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonTariffStrategyRelationRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.TariffStrategyRepository;
import com.ruijie.spl.billingEngine.common.helper.PreprocessOutString;
import com.ruijie.spl.billingEngine.interfacebean.ruleEngine.RuleEngineService;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessOutParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/8.
 */
@Service
public class BusinessUsingServiceImpl implements BusinessUsingService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BillingFeePackage billingFeePackage;
    private final RuleEngineService ruleEngineService;

    private final PersonRepository personRepository;
    private final TariffStrategyRepository tariffStrategyRepository;
    private final AccountInfoRepository accountInfoRepository;
    private final BookingRelationRepository bookingRelationRepository;

    private final PersonWrapper personWrapper;

    @Autowired
    public BusinessUsingServiceImpl(BillingFeePackage billingFeePackage, RuleEngineService ruleEngineService, PersonRepository personRepository, TariffStrategyRepository tariffStrategyRepository, AccountInfoRepository accountInfoRepository, PersonTariffStrategyRelationRepository personTariffRelationRepository, BookingRelationRepository bookingRelationRepository, PersonWrapper personWrapper, AccountWrapper accountWrapper, TariffStrategyWrapper tariffStrategyWrapper) {
        this.billingFeePackage = billingFeePackage;
        this.ruleEngineService = ruleEngineService;
        this.personRepository = personRepository;
        this.tariffStrategyRepository = tariffStrategyRepository;
        this.accountInfoRepository = accountInfoRepository;
        this.bookingRelationRepository = bookingRelationRepository;
        this.personWrapper = personWrapper;
    }

    @Override
    @Transactional
    public BillingFeePackage handleBillingEvent(PersonEntity onePerson, TariffStrategyEntity oneStrategy, PreprocessOutParameters outParameters) throws Exception {
        List<TariffStrategyEntity> tariffs = personWrapper.getTariffStrategyEntity(onePerson);
        List<AccountInfoEntity> accountInfoEntity = personWrapper.getAccountInfoEntity(onePerson);

        billingFeePackage.setUserUuid(onePerson.getPerson_uuid());
        billingFeePackage.setCreateTime(LocalDateTime.now());

        ruleEngineService.addDrlFile(oneStrategy.getDrlFile());
        ruleEngineService.buildSessoin();
        ruleEngineService.setGlobal("billingFeeList", billingFeePackage);
        ruleEngineService.addFacts(onePerson);
        tariffs.forEach(o -> {
            try {
                ruleEngineService.addFacts(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ruleEngineService.addFacts(outParameters);
        accountInfoEntity.forEach(o -> {
            try {
                ruleEngineService.addFacts(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        if (outParameters.getPreprocessOutParameters().get(PreprocessOutString.isTariffStrategyOpen) != null)
            ruleEngineService.addFacts(oneStrategy);

        ruleEngineService.execution();

        return billingFeePackage;
    }

    @Override
    @Transactional
    public void handBillingFeePackage(BillingFeePackage billingFeePackage) {
        PersonEntity onePerson = personRepository.findOne(billingFeePackage.getUserUuid());
        List<AccountInfoEntity> personAccounts = personWrapper.getAccountInfoEntity(onePerson);
        List<TariffStrategyEntity> persontariffStrategies = personWrapper.getTariffStrategyEntity(onePerson);

        billingFeePackage.getBillingFeeList().forEach(o -> {

            if (o.getBillingFeeOperationType() == BillingFeeOperationTypeEnum.Add) {
                try {
                    accountCreate(onePerson, o, personAccounts, persontariffStrategies);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("", e);
                }
            }

            List<BookingRelationEntity> bookingRelations = bookingRelationRepository.findByFeeTypeName(o.getFeeSourceType());

            if (o.getBillingFeeOperationType() == BillingFeeOperationTypeEnum.Usage) {
                accountUsage(onePerson, o, personAccounts, bookingRelations);
            }

            if (o.getBillingFeeOperationType() == BillingFeeOperationTypeEnum.Reset) {
                accountReset(onePerson, o, personAccounts, bookingRelations);
            }
//            AccountInfoEntity infoEntity = accountInfoRepository.findAll().get(1);
//            infoEntity.setFeeObjectAmount(BigDecimal.ZERO);
//            accountInfoRepository.save(infoEntity);
//            AccountInfoEntity ddd = accountInfoRepository.findAll().get(1);
        });
    }

    private void accountReset(PersonEntity onePerson, BillingFee billingFee, List<AccountInfoEntity> personAccounts, List<BookingRelationEntity> bookingRelations) {
         /*对入账关系表中根据费用源类型记录按优先级排序，对每一条记录进行后续操作*/
        bookingRelations.stream().sorted((c, d) -> ((Integer) c.getPriority()).compareTo(d.getPriority())).forEach(
                bookingItem -> {
                    /*若该费用项已处理完，返回*/
                    if (billingFee.isHandledOver())
                        return;

                    /*根据入账关系表中一条记录的accountLabel，找到用户对应的特定账户*/
                    AccountInfoEntity accInfo = personAccounts.stream().filter(cc -> Objects.equals(cc.getAccountLabel(), bookingItem.getAccountLabel())).findFirst().orElse(null);

                    if (accInfo == null)
                        return;

                    accInfo.setFeeObjectAmount(billingFee.getBusinessVolumeAmount());
                    accInfo.setNextBillingTime(billingFee.getAcctNextBillingTime());
                    accountInfoRepository.saveAndFlush(accInfo);
//                    /*业务量类型相同，可以直接扣业务量*/
//                    if (accInfo.getBusinessVolumeOutType() == billingFee.getBusinessVolumeType()) {
//                        BigDecimal tempAmount = accInfo.getFeeObjectAmount().subtract(billingFee.getBusinessVolumeAmount());
//                        if (tempAmount.compareTo(accInfo.getLowerLimit()) >= 0 && tempAmount.compareTo(accInfo.getUpperLimit()) < 0) {
//                            accInfo.setFeeObjectAmount(tempAmount);
//                            billingFee.setHandledOver(true);
//                        } else if (tempAmount.compareTo(accInfo.getLowerLimit()) < 0) {
//                            accInfo.setFeeObjectAmount(accInfo.getLowerLimit());
//                            billingFee.setBusinessVolumeAmount(tempAmount.negate());
//                        } else if (tempAmount.compareTo(accInfo.getUpperLimit()) > 0) {
//                            accInfo.setFeeObjectAmount(accInfo.getUpperLimit());
//                            billingFee.setBusinessVolumeAmount(tempAmount.negate());
//                        }
//                    }
//                    /*业务量类型不同，必须对应的是一个账户转换类型*/
//                    else if (accInfo.getBusinessVolumeType() == billingFee.getBusinessVolumeType()) {
//                        BigDecimal aMount = billingFee.getBusinessVolumeAmount().multiply(billingFee.getAccountRate());
//                        billingFee.setBusinessVolumeAmount(aMount);
//                        billingFee.setBusinessVolumeType(accInfo.getBusinessVolumeOutType());
//                    }
//                    /*如果都没满足，那肯定是入账配置关系出错*/
//                    else {
//                        try {
//                            throw new Exception("入账关系配置错误");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            logger.error("", e);
//                        }
//                    }
                }
        );
    }

    private void accountUsage(PersonEntity onePerson, BillingFee billingFee, List<AccountInfoEntity> personAccounts, List<BookingRelationEntity> bookingRelations) {

        /*对入账关系表中根据费用源类型记录按优先级排序，对每一条记录进行后续操作*/
        bookingRelations.stream().sorted((c, d) -> ((Integer) c.getPriority()).compareTo(d.getPriority())).forEach(
                bookingItem -> {
                    /*若该费用项已处理完，返回*/
                    if (billingFee.isHandledOver())
                        return;

                    /*根据入账关系表中一条记录的accountLabel，找到用户对应的特定账户*/
                    AccountInfoEntity accInfo = personAccounts.stream().filter(cc -> Objects.equals(cc.getAccountLabel(), bookingItem.getAccountLabel())).findFirst().orElse(null);

                    if (accInfo == null)
                        return;

                    accInfo.setFeeObjectAmount(accInfo.getFeeObjectAmount().subtract(billingFee.getBusinessVolumeAmount()));
                    accountInfoRepository.saveAndFlush(accInfo);
//                    /*业务量类型相同，可以直接扣业务量*/
//                    if (accInfo.getBusinessVolumeOutType() == billingFee.getBusinessVolumeType()) {
//                        BigDecimal tempAmount = accInfo.getFeeObjectAmount().subtract(billingFee.getBusinessVolumeAmount());
//                        if (tempAmount.compareTo(accInfo.getLowerLimit()) >= 0 && tempAmount.compareTo(accInfo.getUpperLimit()) < 0) {
//                            accInfo.setFeeObjectAmount(tempAmount);
//                            billingFee.setHandledOver(true);
//                        } else if (tempAmount.compareTo(accInfo.getLowerLimit()) < 0) {
//                            accInfo.setFeeObjectAmount(accInfo.getLowerLimit());
//                            billingFee.setBusinessVolumeAmount(tempAmount.negate());
//                        } else if (tempAmount.compareTo(accInfo.getUpperLimit()) > 0) {
//                            accInfo.setFeeObjectAmount(accInfo.getUpperLimit());
//                            billingFee.setBusinessVolumeAmount(tempAmount.negate());
//                        }
//                    }
//                    /*业务量类型不同，必须对应的是一个账户转换类型*/
//                    else if (accInfo.getBusinessVolumeType() == billingFee.getBusinessVolumeType()) {
//                        BigDecimal aMount = billingFee.getBusinessVolumeAmount().multiply(billingFee.getAccountRate());
//                        billingFee.setBusinessVolumeAmount(aMount);
//                        billingFee.setBusinessVolumeType(accInfo.getBusinessVolumeOutType());
//                    }
//                    /*如果都没满足，那肯定是入账配置关系出错*/
//                    else {
//                        try {
//                            throw new Exception("入账关系配置错误");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            logger.error("", e);
//                        }
//                    }
                }
        );
    }

    private void accountCreate(PersonEntity onePerson, BillingFee billingFee, List<AccountInfoEntity> personAccounts, List<TariffStrategyEntity> persontariffStrategies) throws Exception {
        if (tariffStrategyRepository.findByTariffStrategyName(billingFee.getTariffName()) == null) {
            throw new Exception("资费策略表中不存在该策略");
        }

        if (persontariffStrategies.stream().noneMatch(o -> o.getTariffStrategyName().equals(billingFee.getTariffName()))) {
            personWrapper.connectionPersonAndTariffStrategy(onePerson, tariffStrategyRepository.findByTariffStrategyName(billingFee.getTariffName()));
        }

        AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
        accountInfoEntity.setFeeObjectAmount(billingFee.getBusinessVolumeAmount());
        accountInfoEntity.setTariffStrategyName(billingFee.getTariffName());
        accountInfoEntity.setAccountLabel(billingFee.getAcctLabel());
        accountInfoEntity.setLowerLimit(billingFee.getAcctLowerLimit());
        accountInfoEntity.setUpperLimit(billingFee.getAcctUpperLimit());
        accountInfoEntity.setAccountName(billingFee.getAccountName());
        accountInfoEntity.setDescription(billingFee.getAcctDescription());
        accountInfoEntity.setBusinessVolumeType(billingFee.getBusinessVolumeType());
        accountInfoEntity.setNextBillingTime(billingFee.getAcctNextBillingTime());

        accountInfoEntity.setCanAccountUse(true);
        accountInfoEntity.setCreateTime(LocalDateTime.now());
        accountInfoEntity.setUpdateTime(LocalDateTime.now());
        accountInfoEntity.setAccountState(AccountStateEnum.Normal);

        personWrapper.addAccountInfo(onePerson, accountInfoEntity);
    }

    public BillingFeePackage strategyHandle(String userUuid, PreprocessOutParameters outParameters) throws Exception {
        PersonEntity onePerson = personRepository.findOne(UUID.fromString(userUuid));

        billingFeePackage.setUserUuid(onePerson.getPerson_uuid());
        billingFeePackage.setCreateTime(LocalDateTime.now());

//        onePerson.getTariffStrategies().forEach(o -> ruleEngineService.addDrlFile(o.getDrlFile()));
        ruleEngineService.buildSessoin();
        ruleEngineService.setGlobal("billingFeeList", billingFeePackage);
        ruleEngineService.addFacts(onePerson);
        ruleEngineService.addFacts(outParameters);
        ruleEngineService.execution();

        return billingFeePackage;
    }
}
