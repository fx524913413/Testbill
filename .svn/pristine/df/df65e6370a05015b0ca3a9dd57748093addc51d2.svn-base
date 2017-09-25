package com.ruijie.spl.billingEngine.billing.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ruijie.spl.billingEngine.billing.dataEnum.BusinessVolumeTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/9/4.
 * 用户的累积量信息表（暂未完全设计）
 */
//@Entity
//@Table(name = "BusinessVolume_Table")
public class BusinessVolumeEntity_Ab {
    private Long id;
    private BigDecimal foreignUpFlow;
    private BigDecimal foreignDownFlow;
    private BigDecimal inlandUpFlow;
    private BigDecimal inlandDownFlow;
    private BigDecimal sessionTime;
    private AccountInfoEntity_Ab accountRelation;
    private BusinessVolumeTypeEnum businessVolumeType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "businessVolume_Id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "foreignUp_Flow")
    public BigDecimal getForeignUpFlow() {
        return foreignUpFlow;
    }

    public void setForeignUpFlow(BigDecimal foreignUpFlow) {
        this.foreignUpFlow = foreignUpFlow;
    }

    @Column(name = "foreignDown_Flow")
    public BigDecimal getForeignDownFlow() {
        return foreignDownFlow;
    }

    public void setForeignDownFlow(BigDecimal foreignDownFlow) {
        this.foreignDownFlow = foreignDownFlow;
    }

    @Column(name = "inlandUp_Flow")
    public BigDecimal getInlandUpFlow() {
        return inlandUpFlow;
    }

    public void setInlandUpFlow(BigDecimal inlandUpFlow) {
        this.inlandUpFlow = inlandUpFlow;
    }

    @Column(name = "inlandDown_Flow")
    public BigDecimal getInlandDownFlow() {
        return inlandDownFlow;
    }

    public void setInlandDownFlow(BigDecimal inlandDownFlow) {
        this.inlandDownFlow = inlandDownFlow;
    }

    @ManyToOne(targetEntity = AccountInfoEntity_Ab.class)
    @JoinColumn(name = "account_Relation", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    public AccountInfoEntity_Ab getAccountRelation() {
        return accountRelation;
    }

    @JsonBackReference
    public void setAccountRelation(AccountInfoEntity_Ab accountRelation) {
        this.accountRelation = accountRelation;
    }

    @Column(name = "session_Time")
    public BigDecimal getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(BigDecimal sessionTime) {
        this.sessionTime = sessionTime;
    }

    @Column(name = "businessVolume_Type")
    public BusinessVolumeTypeEnum getBusinessVolumeType() {
        return businessVolumeType;
    }

    public void setBusinessVolumeType(BusinessVolumeTypeEnum businessVolumeType) {
        this.businessVolumeType = businessVolumeType;
    }
}
