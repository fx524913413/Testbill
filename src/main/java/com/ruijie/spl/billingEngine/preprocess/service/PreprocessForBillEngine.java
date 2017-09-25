package com.ruijie.spl.billingEngine.preprocess.service;

import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;

/**
 * 预处理模块处理各计费事件接口
 * @author Administrator
 *
 */
public interface PreprocessForBillEngine {
	public void preprocess(PreprocessInParameters preprocessInParameters);
}
