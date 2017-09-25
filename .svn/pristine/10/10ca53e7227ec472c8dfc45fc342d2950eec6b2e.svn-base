package com.ruijie.spl.billingEngine.billing.service;

import com.ruijie.spl.billingEngine.billing.beans.BillingFeePackage;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.TariffStrategyEntity;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessOutParameters;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/9/8.
 */
public interface BusinessUsingService {
    @Transactional
    BillingFeePackage handleBillingEvent(PersonEntity onePerson, TariffStrategyEntity oneStrategy, PreprocessOutParameters outParameters) throws Exception;

    void handBillingFeePackage(BillingFeePackage billingFeePackage);
}

