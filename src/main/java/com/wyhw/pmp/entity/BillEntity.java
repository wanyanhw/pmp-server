package com.wyhw.pmp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanyanhw
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bill")
public class BillEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("total")
    private Double total;

    @TableField("consumer")
    private String consumer;

    @TableField("consume_time")
    private LocalDateTime consumeTime;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("operator")
    private String operator;

    @TableField("remark")
    private String remark;


}
