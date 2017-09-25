package com.ruijie.spl.billingEngine.billing.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "userinfo")
public class UserInfo {
	@Id
	@Column(name = "userIndex")
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	private String userIndex;

	// SSID
	// queryString中取值
	@Column(name = "ssid")
	private String ssid;
	// VLANID
	// queryString中取值
	@Column(name = "vlanId")
	private Integer vlanId;

	// 设备port
	// queryString中取值
	@Column(name = "webGatePort")
	private Integer webGatePort;
	// nas port
	// 待查
	@Transient
	private int port;
	// 用户组
	// cookies中取值
	@Column(name = "userGroup")
	private String userGroup;

	// 用户名
	// 用户输入的值，request中取值
	@Column(name = "username")
	private String username;
	// 服务
	// 用户输入的值，request中取值
	@Column(name = "NET_ACCESS_TYPE")
	private String NET_ACCESS_TYPE;
	// 校验码
	// 用户输入的值，request中取值

	// 江苏电信运营商密码6小时失效
	// 用户输入的值，request中取值
	@Column(name = "operatorPwd")
	private String operatorPwd;

	// 用户套餐
	@Transient
	private String userPackage;
	// 账户余额
	@Transient
	private String accountFee;
	// 可用最大流量(MB)
	@Transient
	private String maxFlow;
	// 最大可用时长
	@Transient
	private String maxLeaving;
	// 二维码url
	@Column(name = "qrUrlSuccess")
	private String qrUrlSuccess = "";
	// 二维码类型
	// 1授权二维码 2公众二维码
	@Column(name = "strTypeAu")
	private String strTypeAu = "0";
	// 二维码编号uuid
	@Column(name = "uuidQrCode")
	private String uuidQrCode = "";
	// 用户真实姓名
	@Column(name = "userRealName")
	private String userRealName;
	// 用户年龄
	@Column(name = "useage")
	private String useage;
	// 用户年龄
	@Column(name = "mabInfo")
	private String mabInfo;
	// 用户年龄
	@Column(name = "mabInfoMaxCount")
	private Integer mabInfoMaxCount;
	// 下线url，用于显示本次上网信息（其实是自助端本子访问的）
	@Column(name = "offlineurl")
	private String offlineurl;
	// 用户被重定向时设备传的queryString
	@Column(name = "queryString")
	private String queryString;
	// 可用时长
	@Column(name = "leavingTime")
	private Integer leavingTime;
	// 上线时间
	@Column(name = "loginTime")
	private Timestamp loginTime;
	// 最近更新时间
	@Column(name = "updateTime")
	private Timestamp updateTime;
	// 刷新时间
	@Column(name = "freshTime")
	private Timestamp freshTime;
	// accSessionid
	@Column(name = "accSessionId")
	private String accSessionId;
	// 在线时长
	@Column(name = "onlineTime")
	private Long onlineTime;
	// 创建主机
	@Column(name = "CREATE_HOST")
	private String CREATE_HOST;
	// 更新主机
	@Column(name = "LAST_UPDATE_HOST")
	private String LAST_UPDATE_HOST;

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public Integer getVlanId() {
		return vlanId;
	}

	public void setVlanId(Integer vlanId) {
		this.vlanId = vlanId;
	}

	public Integer getWebGatePort() {
		return webGatePort;
	}

	public void setWebGatePort(Integer webGatePort) {
		this.webGatePort = webGatePort;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNET_ACCESS_TYPE() {
		return NET_ACCESS_TYPE;
	}

	public void setNET_ACCESS_TYPE(String nET_ACCESS_TYPE) {
		NET_ACCESS_TYPE = nET_ACCESS_TYPE;
	}

	public String getOperatorPwd() {
		return operatorPwd;
	}

	public void setOperatorPwd(String operatorPwd) {
		this.operatorPwd = operatorPwd;
	}

	public String getUserPackage() {
		return userPackage;
	}

	public void setUserPackage(String userPackage) {
		this.userPackage = userPackage;
	}

	public String getAccountFee() {
		return accountFee;
	}

	public void setAccountFee(String accountFee) {
		this.accountFee = accountFee;
	}

	public String getMaxFlow() {
		return maxFlow;
	}

	public void setMaxFlow(String maxFlow) {
		this.maxFlow = maxFlow;
	}

	public String getMaxLeaving() {
		return maxLeaving;
	}

	public void setMaxLeaving(String maxLeaving) {
		this.maxLeaving = maxLeaving;
	}

	public String getQrUrlSuccess() {
		return qrUrlSuccess;
	}

	public void setQrUrlSuccess(String qrUrlSuccess) {
		this.qrUrlSuccess = qrUrlSuccess;
	}

	public String getStrTypeAu() {
		return strTypeAu;
	}

	public void setStrTypeAu(String strTypeAu) {
		this.strTypeAu = strTypeAu;
	}

	public String getUuidQrCode() {
		return uuidQrCode;
	}

	public void setUuidQrCode(String uuidQrCode) {
		this.uuidQrCode = uuidQrCode;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUseage() {
		return useage;
	}

	public void setUseage(String useage) {
		this.useage = useage;
	}

	public String getMabInfo() {
		return mabInfo;
	}

	public void setMabInfo(String mabInfo) {
		this.mabInfo = mabInfo;
	}

	public Integer getMabInfoMaxCount() {
		return mabInfoMaxCount;
	}

	public void setMabInfoMaxCount(Integer mabInfoMaxCount) {
		this.mabInfoMaxCount = mabInfoMaxCount;
	}

	public String getOfflineurl() {
		return offlineurl;
	}

	public void setOfflineurl(String offlineurl) {
		this.offlineurl = offlineurl;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public Integer getLeavingTime() {
		return leavingTime;
	}

	public void setLeavingTime(Integer leavingTime) {
		this.leavingTime = leavingTime;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getFreshTime() {
		return freshTime;
	}

	public void setFreshTime(Timestamp freshTime) {
		this.freshTime = freshTime;
	}

	public String getAccSessionId() {
		return accSessionId;
	}

	public void setAccSessionId(String accSessionId) {
		this.accSessionId = accSessionId;
	}

	public Long getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Long onlineTime) {
		this.onlineTime = onlineTime;
	}

	public String getCREATE_HOST() {
		return CREATE_HOST;
	}

	public void setCREATE_HOST(String cREATE_HOST) {
		CREATE_HOST = cREATE_HOST;
	}

	public String getLAST_UPDATE_HOST() {
		return LAST_UPDATE_HOST;
	}

	public void setLAST_UPDATE_HOST(String lAST_UPDATE_HOST) {
		LAST_UPDATE_HOST = lAST_UPDATE_HOST;
	}

	public void setUserIndex(String userIndex) {
		this.userIndex = userIndex;
	}
}
