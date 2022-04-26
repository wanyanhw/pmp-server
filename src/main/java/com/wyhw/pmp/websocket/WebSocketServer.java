package com.wyhw.pmp.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {
    private static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    private static ConcurrentHashMap<String, WebSocketServer> SOCKET_SERVER = new ConcurrentHashMap<>();
    private Session session;
    private String sid = "";

    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        this.sid = sid;
        SOCKET_SERVER.put(sid, this);
        logger.info("socket {}：连接成功", sid);
    }

    @OnClose
    public void onClose() {
        SOCKET_SERVER.remove(this.sid);
        this.session = null;
        logger.info("socket {} 断开连接", sid);
    }

    @OnMessage
    public void onMessage(String message) {
        try {
            sendMsg(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Throwable error) {
        logger.error("socket {} 连接异常：{}", this.sid, error.getMessage());
        this.session = null;
    }

    private void sendMsg(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }

    private void sendToAllClient(String msg) {
        SOCKET_SERVER.forEach((sid, webSocketServer) -> {
            try {
                webSocketServer.sendMsg(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
