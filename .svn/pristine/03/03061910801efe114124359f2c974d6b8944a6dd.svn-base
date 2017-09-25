package com.ruijie.spl.billingEngine.billing.entity_NoForeignKey;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ruijie.spl.billingEngine.billing.dataEnum.BusinessVolumeTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/12.
 */
//@Entity
//@Table(name = "BusinessVolume_NoFK_Table")
public class BusinessVolumeEntity {
    private Long id;
    private BigDecimal foreignUpFlow;
    private BigDecimal foreignDownFlow;
    private BigDecimal inlandUpFlow;
    private BigDecimal inlandDownFlow;
    private BigDecimal sessionTime;

    private UUID account_bVolume_RelationUuid;

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

    @Column(name = "accountRelation_Uuid")
    public UUID getAccount_bVolume_RelationUuid() {
        return account_bVolume_RelationUuid;
    }

    @JsonBackReference
    public void setAccount_bVolume_RelationUuid(UUID account_bVolume_RelationUuid) {
        this.account_bVolume_RelationUuid = account_bVolume_RelationUuid;
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
