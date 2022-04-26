package com.wyhw.pmp.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author wanyanhw
 * @date 2022/4/26 15:18
 */
@Data
@ApiModel("人员信息详情")
public class PersonInfoDetail extends PersonInfoBrief {
    @ApiModelProperty("出生日期")
    private String birthday;

    @ApiModelProperty("死亡日期")
    private String deathDay;

    @ApiModelProperty("电话号码")
    private String phoneNum;

    @ApiModelProperty("居住地址")
    private String address;

    @ApiModelProperty("家庭成员")
    private List<PersonInfoBrief> familyMembers;
}
