package com.ruijie.spl.billingEngine.billing.repository;

import com.ruijie.spl.billingEngine.billing.entity_NoForeignKey.BookingRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/8.
 */
public interface BookingRelationRepository extends JpaRepository<BookingRelationEntity, Long> {
    List<BookingRelationEntity> findByFeeTypeName(String feetype);
}
