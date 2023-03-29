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
 * 优选图片表
 * </p>
 *
 * @author wanyanhw
 * @since 2023-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("top_picture")
public class TopPicture implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片ID
     */
    @TableField("pic_id")
    private Integer picId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


}
