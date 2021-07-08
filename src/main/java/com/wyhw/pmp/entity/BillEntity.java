package com.wyhw.pmp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
