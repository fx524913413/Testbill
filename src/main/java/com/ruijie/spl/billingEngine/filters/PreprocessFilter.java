package com.ruijie.spl.billingEngine.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessReturnParameters;
import com.ruijie.spl.billingEngine.preprocess.service.PreprocessService;

/**
 * 计费引擎预处理模块filter
 * @author Administrator
 *
 */
@Component
public class PreprocessFilter implements BillingEnginFilter{
	@Autowired
	PreprocessService preprocessService;
	
	@Override
	public void doFilter(PreprocessInParameters preprocessInParameters,
			PreprocessReturnParameters preprocessReturnParameters, BillingEnginFilterChain chain) {
		
		//按照目前需求，参数preprocessReturnParameters不需要在预处理模块处理；
		//参数preprocessInParameters只需要在预处理模块处理；
		preprocessService.inputParametersToPreprocess(preprocessInParameters,preprocessReturnParameters);
		
//		preprocessReturnParameters.setLeftTime(110L);//测试数据
		
		chain.doFilter(preprocessInParameters, preprocessReturnParameters, chain);
	}

}
