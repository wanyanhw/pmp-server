package com.wyhw.pmp.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 *
 * @author wanyanhw
 * @date 2022/4/26 15:18
 */
@Data
@ApiModel("人员简略信息")
public class PersonInfoBrief {
    @ApiModelProperty("人员ID")
    private Integer id;

    @ApiModelProperty("父ID")
    private Integer parentId;

    @ApiModelProperty("照片")
    private String photo;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别，1-男，2-女")
    private Integer sex;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("是否存活")
    private Boolean alive;

    @ApiModelProperty("子女")
    private List<PersonInfoBrief> children;
}
