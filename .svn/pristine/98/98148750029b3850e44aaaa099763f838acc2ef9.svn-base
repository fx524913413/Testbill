package com.ruijie.spl.billingEngine.preprocess.service;

import java.util.Map;

import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessOutParameters;

/**
 * 开户预处理
 * @author Administrator
 *
 */
public class PreprocessForOpenUser implements PreprocessForBillEngine {
	
	PreprocessOutParameters preprocessOutParameters;

	@Override
	public void preprocess(PreprocessInParameters preprocessInParameters) {
		//预处理与开户相关的属性
		Map<String, Object> map =preprocessOutParameters.getPreprocessOutParameters();
		map.put("eventType", preprocessInParameters.getEventType());
		map.put("userId", preprocessInParameters.getUserId());
		
		//开户预处理完成后，调用批价模块的接口，将参数传过去
		//批价处理接口循环取出map中的元素即可
		
		
	}

}
