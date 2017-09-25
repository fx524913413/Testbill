package com.ruijie.spl.billingEngine.billing.service;

import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2017/9/6.
 */
public interface TestDatabaseService {
    @Transactional
    void createRecords_NoFK() throws FileNotFoundException;
//    void createRecords() throws FileNotFoundException;

    void createTariffStrategy() throws FileNotFoundException;
//
//    void addAPeriodTariffStrategyForAUser(String userUuid, Long strategyId);

}
