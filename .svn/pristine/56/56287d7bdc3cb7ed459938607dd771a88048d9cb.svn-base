package com.ruijie.spl.billingEngine.booking;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ruijie.spl.billingEngine.BillingEngineApplication;
import com.ruijie.spl.billingEngine.booking.entity.Account_info;
import com.ruijie.spl.billingEngine.booking.entity.User_info;
import com.ruijie.spl.billingEngine.booking.repository.AccRelationRepository;
import com.ruijie.spl.billingEngine.booking.repository.AccountRepository;
import com.ruijie.spl.billingEngine.booking.repository.User_InfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BillingEngineApplication.class)
@WebAppConfiguration
public class booking_createUser_test {
    @Autowired
    private User_InfoRepository repostor;
    @Autowired
    private AccountRepository accRepository;
    @Autowired
    private AccRelationRepository AccRelRepository;

    @Test
    public void createNewsetmenu() {

        User_info testuser = new User_info();
        testuser.setUsername("test_user");
        Map<String, Double> user = new HashMap<>();

        user.put("balance", 30.0);
        user.put("upflow", 100.0);
        user.put("downflow", 100.0);
//			Set<Account_info> accounts = new HashSet<Account_info>();


        Set<Map.Entry<String, Double>> entrysetSet = user.entrySet();//此为遍历map类型的方法
        for (Map.Entry<String, Double> obj4acc : entrysetSet) {
            Account_info account = new Account_info();
            account.setAccountType(obj4acc.getKey());
            account.setAmount(obj4acc.getValue());
            account.setUseruuid(testuser.getUseruuid());
            accRepository.save(account);
            System.out.println("1");
        }
    }

}
