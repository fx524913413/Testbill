package com.ruijie.spl.billingEngine.preprocess.filters;

import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessResponse;

public interface Filter {
	void doFilter(PreprocessInParameters preprocessInParameters,PreprocessResponse preprocessResponse,FilterChain chain);
}
