package com.wyhw.pmp.wechat.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * POST的XML数据包转换为消息接受对象
 */
@Data
@XStreamAlias("xml")
public class InputMessageBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @XStreamAlias("ToUserName")
    private String ToUserName;
    @XStreamAlias("FromUserName")
    private String FromUserName;
    @XStreamAlias("CreateTime")
    private Long CreateTime;
    @XStreamAlias("MsgType")
    private String MsgType = "text";
    @XStreamAlias("MsgId")
    private Long MsgId;
    // 文本消息
    @XStreamAlias("Content")
    private String Content;
    // 图片消息
    @XStreamAlias("PicUrl")
    private String PicUrl;
    // 位置消息
    @XStreamAlias("LocationX")
    private String LocationX;
    @XStreamAlias("LocationY")
    private String LocationY;
    @XStreamAlias("Scale")
    private Long Scale;
    @XStreamAlias("Label")
    private String Label;
    // 链接消息
    @XStreamAlias("Title")
    private String Title;
    @XStreamAlias("Description")
    private String Description;
    @XStreamAlias("Url")
    private String URL;
    // 语音信息
    @XStreamAlias("MediaId")
    private String MediaId;
    @XStreamAlias("Format")
    private String Format;
    @XStreamAlias("Recognition")
    private String Recognition;
    // 事件
    @XStreamAlias("Event")
    private String Event;
    @XStreamAlias("EventKey")
    private String EventKey;
    @XStreamAlias("Ticket")
    private String Ticket;
}
