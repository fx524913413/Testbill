package com.ruijie.spl.billingEngine.billing.controller;

import com.ruijie.spl.billingEngine.billing.beans.BillingFeePackage;
import com.ruijie.spl.billingEngine.billing.entity.PersonEntity_Ab;
import com.ruijie.spl.billingEngine.billing.service.BusinessUsingService;
import com.ruijie.spl.billingEngine.billing.service.TestDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Administrator on 2017/9/6.
 */
@RestController
@RequestMapping("/persontest")
public class PersonInfoController {
    @Autowired
    private TestDatabaseService testDatabaseService;
    @Autowired
    private BusinessUsingService businessUsingService;


    @RequestMapping(value = "/getUserByUuid/{uuid}", method = {RequestMethod.GET})
    public PersonEntity_Ab getUserById(@PathVariable String uuid) {
        UUID dd = UUID.fromString(uuid);
        return null;
    }

    @RequestMapping(value = "/createNewStrategy/{userUUID}/{strategyId}", method = {RequestMethod.GET})
    public BillingFeePackage createNewStrategyForUser(@PathVariable("userUUID") String userUUID, @PathVariable("strategyId") String strategyId) throws Exception {
        return null;
    }
}
