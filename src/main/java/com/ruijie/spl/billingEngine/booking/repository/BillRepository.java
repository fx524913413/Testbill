package com.ruijie.spl.billingEngine.booking.repository;

import com.ruijie.spl.billingEngine.booking.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, String> {

}
