package com.ruijie.spl.billingEngine.billing.beans;

import com.ruijie.spl.billingEngine.billing.beans.BillingFee;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/4.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BillingFeePackage {

    private UUID userUuid;
    private LocalDateTime createTime;
    private List<BillingFee> billingFeeList = new ArrayList<>();

    public List<BillingFee> getBillingFeeList() {
        return billingFeeList;
    }

    public void setBillingFeeList(List<BillingFee> billingFeeList) {
        this.billingFeeList = billingFeeList;
    }

    public void addBillingFee(BillingFee fee) {
        billingFeeList.add(fee);
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
