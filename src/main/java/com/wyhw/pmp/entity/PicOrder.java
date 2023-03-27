package com.wyhw.pmp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanyanhw
 * @since 2023-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pic_order")
@Accessors(chain = true)
public class PicOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("phone")
    private String phone;

    @TableField("address")
    private String address;

    @TableField("date")
    private LocalDateTime date;

    @TableField("type_id")
    private Integer typeId;

    @TableField("pacage_id")
    private Integer pacageId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("status")
    private Integer status;

    @TableField("open_id")
    private String openId;


}
