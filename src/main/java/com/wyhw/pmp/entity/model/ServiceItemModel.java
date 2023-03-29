package com.wyhw.pmp.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wanyanhw
 * @since 2023/3/29 9:43
 */
@ApiModel("服务项")
@Data
public class ServiceItemModel {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("备注")
    private String remark;

}
