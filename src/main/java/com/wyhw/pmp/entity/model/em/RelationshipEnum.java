package com.wyhw.pmp.entity.model.em;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    FATHER(1, "父亲"),

    /**
     * 母亲
     */
    MOTHER(2, "母亲"),

    /**
     * 儿子
     */
    SON(3, "儿子"),

    /**
     * 女儿
     */
    DAUGHTER(4, "女儿"),

    /**
     * 妻子
     */
    WIFE(5, "妻子"),

    /**
     * 丈夫
     */
    HUSBAND(6, "丈夫")
    ;

    private int code;

    private String name;

    public static RelationshipEnum getByCode(Integer code) {
        for (RelationshipEnum anEnum : RelationshipEnum.values()) {
            if (anEnum.getCode() == code) {
                return anEnum;
            }
        }
        throw new RuntimeException("Relation code not exist");
    }

    public static List<Map<Integer, String>> getRelationShipList() {
        List<Map<Integer, String>> relationList = new ArrayList<>();
        for (RelationshipEnum value : RelationshipEnum.values()) {
            HashMap<Integer, String> map = new HashMap<>();
            map.put(value.code, value.name);
            relationList.add(map);
        }
        return relationList;
    }
}
