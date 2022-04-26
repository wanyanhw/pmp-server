package com.wyhw.pmp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 基础关系表
 * </p>
 *
 * @author wanyanhw
 * @since 2022-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("base_relationship")
public class BaseRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关系
     */
    @TableField("name")
    private String name;


}
