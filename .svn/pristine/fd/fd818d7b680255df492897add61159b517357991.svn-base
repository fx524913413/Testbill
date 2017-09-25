package com.ruijie.spl.billingEngine.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Bill")
public class Bill {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID acct_flow_uuid;

	@Column(name = "useruuid")
	private UUID useruuid;

	@Column(name = "username")
	private String username;

	@Column(name = "AccountDesc")
	private String AccountDesc;

	@Column(name = "accountUUID")
	private UUID accountUUID;

	@Column(name = "accountType")
	private String accountType;

	@Column(name = "accountName")
	private String accountName; //如果用户开了两个或者多个账户，则通过此字段标记，而具体区别则使用UUID

	@Column(name = "usergroup")
	private String usergroup;

	@Column(name = "sourcefeeitem")
	private String sourcefeeitem; //费用类型

	@Column(name = "billAmount")
	private double billAmount; //费用量

	@Column(name = "createdDate")
	private String createdDate;

	@Column(name = "AccountAmount")
	private double accountAmount; //账户现存数据量

	@Column(name = "Detailrecord")
    private String Detailrecord;

	@Column(name = "SourceFeeID")
    private String SourceFeeID;

	@Column(name = "flow")
	private double flow;

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

	public UUID getAcct_flow_uuid() {
		return acct_flow_uuid;
	}

	public void setAcct_flow_uuid(UUID acct_flow_uuid) {
		this.acct_flow_uuid = acct_flow_uuid;
	}

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

	public UUID getAccountUUID() {
		return accountUUID;
	}

	public void setAccountUUID(UUID accountUUID) {
		this.accountUUID = accountUUID;
	}

	public String getSourcefeeitem() {
		return sourcefeeitem;
	}

	public void setSourcefeeitem(String sourcefeeitem) {
		this.sourcefeeitem = sourcefeeitem;
	}

	public double getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(double accountAmount) {
		accountAmount = accountAmount;
	}

	public String getDetailrecord() {
		return Detailrecord;
	}

	public void setDetailrecord(String detailrecord) {
		Detailrecord = detailrecord;
	}

	public String getSourceFeeID() {
		return SourceFeeID;
	}

	public void setSourceFeeID(String sourceFeeID) {
		SourceFeeID = sourceFeeID;
	}

	public String getAccountDesc() {
		return AccountDesc;
	}

	public void setAccountDesc(String accountDesc) {
		AccountDesc = accountDesc;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getUsergroup() {
		return usergroup;
	}

	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}