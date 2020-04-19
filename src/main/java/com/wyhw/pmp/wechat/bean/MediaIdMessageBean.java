package com.wyhw.pmp.wechat.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wyhw.pmp.wechat.config.annotation.XStreamCDATA;

public class MediaIdMessageBean {
    @XStreamAlias("MediaId")
    @XStreamCDATA
    private String MediaId;
}
