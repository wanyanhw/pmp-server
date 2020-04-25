package com.wyhw.pmp.wechat.bean;

import lombok.Data;

@Data
public class TemplateData {
    private TemplateDataDetail first;
    private TemplateDataDetail keyword1;
    private TemplateDataDetail keyword2;
    private TemplateDataDetail keyword3;
    private TemplateDataDetail remark;
}
