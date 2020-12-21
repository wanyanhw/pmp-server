package com.wyhw.pmp.entity;

import lombok.Data;

@Data
public class GenealogyEntity {
    private int userId;
    private int sex;
    private String birthday;
    private String address;
    private Integer fatherId;
    private Integer motherId;
    private Integer spouseId;
    private int generation;
}
