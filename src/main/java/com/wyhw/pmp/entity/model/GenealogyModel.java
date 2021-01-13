package com.wyhw.pmp.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("族谱人员表")
public class GenealogyModel {
    @ApiModelProperty("编号")
    private String no;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("生日")
    private String birthday;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("父亲")
    private GenealogyModel father;
    @ApiModelProperty("配偶")
    private GenealogyModel spouse;
}
