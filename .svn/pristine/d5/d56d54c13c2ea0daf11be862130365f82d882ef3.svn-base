package com.ruijie.spl.billingEngine.booking.service;

import com.ruijie.spl.billingEngine.booking.entity.Bill;
import com.ruijie.spl.billingEngine.booking.entity.User_info;
import com.ruijie.spl.billingEngine.booking.repository.AccRelationRepository;
import com.ruijie.spl.billingEngine.booking.repository.AccountRepository;
import com.ruijie.spl.billingEngine.booking.repository.BillRepository;
import com.ruijie.spl.billingEngine.booking.repository.User_InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.UUID;
import java.util.zip.DataFormatException;

@Service
public class User_booking_BillSave {
    @Autowired
    BillRepository billRep;
    @Autowired
    private User_InfoRepository repostor;
    @Autowired
    private AccountRepository accRepository;
    @Autowired
    private AccRelationRepository AccRelRepository;

    @Transactional
    public void recordBillsTurnover(UUID userid, Integer sourcefeeid, Double fee, String billing_source) {
        User_info user = new User_info();
        Bill bills = new Bill();

        user = repostor.findByuseruuid(userid);
        String username = user.getUsername();//用户名字
        String AccountName = user.getAcountName();//账户名字
        String usergroup = user.getUsergroup(); //得到用户组
        UUID useruuid = user.getUseruuid(); //得到用户UUID
        String accountType = billing_source;//计费来源
        double billamount = fee; //计费
        double account_amount = accRepository.findByUseruuidAndAccountType(userid, "balance").getAmount();//得到账户余额
        SimpleDateFormat fdata = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String data_now = fdata.format(now);
        String Accountdesc = user.getaccountDesc(); //备注
        Double flow = null; //网关流量字段，表格中有，但都为空 没用到

        bills.setUsername(username);
        bills.setAccountName(AccountName);
        bills.setUsergroup(usergroup);
        bills.setUseruuid(useruuid);
        bills.setAccountType(accountType);
        bills.setAccountAmount(billamount);
        bills.setCreatedDate(data_now);
        bills.setBillAmount(billamount);
        bills.setAccountAmount(account_amount);
        bills.setAccountType(accountType);
        bills.setAccountDesc(Accountdesc);
        bills.setFlow(flow);


        billRep.save(bills);
    }
}
