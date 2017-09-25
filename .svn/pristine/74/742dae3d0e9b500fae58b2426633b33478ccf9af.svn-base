package com.ruijie.spl.billingEngine.billing.entityWrapper;

import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.AccountInfoEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonTariffStrategyRelation;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.TariffStrategyEntity;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.AccountInfoRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonTariffStrategyRelationRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.TariffStrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/9/13.
 */
@Component
public class PersonWrapper {
    private final AccountInfoRepository accountInfoRepository;
    private final TariffStrategyRepository tariffStrategyRepository;
    private final PersonTariffStrategyRelationRepository personTariffStrategyRelationRepository;
    private final PersonRepository personRepository;

    @Autowired
    public PersonWrapper(AccountInfoRepository accountInfoRepository, TariffStrategyRepository tariffStrategyRepository, PersonTariffStrategyRelationRepository personTariffStrategyRelationRepository, PersonRepository personRepository) {
        this.accountInfoRepository = accountInfoRepository;
        this.tariffStrategyRepository = tariffStrategyRepository;
        this.personTariffStrategyRelationRepository = personTariffStrategyRelationRepository;
        this.personRepository = personRepository;
    }


    public List<AccountInfoEntity> getAccountInfoEntity(PersonEntity personEntity) {
        return accountInfoRepository.findAllByPersonAccountRelationUuid(personEntity.getPersonAccountRelationUuid());
    }

    public List<AccountInfoEntity> getAccountInfoEntity(UUID personUuid) {
        return getAccountInfoEntity(personRepository.findOne(personUuid));
    }

    public List<TariffStrategyEntity> getTariffStrategyEntity(PersonEntity personEntity) {
        return personTariffStrategyRelationRepository.findAllByPersonRelationUuid(personEntity.getPersonTariffRelationUuid()).stream().map(o -> tariffStrategyRepository.findByTariffPersonRelationUuid(o.getTariffStrategyUuid())).collect(Collectors.toList());
    }

    @Transactional
    public void addAccountInfo(PersonEntity person, AccountInfoEntity account) {
        if (person.getPersonAccountRelationUuid() == null)
            person.setPersonAccountRelationUuid(UUID.randomUUID());

        account.setPersonAccountRelationUuid(person.getPersonAccountRelationUuid());
        accountInfoRepository.save(account);
        personRepository.save(person);
    }

    public void addAccountInfo(UUID personUuid, UUID accountUuid) {
        PersonEntity person = personRepository.findOne(personUuid);
        AccountInfoEntity account = accountInfoRepository.findOne(accountUuid);

        if (person != null && account != null) {
            addAccountInfo(person, account);
        }
    }

    public void addAccountInfo(PersonEntity person) {
        AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
        addAccountInfo(person, accountInfoEntity);
    }


    public void connectionPersonAndTariffStrategy(UUID personUuid, Long tariffStrategyId) {
        PersonEntity one = personRepository.findOne(personUuid);
        TariffStrategyEntity tariff = tariffStrategyRepository.findOne(tariffStrategyId);

        if (one != null && tariff != null)
            connectionPersonAndTariffStrategy(one, tariff);
    }

    public void connectionPersonAndTariffStrategy(PersonEntity personEntity, TariffStrategyEntity tariffStrategyEntity) {
        if (personEntity.getPersonTariffRelationUuid() == null) {
            personEntity.setPersonTariffRelationUuid(UUID.randomUUID());
            personRepository.save(personEntity);
        }

        if (tariffStrategyEntity.getTariffPersonRelationUuid() == null) {
            tariffStrategyEntity.setTariffPersonRelationUuid(UUID.randomUUID());
            tariffStrategyRepository.save(tariffStrategyEntity);
        }

        if (personTariffStrategyRelationRepository.findByPersonRelationUuidAndTariffStrategyUuid(personEntity.getPersonTariffRelationUuid(), tariffStrategyEntity.getTariffPersonRelationUuid()) == null)
            personTariffStrategyRelationRepository.saveAndFlush(new PersonTariffStrategyRelation(personEntity.getPersonTariffRelationUuid(), tariffStrategyEntity.getTariffPersonRelationUuid()));
    }
}
