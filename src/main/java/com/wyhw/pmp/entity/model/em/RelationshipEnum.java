package com.wyhw.pmp.entity.model.em;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 个人关系枚举
 * @author wanyanhw
 * @date 2022/5/5 16:23
 */
@AllArgsConstructor
@Getter
public enum RelationshipEnum {
    /**
     * 父亲
     */
    FATHER(1),

    /**
     * 母亲
     */
    MOTHER(2),

    /**
     * 儿子
     */
    SON(3),

    /**
     * 女儿
     */
    DAUGHTER(4),

    /**
     * 妻子
     */
    WIFE(5),

    /**
     * 丈夫
     */
    HUSBAND(6)
    ;

    private int code;

}
