package com.wyhw.pmp.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wyhw
 * @date: 2021/6/14 15:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "账单信息")
public class BillInfo {
    @ApiModelProperty("消费者，1-wyhw，2-lml")
    private String consumer;
    @ApiModelProperty("消费总数")
    private Double total;
    @ApiModelProperty("账单备注")
    private String remark;
    @ApiModelProperty("消费时间")
    private String consumeTime;
}
