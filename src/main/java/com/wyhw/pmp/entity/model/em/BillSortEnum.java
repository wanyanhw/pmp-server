package com.wyhw.pmp.entity.model.em;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wanyanhw
 * @date 2022/12/28 16:18
 */
@Getter
@AllArgsConstructor
public enum BillSortEnum {

    FOOD(1),
    CULTURE(2),
    SPORTS(3),
    FASHION(4),
    OTHER(5),
    ;
    private int code;
}
