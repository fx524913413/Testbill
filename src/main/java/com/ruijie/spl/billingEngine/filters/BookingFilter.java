package com.ruijie.spl.billingEngine.filters;

import org.springframework.stereotype.Component;

import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessReturnParameters;
/**
 * 计费引擎记账模块filter
 * @author Administrator
 *
 */
@Component
public class BookingFilter implements BillingEnginFilter{

	@Override
	public void doFilter(PreprocessInParameters preprocessInParameters,
			PreprocessReturnParameters preprocessReturnParameters, BillingEnginFilterChain chain) {
		// TODO Auto-generated method stub
		
	}

}
