package com.ruijie.spl.billingEngine.billing.entity_NoForeignKey;

import com.ruijie.spl.billingEngine.billing.dataEnum.AccountLevelEnum;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/9/8.
 */
@Entity
@Table(name = "booking_Relation_Table")
public class BookingRelationEntity {
    private long relationId;
    private String feeTypeName;
    //    private FeeTypeEnum feeType;
//    private AccountLevelEnum accountLevel;
    private String accountLabel;
    /*    private BusinessVolumeTypeEnum feeObjectType;*/
    private int priority;

    public BookingRelationEntity() {
    }

    public BookingRelationEntity(/*FeeTypeEnum feeType*/String feeTypeName/*, AccountLevelEnum accountLevel*/, String accountLabel, int priority) {
//        this.feeType = feeType;
        this.feeTypeName = feeTypeName;
//        this.accountLevel = accountLevel;
        this.accountLabel = accountLabel;
        this.priority = priority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "relation_Id")
    public long getRelationId() {
        return relationId;
    }

    public void setRelationId(long relationId) {
        this.relationId = relationId;
    }

//    @Column(name = "fee_Type")
//    public FeeTypeEnum getFeeType() {
//        return feeType;
//    }
//
//    public void setFeeType(FeeTypeEnum feeType) {
//        this.feeType = feeType;
//    }

    @Column(name = "feeType_Name")
    public String getFeeTypeName() {
        return feeTypeName;
    }

    public void setFeeTypeName(String feeTypeName) {
        this.feeTypeName = feeTypeName;
    }

//    @Column(name = "account_Level")
//    public AccountLevelEnum getAccountLevel() {
//        return accountLevel;
//    }

/*    @Column(name = "feeObject_Type")
    public BusinessVolumeTypeEnum getBusinessVolumeOutType() {
        return feeObjectType;
    }

    public void setBusinessVolumeOutType(BusinessVolumeTypeEnum feeObjectType) {
        this.feeObjectType = feeObjectType;
    }*/

//    public void setAccountLevel(AccountLevelEnum accountLevel) {
//        this.accountLevel = accountLevel;
//    }

    @Column(name = "priority")

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Column(name = "account_label")
    public String getAccountLabel() {
        return accountLabel;
    }

    public void setAccountLabel(String accountLabel) {
        this.accountLabel = accountLabel;
    }
}
