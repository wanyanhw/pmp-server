package com.wyhw.pmp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务类型信息表
 * </p>
 *
 * @author wanyanhw
 * @since 2023-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("service_item_info")
public class ServiceItemInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 删除标识
     */
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;


}
