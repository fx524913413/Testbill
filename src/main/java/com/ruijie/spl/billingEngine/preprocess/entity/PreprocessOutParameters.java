package com.ruijie.spl.billingEngine.preprocess.entity;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PreprocessOutParameters {
    private Map<String, Object> preprocessOutParameters;     //preprocess预处理模块输出map

    public Map<String, Object> getPreprocessOutParameters() {
        if (preprocessOutParameters == null)
            preprocessOutParameters = new HashMap<>();
        return preprocessOutParameters;
    }

    public void setPreprocessOutParameters(Map<String, Object> preprocessOutParameters) {
        this.preprocessOutParameters = preprocessOutParameters;
    }

//	private int eventType;                    //事件类型
//	private String userId;                    //用户名
//	private String accountId;				  //账户名
//	private String userPackage;				  //套餐信息，类型暂定为string
//	private Date createTime;				  //开户时间
//	private String accountUuid;               //账户uuid
//	private int feeTpye;					  //操作费用类型，0-缴费 1-退费 
//	private BigDecimal fee;					  //操作的金额
//	private int feeUnit;					  //操作的金额单位
//	private String serviceId;				  //服务名
//	private String areaUuid;				  //地区uuid
//	private int  acctType;					 //radius记账类型：1-记账开始 2记账结束  3-记账更新
//	private String SessionId;				 //在线用户唯一标识
//	private Long SessionTime;				 //在线时长
//	private BigDecimal usedtraffic;			 //1X流量
//	private String packagerule;				 //套餐规则
//	private String deviceIp;				 //设备Ip
//	private BigDecimal foreignUpFlow;		 //ipfix报文中国际上行流量
//	private BigDecimal foreignDownFlow;		 //ipfix报文中国际下行流量
//	private BigDecimal inlandUpFlow;		 //ipfix报文中国内上行流量
//	private BigDecimal inlandDownFlow;		 //ipfix报文中国内下行流量
//	private BigDecimal campusUpFlow;		 //ipfix报文中校园上行流量
//	private BigDecimal campusDownFlow;		 //ipfix报文中校园下行流量
//	private BigDecimal ntdFlowSum;			 //ipfix报文中网关总流量
//	private String flowRefuelPackageUuid;    //流量控制策略uuid
//	private int postponeType;				 //周期补偿类型
//	private int postponeValue;				 //补偿量
//	private String oldpackage;				 //变更前套餐
//	private String newpackage;				 //变更后套餐
//	private int changeTime;					 //套餐变更生效时间


}
