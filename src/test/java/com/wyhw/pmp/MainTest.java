package com.wyhw.pmp;

import com.wyhw.pmp.entity.UserEntity;
import com.wyhw.pmp.service.UserService;
import com.wyhw.pmp.wechat.AccessToken;
import com.wyhw.pmp.wechat.WeChatConfig;
import com.wyhw.pmp.wechat.bean.TemplateData;
import com.wyhw.pmp.wechat.bean.TemplateDataDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Collection;

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
}
