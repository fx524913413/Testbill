package com.ruijie.spl.billingEngine.billing.service;

import com.ruijie.spl.billingEngine.interfacebean.ruleEngine.RuleEngineService;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/30.
 */
@Component
public class RuleEngineServiceImpl implements RuleEngineService {
    private KieHelper helper = new KieHelper();
    private KieSession ks;

    @Override
    public void addDrlFile(String drlFile) {
        helper.addContent(drlFile, ResourceType.DRL);
    }

    @Override
    public KieSession buildSessoin() {
        ks = helper.build().newKieSession();
        return ks;
    }

    @Override
    public void addFacts(Object facts) throws Exception {
        if (ks == null)
            throw new Exception();

        ks.insert(facts);
    }

    @Override
    public int execution() {
        if (ks == null)
            return -1;

        int rules = ks.fireAllRules();
        ks.dispose();
        return rules;
    }

    @Override
    public void setGlobal(String s, Object o) {
        if (ks == null)
            return;

        ks.setGlobal(s, o);
    }

    @Override
    public KieSession getSessioin() {
        return ks;
    }
}
