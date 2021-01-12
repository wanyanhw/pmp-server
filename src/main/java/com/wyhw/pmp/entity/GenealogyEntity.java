package com.wyhw.pmp.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("person_info")
public class GenealogyEntity {
    @TableField(value = "id")
    private int userId;
    @TableField("sex")
    private int sex;
    @TableField("birthday")
    private String birthday;
    @TableField("address")
    private String address;
    private Integer fatherId;
    private Integer spouseId;
}
