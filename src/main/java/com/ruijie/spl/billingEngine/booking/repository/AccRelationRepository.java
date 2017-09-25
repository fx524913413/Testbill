package com.ruijie.spl.billingEngine.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruijie.spl.billingEngine.booking.entity.Acc_Relation;
import scala.Int;

import java.util.Set;

public interface AccRelationRepository extends JpaRepository<Acc_Relation,Long> {
	Acc_Relation findByAccountTypeBookAndSourceFeeID(String accountType, Integer sourceId);

	Set<Acc_Relation> findBySourceFeeID(Integer sourceId);
}
