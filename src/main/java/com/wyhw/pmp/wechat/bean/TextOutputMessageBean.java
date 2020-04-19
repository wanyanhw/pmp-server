package com.wyhw.pmp.wechat.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wyhw.pmp.wechat.config.annotation.XStreamCDATA;
import lombok.Data;

@Data
@XStreamAlias("Content")
public class TextOutputMessageBean extends OutputMessageBean{
    @XStreamAlias("Content")
    @XStreamCDATA
    private String Content;
}
