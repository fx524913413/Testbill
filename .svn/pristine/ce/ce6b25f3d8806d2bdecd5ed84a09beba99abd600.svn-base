package com.ruijie.spl.billingEngine.preprocess.service;

import java.io.IOException;

import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessInParameters;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessResponse;
import com.ruijie.spl.billingEngine.preprocess.entity.PreprocessReturnParameters;
import com.ruijie.spl.billingEngine.preprocess.filters.CreateUserFilter;
import com.ruijie.spl.billingEngine.preprocess.filters.FilterChain;
import com.ruijie.spl.billingEngine.preprocess.filters.IpfixFilter;
@Component
public class PreprocessServiceImpl implements PreprocessService {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	CreateUserFilter createUserFilter;
	@Autowired
	IpfixFilter ipfixFilter;
	@Override
	public void inputParametersToPreprocess(PreprocessInParameters preprocessInParameters,PreprocessReturnParameters preprocessReturnParameters) {
		FilterChain fc = new FilterChain();
		PreprocessResponse preprocessResponse=new PreprocessResponse();
		//加载各计费事件的预处理filter
		//暂时先写死，后期做成可配置模式
//		fc.addFilter(new CreateUserFilter()).addFilter(new IpfixFilter());
		fc.addFilter(createUserFilter).addFilter(ipfixFilter);
	     
	    fc.doFilter(preprocessInParameters, preprocessResponse,fc);
	    
	    if(logger.isDebugEnabled()){
	    	logger.debug("预处理模块执行的Filter:"+preprocessResponse.getPreprocessResponseStr());
	    }
	    
	}
	
	
//	@Override
//	public void inputParametersToPreprocess(PreprocessInParameters preprocessInParameters) {
//		
//		KieHelper kieHelper=new KieHelper();
//		//加载drl文件，并写入KieFileSystem；此步骤必须在获取kieSession之前
//	    ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//		try {
//			Resource[] resources = resourcePatternResolver.getResources("classpath*:" + "com/ruijie/spl/billingEngine/preprocess/rules/"+ "**/*.*");
//			for (Resource file : resources) {
//	        	 kieHelper.addResource(ResourceFactory.newClassPathResource("com/ruijie/spl/billingEngine/preprocess/rules/" + file.getFilename(), "UTF-8"));
//	        } 
//	        //获取kieSession
//			KieSession kieSession =kieHelper.build().newKieSession();
//			 
//			kieSession.insert(preprocessInParameters);
//		    int ruleFiredCount = kieSession.fireAllRules();
//		    kieSession.dispose();
//		    if(logger.isDebugEnabled()){
//		    	logger.debug("触发了" + ruleFiredCount + "条规则"); 
//		    }
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//	}

}
