package com.ruijie.spl.billingEngine.preprocess;


import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.test.context.junit4.SpringRunner;

import com.ruijie.spl.billingEngine.BillingEngineApplication;
import com.ruijie.spl.billingEngine.preprocess.drools.AddressCheckResult;
import com.ruijie.spl.billingEngine.preprocess.entity.Address;
import com.ruijie.spl.billingEngine.preprocess.entity.DroolRule;
import com.ruijie.spl.billingEngine.preprocess.repository.DroolsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BillingEngineApplication.class)
public class DroolsTest {
	@Autowired
    private KieSession kieSession;
	
	@Autowired
	private DroolsRepository droolsRepository;
//	@Resource
//	KieHelper kieHelper;
	@Test
	public void test(){
		 Address address = new Address();
	     address.setPostcode("99425");

	     AddressCheckResult result = new AddressCheckResult();
	     kieSession.insert(address);
	     kieSession.insert(result);
	     int ruleFiredCount = kieSession.fireAllRules();
	     kieSession.dispose();
	     System.out.println("触发了" + ruleFiredCount + "条规则");

	     if(result.isPostCodeResult()){
	         System.out.println("规则校验通过");
	     }
	}
	@Test
	public  void testKieHelper() throws IOException {
	    KieHelper kieHelper=new KieHelper();
//	    kieHelper.setClassLoader("");
	    
	    //加载drl文件，并写入KieFileSystem；此步骤必须在获取kieSession之前
	    ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources=resourcePatternResolver.getResources("classpath*:" + "com/ruijie/spl/billingEngine/preprocess/rules/"+ "**/*.*");
        for (Resource file : resources) {
        	 kieHelper.addResource(ResourceFactory.newClassPathResource("com/ruijie/spl/billingEngine/preprocess/rules/" + file.getFilename(), "UTF-8"));
        } 
        //获取kieSession
	    KieSession kieSession=kieHelper.build().newKieSession();
		
		Address address = new Address();
		AddressCheckResult result = new AddressCheckResult();
	    address.setPostcode("99425");
		kieSession.insert(address);
		kieSession.insert(result);//drl中，when用到了，如果不insert，则不符合条件
		int ruleFiredCount =kieSession.fireAllRules();
		System.out.println("触发了" + ruleFiredCount + "条规则");
	}
	@Test
	public void testAdd(){
		System.out.println("执行testAdd");
		DroolRule droolRule=new DroolRule();
		String drl="package com.ruijie.spl.billingEngine.preprocess.rules \n\n import com.ruijie.spl.billingEngine.preprocess.entity.Address; \n import com.ruijie.spl.billingEngine.preprocess.entity.AddressCheckResult; \n\n rule \"Postcode 6 numbers\"\n\n    when\n  then\n        System.out.println(\"规则2中打印日志：校验通过!\");\n end";
		droolRule.setDrl(drl);
		droolsRepository.save(droolRule);
	}
	@Test
	public void testFind(){
		System.out.println("执行testfind");
		DroolRule droolRule=droolsRepository.findOne(12);
		System.out.println("drl:"+droolRule.getDrl());
	}
}
