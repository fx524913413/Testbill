package com.ruijie.spl.billingEngine.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruijie.spl.billingEngine.booking.entity.User_info;

import java.util.UUID;

public interface User_InfoRepository extends JpaRepository<User_info, UUID> {
    User_info findByuseruuid(UUID useruuid);
}
