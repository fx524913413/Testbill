package com.ruijie.spl.billingEngine.billing.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/9/4.
 * 预处理后计费事件
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BillingTemp {
    private LocalDateTime systemCurrentTime;        //系统当前时间
    private BigDecimal foreignUpFlow;
    private BigDecimal foreignDownFlow;
    private BigDecimal inlandUpFlow;
    private BigDecimal inlandDownFlow;

    public BigDecimal getForeignUpFlow() {
        return foreignUpFlow;
    }

    public void setForeignUpFlow(BigDecimal foreignUpFlow) {
        this.foreignUpFlow = foreignUpFlow;
    }

    public BigDecimal getForeignDownFlow() {
        return foreignDownFlow;
    }

    public void setForeignDownFlow(BigDecimal foreignDownFlow) {
        this.foreignDownFlow = foreignDownFlow;
    }

    public BigDecimal getInlandUpFlow() {
        return inlandUpFlow;
    }

    public void setInlandUpFlow(BigDecimal inlandUpFlow) {
        this.inlandUpFlow = inlandUpFlow;
    }

    public BigDecimal getInlandDownFlow() {
        return inlandDownFlow;
    }

    public void setInlandDownFlow(BigDecimal inlandDownFlow) {
        this.inlandDownFlow = inlandDownFlow;
    }

    public LocalDateTime getSystemCurrentTime() {
        return systemCurrentTime;
    }

    public void setSystemCurrentTime(LocalDateTime systemCurrentTime) {
        this.systemCurrentTime = systemCurrentTime;
    }
}
