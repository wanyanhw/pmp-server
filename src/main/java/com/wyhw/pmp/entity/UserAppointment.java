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
 * 用户预约表
 * </p>
 *
 * @author wanyanhw
 * @since 2023-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_appointment")
@Accessors(chain = true)
public class UserAppointment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 时间
     */
    @TableField("date")
    private LocalDateTime date;

    /**
     * 类型ID
     */
    @TableField("type_id")
    private Integer typeId;

    /**
     * 套餐ID
     */
    @TableField("pacage_id")
    private Integer pacageId;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 微信用户openId
     */
    @TableField("open_id")
    private String openId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


}
