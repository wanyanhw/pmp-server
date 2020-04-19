package com.wyhw.pmp;

import com.wyhw.pmp.entity.UserEntity;
import com.wyhw.pmp.service.UserService;
import com.wyhw.pmp.wechat.AccessToken;
import com.wyhw.pmp.wechat.WeChatConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
}
