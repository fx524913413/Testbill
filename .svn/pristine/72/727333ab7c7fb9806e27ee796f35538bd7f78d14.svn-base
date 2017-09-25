package com.ruijie.spl.billingEngine.billing.repository_NoForeignKey;

import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.TariffStrategyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface TariffStrategyRepository extends JpaRepository<TariffStrategyEntity, Long> {
    TariffStrategyEntity findByTariffStrategyName(String tariffName);

    TariffStrategyEntity findByTariffPersonRelationUuid(UUID tariffUuid);
}
