package com.ruijie.spl.billingEngine.billing.dataEnum;

/**
 * Created by Administrator on 2017/9/5.
 */
public enum AccountLevelEnum {
    /**
     * 基本账户级别
     */
    Base,
    /**
     * 赠送账户级别，通常状态下优先级最高
     */
    Present,
    /**
     * 套餐账户级别
     */
    Package,
    /**
     * 透支账户级别，通常状态下优先级最低
     */
    OverDraw
}
