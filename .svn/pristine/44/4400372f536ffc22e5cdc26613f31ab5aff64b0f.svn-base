package com.ruijie.spl.billingEngine.billing.entity_NoForeignKey;

import com.ruijie.spl.billingEngine.billing.dataEnum.AccountStateEnum;
import com.ruijie.spl.billingEngine.billing.dataEnum.BusinessVolumeTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/8.
 * 账户信息实体
 */
@Entity
@Table(name = "accountInfo_Table")
public class AccountInfoEntity {
    private UUID accountUUID;
    private String accountName;                             //账户名称
    private AccountStateEnum accountState;                  //账户状态
    private BigDecimal lowerLimit;                          //账户余额下限
    private BigDecimal upperLimit;                          //账户余额上限
    private String description;                             //账户描述
    //    private AccountLevelEnum accountLevel;                  //账户使用级别
    private String accountLabel;                            //账务标志，判别费用归属时使用
    private boolean canAccountUse;                          //账户是否可用标识
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private BigDecimal feeObjectAmount;                     //账户余额（属于某种业务量）

    private UUID personAccountRelationUuid;
//    private UUID account_bVolume_RelationUuid;

    //    private BusinessVolumeTypeEnum businessVolumeOutType;      //账户记录输出业务量的类型
    private BusinessVolumeTypeEnum businessVolumeType;       //账户记录输入业务量类型
//    private BigDecimal feeObjectRate;                       //费率
//    private FeeObjectUnitEnum feeObjectSonUnit;             //费率分子单位
//    private FeeObjectUnitEnum feeObjectMotherUnit;          //费率分母单位

    private String tariffStrategyName;                      //对应的资费策略的名称
    private LocalDateTime nextBillingTime;                  //下次记账时间

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

//    @Column(name = "account_Level")
//    public AccountLevelEnum getAccountLevel() {
//        return accountLevel;
//    }
//
//    public void setAccountLevel(AccountLevelEnum accountLevel) {
//        this.accountLevel = accountLevel;
//    }

    @Column(name = "can_AccountUse")
    public boolean isCanAccountUse() {
        return canAccountUse;
    }

    public void setCanAccountUse(boolean canAccountUse) {
        this.canAccountUse = canAccountUse;
    }

    @Column(name = "person_Relation_UUID")
    public UUID getPersonAccountRelationUuid() {
        return personAccountRelationUuid;
    }

    public void setPersonAccountRelationUuid(UUID personAccountRelationUuid) {
        this.personAccountRelationUuid = personAccountRelationUuid;
    }

    @Column(name = "feeObject_Amount")
    public BigDecimal getFeeObjectAmount() {
        return feeObjectAmount;
    }

    public void setFeeObjectAmount(BigDecimal feeObjectAmount) {
        this.feeObjectAmount = feeObjectAmount;
    }

//    @Column(name = "businessVolumeOut_Type")
//    public BusinessVolumeTypeEnum getBusinessVolumeOutType() {
//        return businessVolumeOutType;
//    }
//
//    public void setBusinessVolumeOutType(BusinessVolumeTypeEnum businessVolumeOutType) {
//        this.businessVolumeOutType = businessVolumeOutType;
//    }
//
//    @Column(name = "feeObject_motherUnit")
//    public FeeObjectUnitEnum getFeeObjectMotherUnit() {
//        return feeObjectMotherUnit;
//    }
//
//    public void setFeeObjectMotherUnit(FeeObjectUnitEnum feeObjectMotherUnit) {
//        this.feeObjectMotherUnit = feeObjectMotherUnit;
//    }

    @Column(name = "tariffStrategy_name")
    public String getTariffStrategyName() {
        return tariffStrategyName;
    }

    public void setTariffStrategyName(String tariffStrategyName) {
        this.tariffStrategyName = tariffStrategyName;
    }

//    @Column(name = "feeObject_rate")
//    public BigDecimal getFeeObjectRate() {
//        return feeObjectRate;
//    }
//
//    public void setFeeObjectRate(BigDecimal feeObjectRate) {
//        this.feeObjectRate = feeObjectRate;
//    }
//
//    @Column(name = "feeObject_sonUnit")
//    public FeeObjectUnitEnum getFeeObjectSonUnit() {
//        return feeObjectSonUnit;
//    }
//
//    public void setFeeObjectSonUnit(FeeObjectUnitEnum feeObjectSonUnit) {
//        this.feeObjectSonUnit = feeObjectSonUnit;
//    }

    @Column(name = "account_label")
    public String getAccountLabel() {
        return accountLabel;
    }

    public void setAccountLabel(String accountLabel) {
        this.accountLabel = accountLabel;
    }

    @Column(name = "businessVolumeIn_type")
    public BusinessVolumeTypeEnum getBusinessVolumeType() {
        return businessVolumeType;
    }

    public void setBusinessVolumeType(BusinessVolumeTypeEnum businessVolumeType) {
        this.businessVolumeType = businessVolumeType;
    }

//    @Column(name = "account_bVolume_RelationUuid")
//    public UUID getAccount_bVolume_RelationUuid() {
//        return account_bVolume_RelationUuid;
//    }
//
//    public void setAccount_bVolume_RelationUuid(UUID account_bVolume_RelationUuid) {
//        this.account_bVolume_RelationUuid = account_bVolume_RelationUuid;
//    }

//    @Transient
//    public List<BusinessVolumeEntity> getBusinessVolumeRelation() {
//        return businessVolumeRepositoryNoFK.findAllByAccountRelationUuid(this.accountUUID);
//    }
//
//    @Transactional
//    public void setBusinessVolumeRelation(List<BusinessVolumeEntity> businessVolumeRelation) {
//        businessVolumeRelation.stream().forEach(o -> {
//            if (!businessVolumeRepositoryNoFK.exists(o.getId()))
//                businessVolumeRepositoryNoFK.save(o);
//        });
//    }
}
