package com.wyhw.pmp.entity.em;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(0, "女"),
    OTHER(-1, "未知");
    private int code;
    private String desc;

    public static SexEnum getByCode(int code) {
        for (SexEnum anEnum : SexEnum.values()) {
            if (anEnum.getCode() == code) {
                return anEnum;
            }
        }
        return OTHER;
    }
}
