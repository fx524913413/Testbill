package com.ruijie.spl.billingEngine.booking;

import com.ruijie.spl.billingEngine.billing.beans.BillingFeePackage;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.AccountInfoEntity;
import com.ruijie.spl.billingEngine.booking.entity.Account_info;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/9/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Booking_save {
    @Autowired
    private Booking_BillingFee booking_billingFee;
    @Autowired
    private AccountInfoEntity accountentity;

    public void ttestbills(){
        BillingFeePackage ss = booking_billingFee.testbill();
        accountentity.
    }

}
