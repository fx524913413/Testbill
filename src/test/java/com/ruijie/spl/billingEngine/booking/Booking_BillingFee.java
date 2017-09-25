package com.ruijie.spl.billingEngine.booking;

import com.google.common.annotations.VisibleForTesting;
import com.ruijie.spl.billingEngine.billing.beans.BillingFee;
import com.ruijie.spl.billingEngine.billing.beans.BillingFeePackage;
import com.ruijie.spl.billingEngine.billing.beans.BillingTemp;
import com.ruijie.spl.billingEngine.billing.dataEnum.BusinessVolumeTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
public class Booking_BillingFee {
    @Autowired
    private BillingFeePackage billingFeePackage;
    @Autowired
    private BillingFee billingFee;
    @Autowired
    private BillingFee billingFee2;
    @Autowired
    private BillingTemp billingTemp;


    public BillingFeePackage testbill(){

        BigDecimal loanAmount = new BigDecimal("20");
        LocalDateTime time =LocalDateTime.now();
        billingFee.setBusinessVolumeAmount(loanAmount);
        billingFee.setAccountName("bill1");
        billingFee.setBusinessVolumeType(BusinessVolumeTypeEnum.Flow);
        billingFee.setFeeSourceType("flow");
        billingFee.setAcctNextBillingTime(time);

        BigDecimal loanAmount2 = new BigDecimal("30");
        billingFee2.setBusinessVolumeAmount(loanAmount2);
        billingFee2.setAccountName("bill2");
        billingFee2.setBusinessVolumeType(BusinessVolumeTypeEnum.SessionTime);
        billingFee2.setFeeSourceType("fee");
        billingFee2.setAcctNextBillingTime(time);

        List<BillingFee> bills = new ArrayList<>();
        bills.add(billingFee);
        bills.add(billingFee2);
        billingFeePackage.setUserUuid(UUID.randomUUID());
        billingFeePackage.setBillingFeeList(bills);
        return billingFeePackage;
    }

    @Test
    public void bookingSave(){

    }

}
