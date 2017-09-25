package com.ruijie.spl.billingEngine.billing.repository;

import com.ruijie.spl.billingEngine.billing.entity.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/8/29.
 */
public interface UserRepository extends JpaRepository<UserInfo, String>{

}
