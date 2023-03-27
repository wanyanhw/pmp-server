package com.wyhw.pmp.entity.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wanyanhw
 * @since 2023/3/27 16:07
 */
@Data
@ApiModel("预约单")
@Accessors(chain = true)
public class PicOrderInfo {
    private Integer id;
    private String name;
    private String date;
    private String address;
    private String phone;
    private Integer packageId;
    private Integer type;
    private String openId;
    private Integer status;
    private String createTime;
}
