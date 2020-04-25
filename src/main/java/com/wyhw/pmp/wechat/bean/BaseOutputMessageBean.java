package com.wyhw.pmp.wechat.bean;

import lombok.Data;

@Data
public class BaseOutputMessageBean  {
    private String ToUserName;
    private String FromUserName;
    private Long CreateTime;
    private String MsgType;
}
