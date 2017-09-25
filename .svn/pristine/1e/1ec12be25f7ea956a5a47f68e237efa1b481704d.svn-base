package com.ruijie.spl.billingEngine.billing.repository_NoForeignKey;

import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonTariffStrategyRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/13.
 */
public interface PersonTariffStrategyRelationRepository extends JpaRepository<PersonTariffStrategyRelation, UUID> {

    List<PersonTariffStrategyRelation> findAllByTariffStrategyUuid(UUID tariffStrategyUuid);

    List<PersonTariffStrategyRelation> findAllByPersonRelationUuid(UUID personUuid);

    PersonTariffStrategyRelation findByPersonRelationUuidAndTariffStrategyUuid(UUID personUuid, UUID tariffUuid);
}
