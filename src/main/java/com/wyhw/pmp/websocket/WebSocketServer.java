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
    public static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;
    private String sid = "";

    /**
     * 建立连接成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        logger.info("有新窗口开始监听：" + sid + ", 当前在线人数：" + getOnlineCount());
        this.sid = sid;
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            logger.error("websocket IO异常");
        }
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        logger.info("连接退出，当前在线人数：" + getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("收到来自窗口" + sid + "的消息：" + message);
        // 群发消息
        webSocketSet.forEach(item -> {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void sendInfo(String message, @PathParam("sid") String sid) {
        logger.info("推送消息到窗口" + sid + ", 消息内容：" + message);
        for (WebSocketServer item : webSocketSet) {
            try {
                if (sid == null) {
                    item.sendMessage(message);
                } else if (item.sid.equals(sid)) {
                    item.sendMessage(message);
                }
            } catch (Exception e) {
                logger.error("推送到窗口" + sid + "失败");
                continue;
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("消息发生错误");
        error.printStackTrace();
    }

    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount ++;
    }
    private static synchronized int getOnlineCount() {
        return WebSocketServer.onlineCount;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount --;
    }
}
