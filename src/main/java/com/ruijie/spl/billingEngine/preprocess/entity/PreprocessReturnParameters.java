package com.ruijie.spl.billingEngine.preprocess.entity;

import java.math.BigDecimal;

public class PreprocessReturnParameters {
	private String userId;              //用户名
	private Long leftTime;				//剩余时长
	private BigDecimal leftTraffic;		//剩余1X流量
	private BigDecimal foreignUpFlow;   //剩余国际上流量
	private BigDecimal foreignDownFlow;	//剩余国际下流量
	private BigDecimal inlandUpFlow;	//剩余国内上流量
	private BigDecimal inlandDownFlow;	//剩余国内下流量
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getLeftTime() {
		return leftTime;
	}
	public void setLeftTime(Long leftTime) {
		this.leftTime = leftTime;
	}
	public BigDecimal getLeftTraffic() {
		return leftTraffic;
	}
	public void setLeftTraffic(BigDecimal leftTraffic) {
		this.leftTraffic = leftTraffic;
	}
	public BigDecimal getForeignUpFlow() {
		return foreignUpFlow;
	}
	public void setForeignUpFlow(BigDecimal foreignUpFlow) {
		this.foreignUpFlow = foreignUpFlow;
	}
	public BigDecimal getForeignDownFlow() {
		return foreignDownFlow;
	}
	public void setForeignDownFlow(BigDecimal foreignDownFlow) {
		this.foreignDownFlow = foreignDownFlow;
	}
	public BigDecimal getInlandUpFlow() {
		return inlandUpFlow;
	}
	public void setInlandUpFlow(BigDecimal inlandUpFlow) {
		this.inlandUpFlow = inlandUpFlow;
	}
	public BigDecimal getInlandDownFlow() {
		return inlandDownFlow;
	}
	public void setInlandDownFlow(BigDecimal inlandDownFlow) {
		this.inlandDownFlow = inlandDownFlow;
	}

	
}
