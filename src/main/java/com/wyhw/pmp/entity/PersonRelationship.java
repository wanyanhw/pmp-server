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
 * 个人关系表
 * </p>
 *
 * @author wanyanhw
 * @since 2022-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("person_relationship")
public class PersonRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 个人ID
     */
    @TableField("person_id")
    private Integer personId;

    /**
     * 关系
     */
    @TableField("relation_id")
    private Integer relationId;

    /**
     * 关系人ID
     */
    @TableField("relation_person_id")
    private Integer relationPersonId;

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
