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
 * 个人档案表
 * </p>
 *
 * @author wanyanhw
 * @since 2022-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("person_archive")
public class PersonArchive implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 个人ID
     */
    @TableField("person_id")
    private Integer personId;

    /**
     * 照片文件路径
     */
    @TableField("photo")
    private String photo;

    /**
     * 手机号码
     */
    @TableField("mobile_phone")
    private String mobilePhone;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 性别（1-男，2-女）
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 出生日期
     */
    @TableField("birthday")
    private LocalDateTime birthday;

    /**
     * 死亡日期
     */
    @TableField("death_day")
    private LocalDateTime deathDay;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField("update_user")
    private Integer updateUser;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 删除标识
     */
    @TableField("deleted")
    private Boolean deleted;


}
