package com.wyhw.pmp.wechat.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wyhw.pmp.wechat.config.annotation.XStreamCDATA;
import lombok.Data;

@Data
@XStreamAlias("xml")
public class OutputMessageBean  {
    @XStreamAlias("ToUserName")
    @XStreamCDATA
    private String ToUserName;

    @XStreamAlias("FromUserName")
    @XStreamCDATA
    private String FromUserName;

    @XStreamAlias("CreateTime")
    private Long CreateTime;

    @XStreamAlias("MsgType")
    @XStreamCDATA
    private String MsgType = "text";

    private ImageMessageBean Image;

    @XStreamAlias("Content")
    @XStreamCDATA
    private String Content;
}
