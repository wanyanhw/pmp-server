package com.wyhw.pmp.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {
    private static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;
    private String sid = "";

    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        webSocketSet.add(this);
        this.sid = sid;
        logger.info("socket{}：连接成功", sid);

        new Thread(new Runnable() {
            @Override
            public void run() {
                sendMsg();
            }
        }).start();
    }

    private void sendMsg() {
        int i = 1;
        while (true) {
            if (i >= 100) {
                return;
            }
            try {
                if (this.session == null) {
                    logger.info("socket{}已关闭", this.sid);
                    return;
                }
                this.session.getBasicRemote().sendText("发送第" + i++ + "条消息");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        logger.info("socket{}断开连接", sid);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("收到socket{}的消息：{}", sid, message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("socket{}连接异常：{}", this.sid, error.getMessage());
    }

}
