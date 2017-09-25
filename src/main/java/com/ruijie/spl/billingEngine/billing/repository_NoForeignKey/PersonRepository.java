package com.ruijie.spl.billingEngine.billing.repository_NoForeignKey;

import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
    PersonEntity findByPersonAccountRelationUuid(UUID personAccountRelationUuid);

    PersonEntity findByPersonTariffRelationUuid(UUID personTariffRelationUuid);
}
