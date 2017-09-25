package com.ruijie.spl.billingEngine.billing.dataEnum;

/**
 * Created by Administrator on 2017/9/5.
 */
public enum AccountStateEnum {
    /**
     * 未定义账户状态（通常表示该账户不应该有状态）
     */
    None,
    /**
     * 账户正常状态
     */
    Normal,
    /**
     * 账户透支状态
     */
    OverDraw,
    /**
     * 账户欠费状态
     */
    Arrearage,
    /**
     * 账户余额不足状态
     */
    Lack
}
