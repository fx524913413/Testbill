package com.ruijie.spl.billingEngine.common.helper;

import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

/**
 * Created by Administrator on 2017/9/1.
 * 规则引擎的使用类；使用该类时通常不需要多次添加drl文件或Facts
 */
public class RuleEngineUtil {

    public static int executionSessionStatefule(Object facts, String sessionName) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession(sessionName);

        kieSession.insert(facts);

        int rules = kieSession.fireAllRules();
        kieSession.destroy();
        return rules;
    }

    public static int executionSessionStateful(Object facts, String drlFile) throws Exception {

        KieHelper helper = new KieHelper();
        helper.addContent(drlFile, ResourceType.DRL);
        KieSession ks = helper.build().newKieSession();

//        KieServices kieServices = KieServices.Factory.get();
//        KieFileSystem kfs = kieServices.newKieFileSystem();
//        kfs.write("src/main/resources/rules/rules.drl",drlFile.getBytes());

//        List<PersonEntity_Ab> sss = (List<PersonEntity_Ab>) facts;
//        sss.stream().forEach(s -> ks.insert(s));
        ks.insert(facts);
        int rules = ks.fireAllRules();
        ks.dispose();
        return rules;
    }
}
