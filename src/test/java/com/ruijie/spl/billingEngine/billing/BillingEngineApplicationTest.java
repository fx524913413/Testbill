package com.ruijie.spl.billingEngine.billing;

import com.ruijie.spl.billingEngine.billing.beans.BillingFeePackage;
import com.ruijie.spl.billingEngine.billing.dataEnum.SexEnum;
import com.ruijie.spl.billingEngine.billing.dataEnum.UserStateEnum;
import com.ruijie.spl.billingEngine.billing.entityWrapper.PersonWrapper;
import com.ruijie.spl.billingEngine.billing.entityWrapper.TariffStrategyWrapper;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.AccountInfoEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.TariffStrategyEntity;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.AccountInfoRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonTariffStrategyRelationRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.TariffStrategyRepository;
import com.ruijie.spl.billingEngine.billing.service.BusinessUsingService;
import com.ruijie.spl.billingEngine.billing.service.TestDatabaseService;
import com.ruijie.spl.billingEngine.interfacebean.ruleEngine.RuleEngineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingEngineApplicationTest {
    @Autowired
    private TestDatabaseService databaseService;
    @Autowired
    private BusinessUsingService businessUsingService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TariffStrategyRepository tariffStrategyRepository;
    @Autowired
    private RuleEngineService ruleEngineService;
    @Autowired
    private BillingFeePackage billingFeePackage;
    @Autowired
    private AccountInfoRepository accountInfoRepository_;
    @Autowired
    private PersonTariffStrategyRelationRepository personTariffStrategyRelationRepository;

    @Autowired
    private PersonWrapper personWrapper;
    @Autowired
    private TariffStrategyWrapper tariffStrategyWrapper;

    private KieSession session;

    @Before
    public void beforeSet() {
        KieServices services = KieServices.Factory.get();
        KieContainer kc = services.getKieClasspathContainer();
        session = kc.newKieSession("RealRuleSession");
    }

    @Test
    public void databaseServiceTest() throws FileNotFoundException {
        try {
            databaseService.createRecords_NoFK();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addStrategyTest() throws FileNotFoundException {
        tariffStrategyRepository.deleteAll();
        databaseService.createTariffStrategy();
    }

    @Test
    public void createAPerson() {
        personRepository.deleteAll();
        accountInfoRepository_.deleteAll();
        personTariffStrategyRelationRepository.deleteAll();

        PersonEntity personEntity = new PersonEntity();
        personEntity.setCreateTime(LocalDateTime.now());
        personEntity.setFirstName("Tinny");
        personEntity.setLastName("Tindy");
        personEntity.setUserSex(SexEnum.Male);
        personEntity.setUserState(UserStateEnum.Noraml);

//        AccountInfoEntity acct = new AccountInfoEntity();
//        acct.setAccountLabel("Out_GiftFlow_Acct");
//        acct.setFeeObjectAmount(BigDecimal.valueOf(50));
//
//        AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
//        accountInfoEntity.setAccountLabel("Package_GiftFlow_Acct");
//        accountInfoEntity.setTariffStrategyName("0001");
//        accountInfoEntity.setFeeObjectAmount(BigDecimal.valueOf(100));

        AccountInfoEntity acct2 = new AccountInfoEntity();
        acct2.setAccountLabel("Sum_Balance_Acct");
        acct2.setFeeObjectAmount(BigDecimal.valueOf(300));

//        personWrapper.addAccountInfo(personEntity, accountInfoEntity);
        personWrapper.addAccountInfo(personEntity, acct2);
//        personWrapper.addAccountInfo(personEntity, acct);

//        TariffStrategyEntity strategyEntity = tariffStrategyRepository.findByTariffStrategyName("0001");
//        personWrapper.connectionPersonAndTariffStrategy(personEntity, strategyEntity);
    }

    @Test
    public void applicationTest() throws Exception {
        PersonEntity personEntity = personRepository.findAll().get(0);
        TariffStrategyEntity strategyEntity = tariffStrategyRepository.findByTariffStrategyName("0001");
//        BillingFeePackage billingFeePackage = businessUsingService.handleBillingEvent(personEntity.getPerson_uuid(), strategyEntity.getTariffStrategyId(), null);

        businessUsingService.handBillingFeePackage(billingFeePackage);
    }

//    @Test
//    public void addBookingRelationTest() {
//        databaseService.createBookingRelationRecords();
//    }


    @Test
    public void aTest() throws ClassNotFoundException {
        LocalDateTime dateTime = LocalDateTime.now();
        List<PersonEntity> personEntity = tariffStrategyWrapper.getPersonEntity((long) 7357);
        System.out.println(Duration.between(dateTime, LocalDateTime.now()).toNanos());
        System.out.println(personEntity.size());
    }
}
