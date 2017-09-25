package com.ruijie.spl.billingEngine.billing;

import com.ruijie.spl.billingEngine.BillingEngineApplication;
import com.ruijie.spl.billingEngine.billing.beans.BillingFeePackage;
import com.ruijie.spl.billingEngine.billing.beans.BillingTemp;
import com.ruijie.spl.billingEngine.billing.entity.BusinessVolumeEntity_Ab;
import com.ruijie.spl.billingEngine.billing.entity.PersonEntity_Ab;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessOutParameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BillingEngineApplication.class)
public class RulesTest {
    @Autowired
    private BillingTemp billingTemp;
    @Autowired
    private BillingFeePackage billingFeePackage;

    private KieSession session;

    @Before
    public void beforeSet() {
        KieServices services = KieServices.Factory.get();
        KieContainer kc = services.getKieClasspathContainer();
        session = kc.newKieSession("ARuleKsession");
    }

    /*测试1000rule的逻辑是否正确*/
    @Test
    public void rule1000Test1() {
        BusinessVolumeEntity_Ab businessVolumeEntityAb = new BusinessVolumeEntity_Ab();
        businessVolumeEntityAb.setInlandDownFlow(BigDecimal.valueOf(10));

        PersonEntity_Ab entity = new PersonEntity_Ab();
//        entity.setBusinessVolumeRelation(businessVolumeEntityAb);

        session.setGlobal("billingFeeList", billingFeePackage);

        billingTemp.setInlandDownFlow(BigDecimal.valueOf(5));
        session.insert(billingTemp);
//        session.insert(entity.getBusinessVolumeRelation());
        session.fireAllRules();
        session.dispose();

        BigDecimal count = billingFeePackage.getBillingFeeList().get(billingFeePackage.getBillingFeeList().size() - 1).getBusinessVolumeAmount();
        Assert.assertEquals(BigDecimal.valueOf(10.0), count);
    }

    /*测试1000rule的逻辑是否正确*/
    @Test
    public void rule1000Test2() {
        BusinessVolumeEntity_Ab businessVolumeEntityAb = new BusinessVolumeEntity_Ab();
        businessVolumeEntityAb.setInlandDownFlow(BigDecimal.valueOf(25));

        PersonEntity_Ab entity = new PersonEntity_Ab();
//        entity.setBusinessVolumeRelation(businessVolumeEntityAb);

        session.setGlobal("billingFeeList", billingFeePackage);

        billingTemp.setInlandDownFlow(BigDecimal.valueOf(5));
        session.insert(billingTemp);
//        session.insert(entity.getBusinessVolumeRelation());
        session.fireAllRules();
        session.dispose();

        BigDecimal count = billingFeePackage.getBillingFeeList().get(billingFeePackage.getBillingFeeList().size() - 1).getBusinessVolumeAmount();
        Assert.assertEquals(BigDecimal.valueOf(5), count);
    }

    /*测试1000rule的逻辑是否正确*/
    @Test
    public void rule1000Test3() {
        BusinessVolumeEntity_Ab businessVolumeEntityAb = new BusinessVolumeEntity_Ab();
        businessVolumeEntityAb.setInlandDownFlow(BigDecimal.valueOf(10));

        PersonEntity_Ab entity = new PersonEntity_Ab();
//        entity.setBusinessVolumeRelation(businessVolumeEntityAb);

        session.setGlobal("billingFeeList", billingFeePackage);

        billingTemp.setInlandDownFlow(BigDecimal.valueOf(15));
        session.insert(billingTemp);
//        session.insert(entity.getBusinessVolumeRelation());
        session.fireAllRules();
        session.dispose();

        BigDecimal count = billingFeePackage.getBillingFeeList().get(billingFeePackage.getBillingFeeList().size() - 1).getBusinessVolumeAmount();
        Assert.assertEquals(BigDecimal.valueOf(25), count);
    }

    /*测试0000rule的逻辑是否正确*/
    @Test
    public void rule0000Test() throws ClassNotFoundException {
        LocalDateTime time = LocalDateTime.now();

        PersonEntity_Ab personEntityAb = new PersonEntity_Ab();
        personEntityAb.setNextBillingTime(time);

        PreprocessOutParameters outParameters = new PreprocessOutParameters();
        Map<String, Object> ddd = new HashMap<>();
        ddd.put("currentSystemTime", time.plusMinutes(10));
        outParameters.setPreprocessOutParameters(ddd);
//        outParameters.setCurrentSystemTime(time.plusMinutes(10));

//        Object systemTime = outParameters.getObject("currentSystemTime", Class.forName("java.time.LocalDateTime"));
//        boolean b = systemTime instanceof LocalDateTime;
        session.insert(personEntityAb);
        session.insert(outParameters);
        int i = session.fireAllRules();
        session.dispose();
        System.out.println("+++++++++++++++++++++++++++++++++++" + i);
    }
}
