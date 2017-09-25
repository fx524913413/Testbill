package com.ruijie.spl.billingEngine.preprocess.filters;

import java.util.ArrayList;
import java.util.List;

import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessResponse;

public class FilterChain implements Filter{

	List<Filter> fs = new ArrayList<Filter>();
	int index = 0;
	
	public FilterChain addFilter(Filter f) {
		 fs.add(f);
		 return this;
	}
	@Override
	public void doFilter(PreprocessInParameters preprocessInParameters,
			PreprocessResponse preprocessResponse, FilterChain chain) {
		// TODO Auto-generated method stub
		if(index == fs.size()) 
			return;
		Filter fc = fs.get(index);
		index ++;
		
		fc.doFilter(preprocessInParameters, preprocessResponse, chain);
		
	}

}
