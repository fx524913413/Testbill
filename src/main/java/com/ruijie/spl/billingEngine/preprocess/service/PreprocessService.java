package com.ruijie.spl.billingEngine.preprocess.service;

import org.springframework.stereotype.Component;

import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessReturnParameters;
/**
 * 计费引擎预处理模块的总入口，用于计费引擎内部模块调用
 * @author Administrator
 *
 */
public interface PreprocessService {
	
	public void inputParametersToPreprocess(PreprocessInParameters preprocessInParameters,PreprocessReturnParameters preprocessReturnParameters);
}
