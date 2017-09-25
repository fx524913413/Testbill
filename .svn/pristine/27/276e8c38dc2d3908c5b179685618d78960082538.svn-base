package com.ruijie.spl.billingEngine.preprocess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ruijie.spl.billingEngine.BillingEngineApplication;
import com.ruijie.spl.billingEngine.interf.BillingEngineService;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BillingEngineApplication.class)
public class ChainTest {
	
	@Autowired
	BillingEngineService billingEngineService;
	@Test
	public void test(){
		PreprocessInParameters preprocessInParameters=new PreprocessInParameters();
		
		preprocessInParameters.setEventType(1);
		
		billingEngineService.inputParametersToBillingEngine(preprocessInParameters);
	}
}
