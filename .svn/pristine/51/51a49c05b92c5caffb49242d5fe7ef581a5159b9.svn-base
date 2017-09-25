package com.ruijie.spl.billingEngine.preprocess.filters;

import org.springframework.stereotype.Component;

import com.ruijie.spl.billingEngine.preprocess.collection.BillingEventCollection;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessResponse;
/**
 * 开户操作的预处理filter
 * @author Administrator
 *
 */
@Component
public class CreateUserFilter implements Filter{

	@Override
	public void doFilter(PreprocessInParameters preprocessInParameters,
			PreprocessResponse preprocessResponse, FilterChain chain) {
		// TODO Auto-generated method stub
		if(preprocessInParameters.getEventType()==BillingEventCollection.CREATE_USER){
			//开户操作的预处理
			
			
			preprocessResponse.setPreprocessResponseStr(preprocessResponse.getPreprocessResponseStr()+"--CREATE_USER--");
		}
		
		chain.doFilter(preprocessInParameters, preprocessResponse, chain);
	}
	
}
