package com.ruijie.spl.billingEngine.booking.entity;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User_info")
public class User_info {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_uuid")
	private UUID useruuid;

	@Column(name = "user_name")
	private String username;

	@Column(name = "acountName")
	private String acountName; //如果用户开了两个或者多个账户，则通过此字段标记，而具体区别则使用UUID

	@Column(name = "accountDesc")
	private String accountDesc;

	@Column(name = "CreateManagerID")
    private String CreateManagerID;

	@Column(name = "CreateTime")
    private String CreateTime;

	@Column(name = "LastUpDateTime")
    private String LastUpDateTime;

	@Column(name = "CreateHost")
    private String CreateHost;

	@Column(name = "LastUpDateHost")
    private String LastUpDateHost;

	@Column(name = "usergroup")
	private String usergroup;

	@Column(name = "IsFundCreateuserFee")
    private String IsFundCreateuserFee;
	//开户费

	@Column(name = "UnpaidAmount")
    private String UnpaidAmount;
	//未付费数量 企业版专有


	public UUID getUseruuid() {
		return useruuid;
	}

	public void setUseruuid(UUID useruuid) {
		this.useruuid = useruuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getaccountDesc() {
		return accountDesc;
	}

	public void setaccountDesc(String accountDesc) {
		accountDesc = accountDesc;
	}

	public String getCreateManagerID() {
		return CreateManagerID;
	}

	public void setCreateManagerID(String createManagerID) {
		CreateManagerID = createManagerID;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getLastUpDateTime() {
		return LastUpDateTime;
	}

	public void setLastUpDateTime(String lastUpDateTime) {
		LastUpDateTime = lastUpDateTime;
	}

	public String getCreateHost() {
		return CreateHost;
	}

	public void setCreateHost(String createHost) {
		CreateHost = createHost;
	}

	public String getLastUpDateHost() {
		return LastUpDateHost;
	}

	public void setLastUpDateHost(String lastUpDateHost) {
		LastUpDateHost = lastUpDateHost;
	}

	public String getIsFundCreateuserFee() {
		return IsFundCreateuserFee;
	}

	public void setIsFundCreateuserFee(String isFundCreateuserFee) {
		IsFundCreateuserFee = isFundCreateuserFee;
	}

	public String getUnpaidAmount() {
		return UnpaidAmount;
	}

	public void setUnpaidAmount(String unpaidAmount) {
		UnpaidAmount = unpaidAmount;
	}

	public String getUsergroup() {
		return usergroup;
	}

	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public String getAcountName() {
		return acountName;
	}

	public void setAcountName(String acountName) {
		this.acountName = acountName;
	}
}