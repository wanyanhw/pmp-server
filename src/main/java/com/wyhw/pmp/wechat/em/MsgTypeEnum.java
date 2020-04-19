package com.wyhw.pmp.wechat.em;

public enum MsgTypeEnum {
    Text("text"),
    Image("image"),
    Music("music"),
    Video("video"),
    Voice("voice"),
    Location("location"),
    Link("link"),
    Event("event");

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