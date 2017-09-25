package com.ruijie.spl.billingEngine.billing.repository_NoForeignKey;

import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.AccountInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface AccountInfoRepository extends JpaRepository<AccountInfoEntity, UUID> {
    List<AccountInfoEntity> findAllByPersonAccountRelationUuid(UUID personRelationUuid);
}
