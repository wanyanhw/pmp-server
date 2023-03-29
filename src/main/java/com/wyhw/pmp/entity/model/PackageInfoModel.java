package com.wyhw.pmp.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wanyanhw
 * @since 2023/3/29 9:07
 */
@Data
@ApiModel("套餐信息详情")
public class PackageInfoModel {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("价格")
    private BigDecimal price;
    @ApiModelProperty("备注")
    private String remark;
}
