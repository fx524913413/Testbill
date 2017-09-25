package com.ruijie.spl.billingEngine.preprocess.drools;

import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.ruijie.spl.billingEngine.preprocess.entity.DroolRule;
import com.ruijie.spl.billingEngine.preprocess.repository.DroolsRepository;

@Configuration
public class DroolsAutoConfiguration {
	private static final String RULES_PATH = "rules/";
	@Autowired
	private DroolsRepository droolsRepository;
//	@Bean
//    @ConditionalOnMissingBean(KieBase.class)
//    public KieBase kieBase() throws IOException {
//        return kieContainer().getKieBase();
//    }

    @Bean
    @ConditionalOnMissingBean(KieSession.class)
    public KieSession kieSession() throws IOException {
        return kieContainer().newKieSession();
    }
    @Bean
    @ConditionalOnMissingBean(KieContainer.class)
    public KieContainer kieContainer() throws IOException {
        final KieRepository kieRepository = getKieServices().getRepository();
        kieRepository.addKieModule(new KieModule() {
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
        KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem()); 
        kieBuilder.buildAll();
        return getKieServices().newKieContainer(kieRepository.getDefaultReleaseId());
    }
    private KieServices getKieServices() {
        return KieServices.Factory.get();
    }
    @Bean
    @ConditionalOnMissingBean(KieFileSystem.class)
    public KieFileSystem kieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
        for (Resource file : getRuleFiles()) {
            kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + file.getFilename(), "UTF-8"));
        } 
//        kieFileSystem.write("src/main/resources/com/ruijie/spl/billingEngine/preprocess/rules/temp.drl", loadRules());
        return kieFileSystem;
    }
    private Resource[] getRuleFiles() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        return resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.*");
    }
    private String loadRules() {
        // 从数据库加载的规则
    	DroolRule droolRule=droolsRepository.findOne(12);
    	if(droolRule==null){
    		droolRule=new DroolRule();
    	}
//    	return droolsRepository.findOne(12).getDrl();
        return "package com.ruijie.spl.billingEngine.preprocess.rules \n\n import com.ruijie.spl.billingEngine.preprocess.entity.Address; \n import com.ruijie.spl.billingEngine.preprocess.entity.AddressCheckResult; \n\n rule \"Postcode 6 numbers\"\n\n    when\n  then\n        System.out.println(\"规则2中打印日志：校验通过!\");\n end";

    }
//    @Bean
//    @ConditionalOnMissingBean(KModuleBeanFactoryPostProcessor.class)
//    public KModuleBeanFactoryPostProcessor kiePostProcessor() {
//        return new KModuleBeanFactoryPostProcessor();
//    }
}
