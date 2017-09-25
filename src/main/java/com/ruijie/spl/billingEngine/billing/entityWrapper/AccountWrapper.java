package com.ruijie.spl.billingEngine.billing.entityWrapper;

import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.AccountInfoEntity;
import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.PersonEntity;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.AccountInfoRepository;
import com.ruijie.spl.billingEngine.billing.repository_NoForeignKey.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Administrator on 2017/9/13.
 */
@Component
public class AccountWrapper {
    private final AccountInfoRepository accountInfoRepository_;
    private final PersonRepository personRepository_;

    @Autowired
    public AccountWrapper(AccountInfoRepository accountInfoRepository_, PersonRepository personRepository_) {
        this.accountInfoRepository_ = accountInfoRepository_;
        this.personRepository_ = personRepository_;
    }

    public PersonEntity getPersonEntity(AccountInfoEntity accountInfoEntity_) {
        return personRepository_.findByPersonAccountRelationUuid(accountInfoEntity_.getPersonAccountRelationUuid());
    }

    public PersonEntity getPersonEntity(UUID accountUuid) {
        return getPersonEntity(accountInfoRepository_.findOne(accountUuid));
    }
}
