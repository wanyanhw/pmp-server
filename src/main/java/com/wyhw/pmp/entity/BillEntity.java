package com.wyhw.pmp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanyanhw
 * @since 2021-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bill")
public class BillEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 总数
     */
    @TableField("total")
    private Double total;

    /**
     * 账单分类，1-食物，2-文化娱乐，3-运动，4-时尚，0-其他
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 类别
     */
    @TableField("remark")
    private String remark;

    /**
     * 消费者
     */
    @TableField("consumer")
    private String consumer;

    /**
     * 消费时间
     */
    @TableField("consume_time")
    private LocalDateTime consumeTime;

    /**
     * 操作人
     */
    @TableField("operator")
    private String operator;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


}
