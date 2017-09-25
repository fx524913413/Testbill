package com.ruijie.spl.billingEngine.preprocess.filters;

import org.springframework.stereotype.Component;

import com.ruijie.spl.billingEngine.preprocess.collection.BillingEventCollection;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessResponse;
@Component
public class IpfixFilter implements Filter {

	@Override
	public void doFilter(PreprocessInParameters preprocessInParameters,
			PreprocessResponse preprocessResponse, FilterChain chain) {
		// TODO Auto-generated method stub
		if(preprocessInParameters.getEventType()==BillingEventCollection.IPFIX){
			//Ipfix报文预处理
			
			
			preprocessResponse.setPreprocessResponseStr(preprocessResponse.getPreprocessResponseStr()+"--IPFIX--");
		}
		
		chain.doFilter(preprocessInParameters, preprocessResponse, chain);
	}

}
