package com.wyhw.pmp.wechat.em;

public enum EventTypeEnum {
    /**
     * 订阅
     */
    SUBSCRIBE("subscribe"),

    /**
     * 取消订阅
     */
    UNSUBSCRIBE("unsubscribe"),

    /**
     * 模板消息发送结束
     */
    TEMPLATESENDJOBFINISH("templateSendJobFinish");

    private String msgType = "";

    EventTypeEnum(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return msgType;
    }
}