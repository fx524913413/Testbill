package com.ruijie.spl.billingEngine.billing.entity_NoForeignKey;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/13.
 */
@Entity
/*@IdClass(RelationPersonTariffStrategy.class)*/
@Table(name = "person_tariffStrategy_relation_NoFK")
public class PersonTariffStrategyRelation {
    //    @EmbeddedId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "relation_person_tariff_uuid")
    private UUID relationPersonTariffUuid;

    @Column(name = "person_relation_uuid")
    private UUID personRelationUuid;
    @Column(name = "tariffStrategy_uuid")
    private UUID tariffStrategyUuid;

    public PersonTariffStrategyRelation() {
    }

    public PersonTariffStrategyRelation(UUID personUuid, UUID tariffUuid) {
        this.personRelationUuid = personUuid;
        this.tariffStrategyUuid = tariffUuid;
    }

    public UUID getPersonRelationUuid() {
        return personRelationUuid;
    }

    public void setPersonRelationUuid(UUID personRelationUuid) {
        this.personRelationUuid = personRelationUuid;
    }

    public UUID getTariffStrategyUuid() {
        return tariffStrategyUuid;
    }

    public void setTariffStrategyUuid(UUID tariffStrategyUuid) {
        this.tariffStrategyUuid = tariffStrategyUuid;
    }

    public UUID getRelationPersonTariffUuid() {
        return relationPersonTariffUuid;
    }

    public void setRelationPersonTariffUuid(UUID relationPersonTariffUuid) {
        this.relationPersonTariffUuid = relationPersonTariffUuid;
    }
}
