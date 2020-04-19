package com.wyhw.pmp.wechat.em;

public enum EventTypeEnum {
    Subscribe("subscribe"),
    Unsubscribe("unsubscribe");

    private String msgType = "";

    EventTypeEnum(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return msgType;
    }
}