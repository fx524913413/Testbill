package com.ruijie.spl.billingEngine.billing.service;

import com.ruijie.spl.billingEngine.billing.dataEnum.*;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.AccountInfoEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonTariffStrategyRelation;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.TariffStrategyEntity;
import com.ruijie.spl.billingEngine.billing.repository.BookingRelationRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.AccountInfoRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonTariffStrategyRelationRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.TariffStrategyRepository;
import com.ruijie.spl.billingEngine.common.helper.DrlFileProcessorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/9/6.
 */
@Component
public class TestDatabaseServiceImpl implements TestDatabaseService {
    private final DrlFileProcessorHelper drlHelper;

    private final PersonRepository personRepository_;
    private final TariffStrategyRepository tariffStrategyRepository;
    private final AccountInfoRepository accountInfoRepository_;
    private final PersonTariffStrategyRelationRepository personTariffStrategyRelationRepository;
    private final BookingRelationRepository bookingRelationRepository;


    private Random random = new Random();
    private final int CONSTCOUNT = 6;

    private ClassLoader systemClassLoader = TestDatabaseServiceImpl.class.getClassLoader();

    private String[] firstNames = new String[]{"Kobe", "Curry", "James", "Durant", "Harden", "John"};
    private String[] lastNames = new String[]{"Bryant", "Steve", "LeBron", "Kevin", "James", "Wall"};
    private int[] ages = new int[]{28, 14, 23, 12, 15, 29};

    @Autowired
    public TestDatabaseServiceImpl(DrlFileProcessorHelper drlHelper, PersonRepository personRepository_, TariffStrategyRepository tariffStrategyRepository, AccountInfoRepository accountInfoRepository_, PersonTariffStrategyRelationRepository personTariffStrategyRelationRepository, BookingRelationRepository bookingRelationRepository) {
        this.drlHelper = drlHelper;
        this.personRepository_ = personRepository_;
        this.tariffStrategyRepository = tariffStrategyRepository;
        this.accountInfoRepository_ = accountInfoRepository_;
        this.personTariffStrategyRelationRepository = personTariffStrategyRelationRepository;
        this.bookingRelationRepository = bookingRelationRepository;
    }

//    @Override
//    @Transactional
//    public void createRecords() throws FileNotFoundException {
//
//        //region ++++生成资费策略记录
//        if (tariffStrategyRepository.count() > 0)
//            tariffStrategyRepository.deleteAll();
//         /*插入三个规则文件*/
//        TariffStrategyEntity_Ab entity1 = new TariffStrategyEntity_Ab();
//        entity1.setTariffStrategyName("0000");
//        entity1.setDescription("周期扣费策略，10元30天");
//        entity1.setTariffStrategyType(TariffStrategyTypeEnum.Period);
//        entity1.setDrlFile(drlHelper.drlFileToString(systemClassLoader.getResource("com/ruijie/spl/billingEngine/billing/rules/0000Rule.drl").getPath()));
//        entity1.setCreateTime(LocalDateTime.now());
//
//        TariffStrategyEntity_Ab entity2 = new TariffStrategyEntity_Ab();
//        entity2.setTariffStrategyName("1000");
//        entity2.setDescription("国际下行流量扣费规则，0~20M 2元/M，大于20M 1元/M");
//        entity2.setDrlFile(drlHelper.drlFileToString(systemClassLoader.getResource("com/ruijie/spl/billingEngine/billing/rules/1000Rule.drl").getPath()));
//        entity2.setCreateTime(LocalDateTime.now());
//
//        TariffStrategyEntity_Ab entity3 = new TariffStrategyEntity_Ab();
//        entity3.setTariffStrategyName("ARule");
//        entity3.setDescription("用于测试的一个Rule");
//        entity3.setDrlFile(drlHelper.drlFileToString(systemClassLoader.getResource("com/ruijie/spl/billingEngine/billing/rules/ARule.drl").getPath()));
//        entity3.setCreateTime(LocalDateTime.now());
//
//        List<TariffStrategyEntity_Ab> tariffStrategyEntityList = new ArrayList<>();
//        tariffStrategyEntityList.add(entity1);
//        tariffStrategyEntityList.add(entity2);
//        tariffStrategyEntityList.add(entity3);
//        tariffStrategyRepository.save(tariffStrategyEntityList);
//        //endregion
//
//        //region ++++生成用户记录，以及关联的账户记录，业务量记录
//        if (personRepository.count() > 0)
//            personRepository.deleteAll();
//
//        TariffStrategyEntity_Ab rule0000 = tariffStrategyRepository.findByTariffStrategyName("0000");
//        TariffStrategyEntity_Ab rule1000 = tariffStrategyRepository.findByTariffStrategyName("1000");
//        TariffStrategyEntity_Ab aRule = tariffStrategyRepository.findByTariffStrategyName("ARule");
//
//        List<PersonEntity_Ab> entities = new ArrayList<>();
//
//        IntStream.rangeClosed(1, 200).forEach(o -> {
//
//            PersonEntity_Ab entity = new PersonEntity_Ab();
//            LocalDateTime nowTime = LocalDateTime.now();
//
//            /*设置基本信息*/
//            entity.setFirstName(firstNames[random.nextInt(CONSTCOUNT)]);
//            entity.setLastName(lastNames[random.nextInt(CONSTCOUNT)]);
//            int nextInt = random.nextInt(CONSTCOUNT);
//            entity.setAge(ages[nextInt]);
//            entity.setCreateTime(nowTime);
//            entity.setLastUpdateTime(nowTime);
//            entity.setUserSex(SexEnum.values()[random.nextInt(SexEnum.values().length)]);
//            entity.setUserState(UserStateEnum.values()[random.nextInt(UserStateEnum.values().length)]);
//
//            /*设置关联的资费策略信息*/
//            if (ages[nextInt] >= 18)
//                entity.getTariffStrategies().add(rule1000);
//            entity.getTariffStrategies().add(rule0000);
//            entity.getTariffStrategies().add(aRule);
//
//            /*添加基本账户*/
//            AccountInfoEntity_Ab accountInfoEntity = new AccountInfoEntity_Ab();
//            accountInfoEntity.setAccountState(AccountStateEnum.Normal);
//            accountInfoEntity.setCanAccountUse(true);
//            accountInfoEntity.setCreateTime(nowTime);
//            accountInfoEntity.setUpdateTime(nowTime);
//            accountInfoEntity.setLowerLimit(BigDecimal.ZERO);
//            accountInfoEntity.setPersonRelation(entity);
//            accountInfoEntity.setAccountName("金额账户");
//            accountInfoEntity.setAccountLevel(AccountLevelEnum.Base);
//            accountInfoEntity.setBusinessVolumeOutType(BusinessVolumeTypeEnum.Money);
//            accountInfoEntity.setFeeObjectUnit(FeeObjectUnitEnum.Fen);
//            accountInfoEntity.setFeeObjectAmount(BigDecimal.valueOf(random.nextDouble() * 10000));
//            entity.getAccounts().add(accountInfoEntity);
//
//            if (o % 3 == 0) {
//                /*每隔三个用户添加赠送的流量账户*/
//                AccountInfoEntity_Ab flowAccount = new AccountInfoEntity_Ab();
//                flowAccount.setCanAccountUse(true);
//                flowAccount.setCreateTime(nowTime);
//                flowAccount.setUpdateTime(nowTime);
//                flowAccount.setLowerLimit(BigDecimal.ZERO);
//                flowAccount.setPersonRelation(entity);
//                flowAccount.setAccountName("流量账户");
//                flowAccount.setAccountLevel(AccountLevelEnum.Present);
//                flowAccount.setBusinessVolumeOutType(BusinessVolumeTypeEnum.Flow);
//                flowAccount.setFeeObjectUnit(FeeObjectUnitEnum.M);
//                flowAccount.setFeeObjectAmount(BigDecimal.valueOf(random.nextDouble() * 100));
//                entity.getAccounts().add(flowAccount);
//            }
//
////            if (o % 5 == 0) {
//            /*所有用户添加周期账户（都关联周期资费策略）*/
//            AccountInfoEntity_Ab periodAccount = new AccountInfoEntity_Ab();
//            periodAccount.setAccountName("周期账户");
//            periodAccount.setTariffStrategyName(rule0000.getTariffStrategyName());
//            periodAccount.setCreateTime(nowTime);
//            periodAccount.setUpdateTime(nowTime);
//            periodAccount.setLowerLimit(BigDecimal.ZERO);
//            periodAccount.setPersonRelation(entity);
//            periodAccount.setAccountLevel(AccountLevelEnum.Package);
//            periodAccount.setBusinessVolumeOutType(BusinessVolumeTypeEnum.PeriodTime);
//            periodAccount.setFeeObjectUnit(FeeObjectUnitEnum.Day);
//
//            int days = random.nextInt(31);
//            periodAccount.setFeeObjectAmount(BigDecimal.valueOf(days));
//            periodAccount.setNextBillingTime(nowTime.plusDays(days).toLocalDate().atStartOfDay());
//
//            BusinessVolumeEntity_Ab cumulant = new BusinessVolumeEntity_Ab();
//            cumulant.setInlandDownFlow(BigDecimal.valueOf(random.nextDouble() * 100));
//            cumulant.setInlandUpFlow(BigDecimal.valueOf(random.nextDouble() * 100));
//            cumulant.setForeignDownFlow(BigDecimal.valueOf(random.nextDouble() * 100));
//            cumulant.setForeignUpFlow(BigDecimal.valueOf(random.nextDouble() * 100));
//            cumulant.setBusinessVolumeOutType(BusinessVolumeTypeEnum.Cumulant);
//            cumulant.setAccountRelation(periodAccount);
//
//            BusinessVolumeEntity_Ab packageVolume = new BusinessVolumeEntity_Ab();
//            packageVolume.setForeignUpFlow(BigDecimal.valueOf(random.nextDouble() * 100));
//            packageVolume.setForeignDownFlow(BigDecimal.valueOf(random.nextDouble() * 100));
//            packageVolume.setInlandUpFlow(BigDecimal.valueOf(random.nextDouble() * 100));
//            packageVolume.setInlandDownFlow(BigDecimal.valueOf(random.nextDouble() * 100));
//            packageVolume.setBusinessVolumeOutType(BusinessVolumeTypeEnum.Attached);
//            packageVolume.setAccountRelation(periodAccount);
//
//            periodAccount.getBusinessVolumeRelation().add(cumulant);
//            periodAccount.getBusinessVolumeRelation().add(packageVolume);
//
//            entity.getAccounts().add(periodAccount);
////            }
//
//            /*对于名不为“James”的用户添加信用账户*/
//            if (!entity.getLastName().equals("James")) {
//                AccountInfoEntity_Ab normalAccountInfoEntity = new AccountInfoEntity_Ab();
//                normalAccountInfoEntity.setAccountName("信用账户");
//                normalAccountInfoEntity.setCanAccountUse(true);
//                normalAccountInfoEntity.setCreateTime(nowTime);
//                normalAccountInfoEntity.setUpdateTime(nowTime);
//                normalAccountInfoEntity.setUpperLimit(BigDecimal.valueOf(random.nextInt(3000) + 2000));
//                normalAccountInfoEntity.setLowerLimit(BigDecimal.ZERO);
//                normalAccountInfoEntity.setAccountLevel(AccountLevelEnum.OverDraw);
//                normalAccountInfoEntity.setBusinessVolumeOutType(BusinessVolumeTypeEnum.Money);
//                normalAccountInfoEntity.setFeeObjectAmount(BigDecimal.ZERO);
//                normalAccountInfoEntity.setFeeObjectUnit(FeeObjectUnitEnum.Fen);
//
//                normalAccountInfoEntity.setPersonRelation(entity);
//                entity.getAccounts().add(normalAccountInfoEntity);
//            }
//
//            entities.add(entity);
//            /*personRepository.save(entity);*/
//        });
//
//        personRepository.save(entities);
//        //endregion
//    }

    @Override
    @Transactional
    public void createRecords_NoFK() throws FileNotFoundException {

        //region +++++生成资费策略记录
        if (tariffStrategyRepository.count() > 0) {
            tariffStrategyRepository.deleteAll();
            tariffStrategyRepository.flush();
        }

        TariffStrategyEntity entity1 = new TariffStrategyEntity();
        entity1.setTariffStrategyName("0001");
        entity1.setDescription("一个周期资费策略，20元/月，赠送100M国内下行流量，100M国内上行流量；流量使用规则：1元/M国内上行流量，0.5元/M国内下行流量");
        entity1.setDrlFile(drlHelper.drlFileToString(systemClassLoader.getResource("com/ruijie/spl/billingEngine/billing/rules/0001Rule.drl").getPath()));
        entity1.setCreateTime(LocalDateTime.now());
        entity1.setTariffPersonRelationUuid(UUID.randomUUID());

        TariffStrategyEntity entity2 = new TariffStrategyEntity();
        entity2.setTariffStrategyName("1000");
        entity2.setDescription("国际下行流量扣费规则，0~20M 2元/M，大于20M 1元/M");
        entity2.setDrlFile(drlHelper.drlFileToString(systemClassLoader.getResource("com/ruijie/spl/billingEngine/billing/rules/1000Rule.drl").getPath()));
        entity2.setCreateTime(LocalDateTime.now());
        entity2.setTariffPersonRelationUuid(UUID.randomUUID());

        TariffStrategyEntity entity3 = new TariffStrategyEntity();
        entity3.setTariffStrategyName("ARule");
        entity3.setDescription("用于测试的一个Rule");
        entity3.setDrlFile(drlHelper.drlFileToString(systemClassLoader.getResource("com/ruijie/spl/billingEngine/billing/rules/ARule.drl").getPath()));
        entity3.setCreateTime(LocalDateTime.now());
        entity3.setTariffPersonRelationUuid(UUID.randomUUID());

        List<TariffStrategyEntity> tariffStrategyEntities = new ArrayList<>();
        tariffStrategyEntities.add(entity1);
        tariffStrategyEntities.add(entity2);
        tariffStrategyEntities.add(entity3);
        tariffStrategyRepository.save(tariffStrategyEntities);
        //endregion

        //region ++++++生成用户即关联账户信息
        if (personRepository_.count() > 0)
            personRepository_.deleteAll();

        TariffStrategyEntity rule0001 = tariffStrategyRepository.findByTariffStrategyName("0001");
        TariffStrategyEntity rule1000 = tariffStrategyRepository.findByTariffStrategyName("1000");
        TariffStrategyEntity rule = tariffStrategyRepository.findByTariffStrategyName("ARule");

        List<PersonEntity> enties = new ArrayList<>();

        IntStream.rangeClosed(1, 200).forEach(o -> {
            PersonEntity entity = new PersonEntity();
            LocalDateTime nowTime = LocalDateTime.now();

            entity.setPersonAccountRelationUuid(UUID.randomUUID());
            entity.setPersonTariffRelationUuid(UUID.randomUUID());

            entity.setFirstName(firstNames[random.nextInt(CONSTCOUNT)]);
            entity.setLastName(lastNames[random.nextInt(CONSTCOUNT)]);
            int nextInt = random.nextInt(CONSTCOUNT);
            entity.setAge(ages[nextInt]);
            entity.setCreateTime(nowTime);
            entity.setLastUpdateTime(nowTime);
            entity.setUserSex(SexEnum.values()[random.nextInt(SexEnum.values().length)]);
            entity.setUserState(UserStateEnum.values()[random.nextInt(UserStateEnum.values().length)]);

            /*设置关联的资费策略信息*/
            if (ages[nextInt] >= 18) {
                PersonTariffStrategyRelation relatioin = new PersonTariffStrategyRelation(entity.getPersonTariffRelationUuid(), rule1000.getTariffPersonRelationUuid());
                personTariffStrategyRelationRepository.save(relatioin);
            }
            PersonTariffStrategyRelation otherRelation = new PersonTariffStrategyRelation(entity.getPersonTariffRelationUuid(), rule0001.getTariffPersonRelationUuid());
            personTariffStrategyRelationRepository.save(otherRelation);
            PersonTariffStrategyRelation bRelation = new PersonTariffStrategyRelation(entity.getPersonTariffRelationUuid(), rule.getTariffPersonRelationUuid());
            personTariffStrategyRelationRepository.save(bRelation);

              /*添加基本账户*/
            AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
            accountInfoEntity.setAccountState(AccountStateEnum.Normal);
            accountInfoEntity.setCanAccountUse(true);
            accountInfoEntity.setCreateTime(nowTime);
            accountInfoEntity.setUpdateTime(nowTime);
            accountInfoEntity.setLowerLimit(BigDecimal.ZERO);
            accountInfoEntity.setUpperLimit(BigDecimal.valueOf(Integer.MAX_VALUE));
           /* accountInfoEntity.setPersonAccountRelationUuid();*/
            accountInfoEntity.setAccountName("金额账户");
//            accountInfoEntity.setAccountLevel(AccountLevelEnum.Base);
//            accountInfoEntity.setBusinessVolumeOutType(BusinessVolumeTypeEnum.Money);
//            accountInfoEntity.setFeeObjectMotherUnit(FeeObjectUnitEnum.Fen);
//            accountInfoEntity.setFeeObjectRate(BigDecimal.valueOf(1));
//            accountInfoEntity.setFeeObjectSonUnit(FeeObjectUnitEnum.Fen);
            accountInfoEntity.setFeeObjectAmount(BigDecimal.valueOf(random.nextDouble() * 10000));
            accountInfoEntity.setTariffStrategyName(rule0001.getTariffStrategyName());
            accountInfoEntity.setPersonAccountRelationUuid(entity.getPersonAccountRelationUuid());
            accountInfoRepository_.save(accountInfoEntity);

            if (o % 3 == 0) {
                /*每隔三个用户添加赠送的流量账户*/
                AccountInfoEntity flowAccount = new AccountInfoEntity();
                flowAccount.setAccountState(AccountStateEnum.Normal);
                flowAccount.setTariffStrategyName(rule0001.getTariffStrategyName());
                flowAccount.setCanAccountUse(true);
                flowAccount.setCreateTime(nowTime);
                flowAccount.setUpdateTime(nowTime);
                flowAccount.setLowerLimit(BigDecimal.ZERO);
                flowAccount.setUpperLimit(BigDecimal.valueOf(Integer.MAX_VALUE));
                flowAccount.setAccountName("流量账户");
//                flowAccount.setAccountLevel(AccountLevelEnum.Present);
//                flowAccount.setBusinessVolumeOutType(BusinessVolumeTypeEnum.Flow);
//                flowAccount.setFeeObjectRate(BigDecimal.valueOf(1));
//                flowAccount.setFeeObjectSonUnit(FeeObjectUnitEnum.M);
//                flowAccount.setFeeObjectMotherUnit(FeeObjectUnitEnum.M);
                flowAccount.setFeeObjectAmount(BigDecimal.valueOf(random.nextDouble() * 100));
                flowAccount.setPersonAccountRelationUuid(entity.getPersonAccountRelationUuid());
                accountInfoRepository_.save(flowAccount);
            }

            AccountInfoEntity periodAccount = new AccountInfoEntity();
            periodAccount.setTariffStrategyName(rule0001.getTariffStrategyName());
            periodAccount.setAccountState(AccountStateEnum.Normal);
//            periodAccount.setAccountLevel(AccountLevelEnum.Package);
            periodAccount.setCreateTime(nowTime);
            periodAccount.setUpdateTime(nowTime);
            periodAccount.setAccountName("周期计天账户");
            periodAccount.setLowerLimit(BigDecimal.valueOf(0));
            periodAccount.setUpperLimit(BigDecimal.valueOf(Integer.MAX_VALUE));
            periodAccount.setCanAccountUse(true);
//            periodAccount.setAccountLevel(AccountLevelEnum.Present);
//            periodAccount.setBusinessVolumeOutType(BusinessVolumeTypeEnum.PeriodTime);
            periodAccount.setFeeObjectAmount(BigDecimal.valueOf(25));
//            periodAccount.setFeeObjectRate(BigDecimal.valueOf(1));
//            periodAccount.setFeeObjectSonUnit(FeeObjectUnitEnum.Day);
//            periodAccount.setFeeObjectMotherUnit(FeeObjectUnitEnum.Day);
            periodAccount.setPersonAccountRelationUuid(entity.getPersonAccountRelationUuid());
            accountInfoRepository_.save(periodAccount);

            enties.add(entity);
        });

        personRepository_.save(enties);
        //endregion
    }

    @Override
    public void createTariffStrategy() throws FileNotFoundException {
        TariffStrategyEntity entity = new TariffStrategyEntity();
        entity.setTariffPersonRelationUuid(UUID.randomUUID());
        entity.setTariffStrategyName("0001");
        entity.setDescription("周期扣费策略，20元30天，赠送100M国内上行流量，100国内下行流量；流量使用规则：1元/M国内上行流量，0.5元/M国内下行流量");
        entity.setDrlFile(drlHelper.drlFileToString(systemClassLoader.getResource("com/ruijie/spl/billingEngine/billing/rules/0001Rule.drl").getPath()));
        entity.setCreateTime(LocalDateTime.now());
        entity.setTariffStrategyType(TariffStrategyTypeEnum.Period);

        tariffStrategyRepository.save(entity);
    }
//
//    @Override
//    @Transactional
//    public void addAPeriodTariffStrategyForAUser(String userUuid, Long strategyId) {
//        PersonEntity_Ab one = personRepository.findOne(UUID.fromString(userUuid));
//        TariffStrategyEntity_Ab strategyEntity = tariffStrategyRepository.findOne(strategyId);
//
//        if (one.getAccounts().parallelStream().noneMatch(o -> Objects.equals(strategyEntity.getTariffStrategyName(), o.getAccountName()))) {
//            one.getTariffStrategies().add(strategyEntity);
//
//            personRepository.save(one);
//        }
//    }
}
