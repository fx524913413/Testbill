package com.ruijie.spl.billingEngine.filters;

import java.util.ArrayList;
import java.util.List;

import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessReturnParameters;


public class BillingEnginFilterChain implements BillingEnginFilter{
	List<BillingEnginFilter> fs = new ArrayList<BillingEnginFilter>();
	int index = 0;
	
	public BillingEnginFilterChain addFilter(BillingEnginFilter f) {
		 fs.add(f);
		 return this;
	}
	@Override
	public void doFilter(PreprocessInParameters preprocessInParameters,
			PreprocessReturnParameters preprocessReturnParameters, BillingEnginFilterChain chain) {
		if(index == fs.size()) 
			return;
		BillingEnginFilter f = fs.get(index);
		index ++;
		f.doFilter(preprocessInParameters, preprocessReturnParameters, chain);
	}


}
