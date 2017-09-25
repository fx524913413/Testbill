package com.ruijie.spl.billingEngine.billing.entityWrapper;

import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.TariffStrategyEntity;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonTariffStrategyRelationRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.TariffStrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/9/13.
 */
@Component
public class TariffStrategyWrapper {
    private final TariffStrategyRepository tariffStrategyRepository_;
    private final PersonTariffStrategyRelationRepository personTariffStrategyRelationRepository;
    private final PersonRepository personRepository_;

    @Autowired
    public TariffStrategyWrapper(TariffStrategyRepository tariffStrategyRepository_, PersonTariffStrategyRelationRepository personTariffStrategyRelationRepository, PersonRepository personRepository_) {
        this.tariffStrategyRepository_ = tariffStrategyRepository_;
        this.personTariffStrategyRelationRepository = personTariffStrategyRelationRepository;
        this.personRepository_ = personRepository_;
    }

    public List<PersonEntity> getPersonEntity(TariffStrategyEntity tariffStrategyEntity_) {
        return personTariffStrategyRelationRepository.findAllByTariffStrategyUuid(tariffStrategyEntity_.getTariffPersonRelationUuid()).stream().map(o -> personRepository_.findByPersonTariffRelationUuid(o.getPersonRelationUuid())).collect(Collectors.toList());
    }

    public List<PersonEntity> getPersonEntity(Long tariffStrategyId) {
        return getPersonEntity(tariffStrategyRepository_.findOne(tariffStrategyId));
    }
}
