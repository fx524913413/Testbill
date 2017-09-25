package com.ruijie.spl.billingEngine.billing.entity;

import com.ruijie.spl.billingEngine.billing.dataEnum.AccountLevelEnum;
import com.ruijie.spl.billingEngine.billing.dataEnum.AccountStateEnum;
import com.ruijie.spl.billingEngine.billing.dataEnum.BusinessVolumeTypeEnum;
import com.ruijie.spl.billingEngine.billing.dataEnum.FeeObjectUnitEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/8.
 * 账户信息实体
 */
//@Entity
//@Table(name = "accountInfo_Table")
public class AccountInfoEntity_Ab {
    private UUID accountUUID;
    private String accountName;
    private AccountStateEnum accountState;
    private BigDecimal lowerLimit;
    private BigDecimal upperLimit;
    private String description;
    private AccountLevelEnum accountLevel;
    private boolean canAccountUse;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private PersonEntity_Ab personRelation;
    private BigDecimal feeObjectAmount;
    private BusinessVolumeTypeEnum feeObjectType;
    private FeeObjectUnitEnum feeObjectUnit;
    private String tariffStrategyName;
    private LocalDateTime nextBillingTime;
    private Set<BusinessVolumeEntity_Ab> businessVolumeRelation;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_UUID")
    public UUID getAccountUUID() {
        return accountUUID;
    }

    public void setAccountUUID(UUID accountUUID) {
        this.accountUUID = accountUUID;
    }

    @Column(name = "accountName")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "create_Time")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_Time")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "nextBilling_Time")
    public LocalDateTime getNextBillingTime() {
        return nextBillingTime;
    }

    public void setNextBillingTime(LocalDateTime nextBillingTime) {
        this.nextBillingTime = nextBillingTime;
    }

    @Column(name = "account_State")
    public AccountStateEnum getAccountState() {
        return accountState;
    }

    public void setAccountState(AccountStateEnum accountState) {
        this.accountState = accountState;
    }

    @Column(name = "lower_Limit")
    public BigDecimal getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(BigDecimal lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    @Column(name = "upper_Limit")
    public BigDecimal getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(BigDecimal upperLimit) {
        this.upperLimit = upperLimit;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "account_Level")
    public AccountLevelEnum getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(AccountLevelEnum accountLevel) {
        this.accountLevel = accountLevel;
    }

    @Column(name = "can_AccountUse")
    public boolean isCanAccountUse() {
        return canAccountUse;
    }

    public void setCanAccountUse(boolean canAccountUse) {
        this.canAccountUse = canAccountUse;
    }

    @ManyToOne
    @JoinColumn(name = "person_Relation", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    public PersonEntity_Ab getPersonRelation() {
        return personRelation;
    }

    public void setPersonRelation(PersonEntity_Ab personRelation) {
        this.personRelation = personRelation;
    }

    @Column(name = "feeObject_Amount")
    public BigDecimal getFeeObjectAmount() {
        return feeObjectAmount;
    }

    public void setFeeObjectAmount(BigDecimal feeObjectAmount) {
        this.feeObjectAmount = feeObjectAmount;
    }

    @Column(name = "feeObject_Type")
    public BusinessVolumeTypeEnum getFeeObjectType() {
        return feeObjectType;
    }

    public void setFeeObjectType(BusinessVolumeTypeEnum feeObjectType) {
        this.feeObjectType = feeObjectType;
    }

    @Column(name = "feeObject_Unit")
    public FeeObjectUnitEnum getFeeObjectUnit() {
        return feeObjectUnit;
    }

    public void setFeeObjectUnit(FeeObjectUnitEnum feeObjectUnit) {
        this.feeObjectUnit = feeObjectUnit;
    }

    @Column(name = "tariffStrategy_name")
    public String getTariffStrategyName() {
        return tariffStrategyName;
    }

    public void setTariffStrategyName(String tariffStrategyName) {
        this.tariffStrategyName = tariffStrategyName;
    }

    @OneToMany(targetEntity = BusinessVolumeEntity_Ab.class, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    public Set<BusinessVolumeEntity_Ab> getBusinessVolumeRelation() {
        if (businessVolumeRelation == null)
            businessVolumeRelation = new HashSet<>();
        return businessVolumeRelation;
    }

    public void setBusinessVolumeRelation(Set<BusinessVolumeEntity_Ab> businessVolumeRelation) {
        this.businessVolumeRelation = businessVolumeRelation;
    }
}
