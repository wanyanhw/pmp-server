package com.wyhw.pmp.entity.model.em;

import lombok.Getter;

/**
 * 账号状态枚举类
 * @author wanyanhw
 * @date 2022/4/26 19:31
 */
@Getter
public enum AccountStatusEnum {
    /**
     * 登录中
     */
    LOG_IN(1),
    /**
     * 空闲中
     */
    FREE(2),
    /**
     * 已锁定
     */
    LOCKED(3)
    ;
    private int code;

    AccountStatusEnum(int code) {
        this.code = code;
    }
}
