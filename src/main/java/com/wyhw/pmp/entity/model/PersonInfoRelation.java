package com.wyhw.pmp.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author wanyanhw
 * @date 2022/4/26 15:18
 */
@Data
@ApiModel("人员关系信息")
@ToString(callSuper = true)
public class PersonInfoRelation extends PersonInfoBrief {
    /**
     * {@link com.wyhw.pmp.entity.model.em.RelationshipEnum}
     */
    @ApiModelProperty("关系代码")
    private Integer relationCode;
}
