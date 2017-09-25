package com.ruijie.spl.billingEngine.billing.beans;

import com.ruijie.spl.billingEngine.billing.dataEnum.BillingFeeOperationTypeEnum;
import com.ruijie.spl.billingEngine.billing.dataEnum.BusinessVolumeTypeEnum;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/9/4.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BillingFee {
    private BigDecimal businessVolumeAmount;    //业务量的量
    /*private FeeTypeEnum feeType;                //指定费用项的类型*/
    private BusinessVolumeTypeEnum businessVolumeType;       //业务量类型
    private String feeSourceType;                 //指定费用项的名称，用于在入账关系表中查找对应
    //    private BigDecimal usageAmount;             //通常是费用项的使用量，如流量、时长、周期
    private String tariffName;                  //关联的资费策略的名字（通常周期性费用项需要设置该项）
    private boolean isHandledOver;              //标识该费用项是否被处理完

    private BillingFeeOperationTypeEnum billingFeeOperationType = BillingFeeOperationTypeEnum.Usage;        //费用项的操作类型（需要判断增加、删除或使用时设置该项）
    //    private AccountLevelEnum accountLevel;                   //添加账户时，指定需添加账户的账户级别
//    private BigDecimal accountRate;                          //添加账户时，指定需添加账户的费率
//    private FeeObjectUnitEnum accountSonUnit;                //添加账户时，指定需添加账户的分子单位（通常也是业务量单位）
//    private FeeObjectUnitEnum accountMotherUnit;             //添加账户时，指定需添加账户的分母单位
    private String accountName;
    private BigDecimal acctLowerLimit;
    private BigDecimal acctUpperLimit;
    private String acctDescription;
    private String acctLabel;
    private LocalDateTime acctNextBillingTime;

    public BillingFee() {
        this(BigDecimal.ZERO, null, null, null);
    }

    public BillingFee(BigDecimal businessVolumeAmount, String feeSourceType, String tariffName, BusinessVolumeTypeEnum businessVolumeType) {
        this(businessVolumeAmount, feeSourceType, tariffName, businessVolumeType, BillingFeeOperationTypeEnum.Usage);
    }

    public BillingFee(BigDecimal businessVolumeAmount, String feeSourceType, String tariffName, BusinessVolumeTypeEnum businessVolumeType, BillingFeeOperationTypeEnum billingFeeOperationType) {
        this(businessVolumeAmount, feeSourceType, tariffName, businessVolumeType, billingFeeOperationType, null, BigDecimal.ZERO, BigDecimal.valueOf(Integer.MAX_VALUE), null, null, null);
    }

    public BillingFee(BigDecimal businessVolumeAmount, String feeSourceType, String tariffName, BusinessVolumeTypeEnum businessVolumeType, BillingFeeOperationTypeEnum billingFeeOperationType, LocalDateTime acctNextBillingTime) {
        this(businessVolumeAmount, feeSourceType, tariffName, businessVolumeType, billingFeeOperationType, null, BigDecimal.ZERO, BigDecimal.valueOf(Integer.MAX_VALUE), null, null, acctNextBillingTime);
    }

    public BillingFee(BigDecimal businessVolumeAmount, String feeSourceType, String tariffName, BusinessVolumeTypeEnum businessVolumeType, BillingFeeOperationTypeEnum billingFeeOperationType, String accountName, BigDecimal acctLowerLimit, BigDecimal acctUpperLimit, String acctDescription, String acctLabel, LocalDateTime acctNextBillingTime) {
        this.businessVolumeAmount = businessVolumeAmount;
        this.feeSourceType = feeSourceType;
        this.tariffName = tariffName;
        this.businessVolumeType = businessVolumeType;
        this.billingFeeOperationType = billingFeeOperationType;
        this.accountName = accountName;
        this.acctLowerLimit = acctLowerLimit;
        this.acctUpperLimit = acctUpperLimit;
        this.acctDescription = acctDescription;
        this.acctLabel = acctLabel;
        this.acctNextBillingTime = acctNextBillingTime;
    }

    public BusinessVolumeTypeEnum getBusinessVolumeType() {
        return businessVolumeType;
    }

    public void setBusinessVolumeType(BusinessVolumeTypeEnum businessVolumeType) {
        this.businessVolumeType = businessVolumeType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getAcctLowerLimit() {
        return acctLowerLimit;
    }

    public void setAcctLowerLimit(BigDecimal acctLowerLimit) {
        this.acctLowerLimit = acctLowerLimit;
    }
//    private String accountLabel;
//    private BusinessVolumeTypeEnum businessVolumeOutType;
//    private BusinessVolumeTypeEnum businessVolumeInType;

    public BigDecimal getAcctUpperLimit() {
        return acctUpperLimit;
    }

    public void setAcctUpperLimit(BigDecimal acctUpperLimit) {
        this.acctUpperLimit = acctUpperLimit;
    }

    public String getAcctDescription() {
        return acctDescription;
    }

    public void setAcctDescription(String acctDescription) {
        this.acctDescription = acctDescription;
    }
//    public BillingFee(BigDecimal businessVolumeAmount, String feeSourceType, String tariffName, BillingFeeOperationTypeEnum feeOperationTypeEnum, AccountLevelEnum accountLevel, BusinessVolumeTypeEnum businessVolumeType, BigDecimal accountRate, FeeObjectUnitEnum accountSonUnit, FeeObjectUnitEnum accountMotherUnit, BigDecimal acctLowerLimit, BigDecimal acctUpperLimit, String accountName, String acctDescription, String accountLabel, BusinessVolumeTypeEnum businessVolumeOutType, BusinessVolumeTypeEnum businessVolumeInType) {
//        this.businessVolumeAmount = businessVolumeAmount;
//        this.feeSourceType = feeSourceType;
//        this.tariffName = tariffName;
//        this.billingFeeOperationType = feeOperationTypeEnum;
//        this.accountLevel = accountLevel;
//        this.accountMotherUnit = accountMotherUnit;
//        this.businessVolumeType = businessVolumeType;
//        this.accountRate = accountRate;
//        this.accountSonUnit = accountSonUnit;
//        this.acctLowerLimit = acctLowerLimit;
//        this.acctUpperLimit = acctUpperLimit;
//        this.accountName = accountName;
//        this.acctDescription = acctDescription;
//        this.accountLabel = accountLabel;
//        this.businessVolumeOutType = businessVolumeOutType;
//        this.businessVolumeInType = businessVolumeInType;
//    }

//    public String getAccountName() {
//        return accountName;
//    }
//
//    public void setAccountName(String accountName) {
//        this.accountName = accountName;
//    }
//
//    public BigDecimal getLowerLimit() {
//        return acctLowerLimit;
//    }
//
//    public void setLowerLimit(BigDecimal acctLowerLimit) {
//        this.acctLowerLimit = acctLowerLimit;
//    }
//
//    public BigDecimal getUpperLimit() {
//        return acctUpperLimit;
//    }
//
//    public void setUpperLimit(BigDecimal acctUpperLimit) {
//        this.acctUpperLimit = acctUpperLimit;
//    }
//
//    public String getDescription() {
//        return acctDescription;
//    }
//
//    public void setDescription(String acctDescription) {
//        this.acctDescription = acctDescription;
//    }

    public BigDecimal getBusinessVolumeAmount() {
        return businessVolumeAmount;
    }

    public void setBusinessVolumeAmount(BigDecimal businessVolumeAmount) {
        this.businessVolumeAmount = businessVolumeAmount;
    }

//    public FeeTypeEnum getFeeType() {
//        return feeType;
//    }
//
//    public void setFeeType(FeeTypeEnum feeType) {
//        this.feeType = feeType;
//    }

    public String getFeeSourceType() {
        return feeSourceType;
    }

    public void setFeeSourceType(String feeSourceType) {
        this.feeSourceType = feeSourceType;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

//    public BigDecimal getUsageAmount() {
//        return usageAmount;
//    }
//
//    public void setUsageAmount(BigDecimal usageAmount) {
//        this.usageAmount = usageAmount;
//    }

//    public FeeObjectUnitEnum getAccountMotherUnit() {
//        return accountMotherUnit;
//    }
//
//    public void setAccountMotherUnit(FeeObjectUnitEnum accountMotherUnit) {
//        this.accountMotherUnit = accountMotherUnit;
//    }

    public boolean isHandledOver() {
        return isHandledOver;
    }

    public void setHandledOver(boolean handledOver) {
        isHandledOver = handledOver;
    }

    public BillingFeeOperationTypeEnum getBillingFeeOperationType() {
        return billingFeeOperationType;
    }

    public void setBillingFeeOperationType(BillingFeeOperationTypeEnum billingFeeOperationType) {
        this.billingFeeOperationType = billingFeeOperationType;
    }

    public String getAcctLabel() {
        return acctLabel;
    }

    public void setAcctLabel(String acctLabel) {
        this.acctLabel = acctLabel;
    }

    public LocalDateTime getAcctNextBillingTime() {
        return acctNextBillingTime;
    }

    public void setAcctNextBillingTime(LocalDateTime acctNextBillingTime) {
        this.acctNextBillingTime = acctNextBillingTime;
    }

//    public AccountLevelEnum getAccountLevel() {
//        return accountLevel;
//    }
//
//    public void setAccountLevel(AccountLevelEnum accountLevel) {
//        this.accountLevel = accountLevel;
//    }
//
//    public BusinessVolumeTypeEnum getBusinessVolumeType() {
//        return businessVolumeType;
//    }
//
//    public void setBusinessVolumeType(BusinessVolumeTypeEnum businessVolumeType) {
//        this.businessVolumeType = businessVolumeType;
//    }
//
//    public FeeObjectUnitEnum getAccountSonUnit() {
//        return accountSonUnit;
//    }
//
//    public void setAccountSonUnit(FeeObjectUnitEnum accountSonUnit) {
//        this.accountSonUnit = accountSonUnit;
//    }
//
//    public BigDecimal getAccountRate() {
//        return accountRate;
//    }
//
//    public void setAccountRate(BigDecimal accountRate) {
//        this.accountRate = accountRate;
//    }
//
//    public String getAccountLabel() {
//        return accountLabel;
//    }
//
//    public void setAccountLabel(String accountLabel) {
//        this.accountLabel = accountLabel;
//    }
//
//    public BusinessVolumeTypeEnum getBusinessVolumeOutType() {
//        return businessVolumeOutType;
//    }
//
//    public void setBusinessVolumeOutType(BusinessVolumeTypeEnum businessVolumeOutType) {
//        this.businessVolumeOutType = businessVolumeOutType;
//    }
//
//    public BusinessVolumeTypeEnum getBusinessVolumeType() {
//        return businessVolumeInType;
//    }
//
//    public void setBusinessVolumeType(BusinessVolumeTypeEnum businessVolumeInType) {
//        this.businessVolumeInType = businessVolumeInType;
//    }
}
