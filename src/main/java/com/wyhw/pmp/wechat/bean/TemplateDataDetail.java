package com.wyhw.pmp.wechat.bean;

import lombok.Data;

@Data
public class TemplateDataDetail {
    /**
     * 模版内容
     */
    private String value;
    /**
     * 模板内容字体颜色，不填默认为黑色
     */
    private String color;
}
