package com.wyhw.pmp;

import com.wyhw.pmp.entity.UserEntity;
import com.wyhw.pmp.service.UserService;
import com.wyhw.pmp.wechat.AccessToken;
import com.wyhw.pmp.wechat.WeChatConfig;
import com.wyhw.pmp.wechat.bean.TemplateData;
import com.wyhw.pmp.wechat.bean.TemplateDataDetail;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.*;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class MainTest {
    @Test
    void test01() {
        WeChatConfig config = WeChatConfig.getInstance();
        AccessToken token = config.getAccessToken("wxd5f4742ba87f84a4", "dbae107f3a1a009edbdb45fbcc618e7f");
        System.out.println(token.getAccessToken());
    }

    @Autowired
    private UserService userService;

    @Test
    void test02() {
        Collection<UserEntity> allUserInfo = userService.getAllUserInfo();
        allUserInfo.forEach(item -> {
            System.out.println(item.getUsername() + "," + item.getPassword());
        });
    }

    @Test
    void test03() {
        try {
            Class clazz = Class.forName("com.wyhw.pmp.wechat.bean.TemplateData");
            TemplateData templateData = (TemplateData) clazz.newInstance();
            String methodName = "First";

            Class[] params = new Class[1];
            params[0] = TemplateDataDetail.class;
            Method setMethod = clazz.getMethod("set" + methodName, params);
            TemplateDataDetail detail = new TemplateDataDetail();
            detail.setValue("123");
            detail.setColor("#FF00CC");
            setMethod.invoke(templateData, detail);

            Method getMethod = clazz.getMethod("get" + methodName);
            Object invoke = getMethod.invoke(templateData);

            System.out.println(invoke);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void test04() {
        try {
            OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
            grabber.start();
            CanvasFrame canvas = new CanvasFrame("摄像头");
            canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            canvas.setAlwaysOnTop(true);
            while (true) {
                if (!canvas.isDisplayable()) {
                    grabber.stop();
                    System.exit(-1);
                }
                Frame frame = grabber.grab();
                canvas.showImage(frame);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void reverseChars() {
        String source = "I Have A Dream, I Want You!";
        char[] s = source.toCharArray();
        System.out.println(s);
        func(s, 0, s.length - 1);
        System.out.println(s);
    }

    @Test
    void testHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "hello");
        map.put("two", "world");

        System.out.println(map.get("one") + " " + map.get("two"));

    }

    @Test
    void testTreeMap() {
        RBTree<String, Integer> treeMap = new RBTree<>();
        treeMap.put("d", 5);
        treeMap.put("b", 3);
        treeMap.put("c", 4);
        treeMap.put("a", 2);
        treeMap.put("e", 4);
        System.out.println(treeMap.getSize());
    }

    @Test
    void testLimitMuchData() {
        createJDBCConnection("select id from user");
    }


    private void createJDBCConnection(String sql) {
        String driver = "com.mysql.jdbc.Driver";
        String name = "root";
        String pwd = "";
        String url = "jdbc:mysql://localhost:3306/test";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, name, pwd);
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = ps.executeQuery(sql)) {
                    while (resultSet.next()) {
                        Object column1 = resultSet.getObject("id");
                        System.out.printf("id: %s\n", column1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void func(char[] s, int left, int right) {
        if (left > right) {
            return;
        }
        char tempChar = s[left];
        s[left] = s[right];
        s[right] = tempChar;
        func(s, left + 1, right - 1);
    }

}
