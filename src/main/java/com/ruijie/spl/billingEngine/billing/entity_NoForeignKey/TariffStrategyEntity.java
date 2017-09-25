package com.ruijie.spl.billingEngine.billing.entity_NoForeignKey;

import com.ruijie.spl.billingEngine.billing.dataEnum.TariffStrategyTypeEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/12.
 */
@Entity
@Table(name = "tariffStrategy_NoFK_Table")
public class TariffStrategyEntity {
    @Id
    @Column(name = "tariffStrategy_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tariffStrategyId;

    /*规则的名称，全表唯一*/
    @Column(name = "tariffStrategy_Name", unique = true)
    private String tariffStrategyName;

    /*资费策略文件，通常对应一个Drl文件*/
    @Column(name = "drlFile", columnDefinition = "TEXT")
    private String drlFile;

    @Column(name = "create_Time")
    private LocalDateTime createTime;

    @Column(name = "update_Time")
    private LocalDateTime updateTime;

    /*对规则的一些通用性描述*/
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "tariffStrategy_Type")
    private TariffStrategyTypeEnum tariffStrategyType = TariffStrategyTypeEnum.Normal;

    @Column(name = "tariffPersonRelationUuid")
    private UUID tariffPersonRelationUuid;

    public Long getTariffStrategyId() {
        return tariffStrategyId;
    }

    public void setTariffStrategyId(Long tariffStrategyId) {
        this.tariffStrategyId = tariffStrategyId;
    }

    public String getDrlFile() {
        return drlFile;
    }

    public void setDrlFile(String drlFile) {
        this.drlFile = drlFile;
    }

    public String getTariffStrategyName() {
        return tariffStrategyName;
    }

    public void setTariffStrategyName(String tariffStrategyName) {
        this.tariffStrategyName = tariffStrategyName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TariffStrategyTypeEnum getTariffStrategyType() {
        return tariffStrategyType;
    }

    public void setTariffStrategyType(TariffStrategyTypeEnum tariffStrategyType) {
        this.tariffStrategyType = tariffStrategyType;
    }

    public UUID getTariffPersonRelationUuid() {
        return tariffPersonRelationUuid;
    }

    public void setTariffPersonRelationUuid(UUID tariffPersonRelationUuid) {
        this.tariffPersonRelationUuid = tariffPersonRelationUuid;
    }
}
