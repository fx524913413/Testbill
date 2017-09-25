package com.ruijie.spl.billingEngine.interf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruijie.spl.billingEngine.filters.BillingEnginFilterChain;
import com.ruijie.spl.billingEngine.filters.BillingFilter;
import com.ruijie.spl.billingEngine.filters.BookingFilter;
import com.ruijie.spl.billingEngine.filters.PreprocessFilter;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessReturnParameters;

@Component
public class BillingEngineServiceImpl implements BillingEngineService {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	PreprocessFilter preprocessFilter;
	@Autowired
	BillingFilter billingFilter;
	@Autowired
	BookingFilter bookingFilter;
	@Override
	public PreprocessReturnParameters inputParametersToBillingEngine(PreprocessInParameters preprocessInParameters) {
		BillingEnginFilterChain fc = new BillingEnginFilterChain();
		PreprocessReturnParameters preprocessReturnParameters=new PreprocessReturnParameters();
		//添加计费引擎各模块filter
		//暂时先写死，后期做成可配置模式
//		fc.addFilter(new PreprocessFilter()).addFilter(new BillingFilter()).addFilter(new BookingFilter());
		fc.addFilter(preprocessFilter).addFilter(billingFilter).addFilter(bookingFilter); 
		
	    fc.doFilter(preprocessInParameters, preprocessReturnParameters,fc);
	    
	    //测试输出
	    if(logger.isDebugEnabled()){
	    	logger.debug("LeftTime:"+preprocessReturnParameters.getLeftTime());
	    }
		return preprocessReturnParameters;
	}

}
