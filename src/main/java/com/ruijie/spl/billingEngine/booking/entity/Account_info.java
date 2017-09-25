package com.ruijie.spl.billingEngine.booking.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Account_info")
public class Account_info {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_uuid")
    private UUID AccountUUID;

    @Column(name = "user_uuid")
    private UUID useruuid;

    @Column(name = "Account_Type")
    private String accountType;

    @Column(name = "Amount")
    private Double Amount;

    @Column(name = "Unit")
    private String Unit;

    @Column(name = "User_name")
    private String username;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "fatheraccount")
    private boolean fatheraccount;  //用于余额账户判断是否开启信用账户用

    @Column(name = "busineseeType")
    private String businessType;  //用于判断是否是分段流量账户

/*    @ManyToOne
    @JoinColumn(name="Account_info")
    private User_info UserInfo;*/

    public UUID getAccountUUID() {
        return AccountUUID;
    }

    public void setAccountUUID(UUID accountUUID) {
        AccountUUID = accountUUID;
    }

    public UUID getUseruuid() {
        return useruuid;
    }

    public void setUseruuid(UUID useruuid) {
        this.useruuid = useruuid;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userid) {
        this.username = userid;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean isFatheraccount() {
        return fatheraccount;
    }

    public void setFatheraccount(boolean fatheraccount) {
        this.fatheraccount = fatheraccount;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
}
