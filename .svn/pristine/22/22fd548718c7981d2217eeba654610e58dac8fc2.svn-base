package com.ruijie.spl.billingEngine.interfacebean.ruleEngine;

import org.kie.api.runtime.KieSession;

/**
 * Created by Administrator on 2017/8/30.
 */
public interface RuleEngineService {

    void addDrlFile(String drlFile);

    KieSession buildSessoin();

    void addFacts(Object facts) throws Exception;

    int execution();

    void setGlobal(String s, Object o);

    KieSession getSessioin();
}
