package com.ruijie.spl.billingEngine.filters;

import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessReturnParameters;

public interface BillingEnginFilter {
	void doFilter(PreprocessInParameters preprocessInParameters,
			PreprocessReturnParameters preprocessReturnParameters,BillingEnginFilterChain chain);
}
