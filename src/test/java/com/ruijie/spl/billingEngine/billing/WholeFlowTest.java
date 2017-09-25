package com.ruijie.spl.billingEngine.billing;

import com.ruijie.spl.billingEngine.billing.beans.BillingFeePackage;
import com.ruijie.spl.billingEngine.billing.entityWrapper.PersonWrapper;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.AccountInfoEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.BookingRelationEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.TariffStrategyEntity;
import com.ruijie.spl.billingEngine.billing.repository.BookingRelationRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.TariffStrategyRepository;
import com.ruijie.spl.billingEngine.billing.service.BusinessUsingService;
import com.ruijie.spl.billingEngine.common.helper.PreprocessOutString;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessOutParameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/9/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WholeFlowTest {
    @Autowired
    private BusinessUsingService businessUsingService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TariffStrategyRepository tariffStrategyRepository;
    @Autowired
    private PreprocessOutParameters preprocessOutParameters;
    @Autowired
    private BookingRelationRepository bookingRelationRepository;
    @Autowired
    private PersonWrapper personWrapper;


    @Test
    public void addBookingRelation() {
        bookingRelationRepository.save(new BookingRelationEntity("Out_GiftFlow_Acct", "Out_GiftFlow_Acct", 10));
        bookingRelationRepository.save(new BookingRelationEntity("Package_GiftFlow_Acct", "Package_GiftFlow_Acct", 10));
        bookingRelationRepository.save(new BookingRelationEntity("Sum_Balance_Acct", "Sum_Balance_Acct", 10));
        bookingRelationRepository.save(new BookingRelationEntity("Package_Cumulant_Acct", "Package_Cumulant_Acct", 10));
        bookingRelationRepository.save(new BookingRelationEntity("Package_PeriodCycle_Acct", "Package_PeriodCycle_Acct", 10));
    }

    @Test
    public void wholeFlowCreateTest() throws Exception {
        PersonEntity onePerson = personRepository.findAll().get(0);
        TariffStrategyEntity tariff = tariffStrategyRepository.findAll().get(0);
        preprocessOutParameters.getPreprocessOutParameters().put(PreprocessOutString.isTariffStrategyOpen, true);

        BillingFeePackage billingFeePackage = businessUsingService.handleBillingEvent(onePerson, tariff, preprocessOutParameters);
        businessUsingService.handBillingFeePackage(billingFeePackage);
    }

    @Test
    public void wholeFlowUseTest() throws Exception {
        PersonEntity onePerson = personRepository.findAll().get(0);
        TariffStrategyEntity tariff = tariffStrategyRepository.findAll().get(0);
        preprocessOutParameters.getPreprocessOutParameters().put(PreprocessOutString.ntdFlow, 150);

        BillingFeePackage billingFeePackage = businessUsingService.handleBillingEvent(onePerson, tariff, preprocessOutParameters);
        businessUsingService.handBillingFeePackage(billingFeePackage);
    }

    @Test
    public void wholeFlowResetTest() throws Exception {
        PersonEntity onePerson = personRepository.findAll().get(0);
        TariffStrategyEntity tariff = tariffStrategyRepository.findAll().get(0);

        AccountInfoEntity infoEntity = personWrapper.getAccountInfoEntity(onePerson).stream().filter(o -> o.getTariffStrategyName().equals(tariff.getTariffStrategyName()) && o.getAccountLabel().equals("Package_PeriodCycle_Acct")).findFirst().orElse(null);

        preprocessOutParameters.getPreprocessOutParameters().put(PreprocessOutString.currentSystemTime, infoEntity.getNextBillingTime().plusMinutes(10));

        BillingFeePackage billingFeePackage = businessUsingService.handleBillingEvent(onePerson, tariff, preprocessOutParameters);
        businessUsingService.handBillingFeePackage(billingFeePackage);
    }

    @Test
    public void aTest(){
        System.out.println("1000");
    }
}
