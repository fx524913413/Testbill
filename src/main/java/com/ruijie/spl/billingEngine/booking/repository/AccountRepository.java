package com.ruijie.spl.billingEngine.booking.repository;

import com.ruijie.spl.billingEngine.booking.entity.Account_info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/11.
 */
public interface AccountRepository extends JpaRepository<Account_info, UUID> {
    Set<Account_info> findAllByuseruuid(UUID useruuid);

    Account_info findByUseruuidAndAccountType(UUID useruuid, String accounttype);
}
