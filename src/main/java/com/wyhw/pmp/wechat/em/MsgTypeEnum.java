package com.wyhw.pmp.wechat.em;

public enum MsgTypeEnum {
    TEXT("text"),
    IMAGE("image"),
    MUSIC("music"),
    VIDEO("video"),
    VOICE("voice"),
    LOCATION("location"),
    LINK("link"),
    EVENT("event");

    private String msgType = "";

    MsgTypeEnum(String msgType) {
        this.msgType = msgType;
    }

    /**
     * @return the msgType
     */
    @Override
    public String toString() {
        return msgType;
    }
}