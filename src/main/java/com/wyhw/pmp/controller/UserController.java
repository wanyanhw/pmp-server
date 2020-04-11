package com.wyhw.pmp.controller;

import com.wyhw.pmp.aop.config.LoginRequired;
import com.wyhw.pmp.entity.UserEntity;
import com.wyhw.pmp.service.UserService;
import com.wyhw.pmp.threadLocal.UserSession;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Api(value = "用户接口")
@Log4j2
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息接口", notes = "根据Id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    @GetMapping(value = "/getUserInfo")
    public String getUserInfo(String id) {
        UserEntity userInfo = userService.getUserInfo(id, null, null);
        return userInfo.toString();
    }

    @ApiOperation(value = "用户登陆接口", notes = "根据用户名和密码验证身份登陆")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
        @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @GetMapping(value = "loginWithPassword")
    @LoginRequired
    public String login(String username, String password) {
        UserEntity userInfo = UserSession.getUser();
        if (userInfo != null) {
            return "success";
        }
        return "fail";
    }

    @ApiOperation(value = "获取所有用户信息接口", notes = "查询所有用户信息")
    @GetMapping(value = "queryAllUser")
    public Collection<UserEntity> getAllUserInfo() {
        Collection<UserEntity> allUserInfoList = userService.getAllUserInfo();
        if (allUserInfoList.isEmpty()) {
            return null;
        }
        return allUserInfoList;
    }

    @ApiOperation(value = "导出用户信息", notes = "导出Excel文件")
    @GetMapping(value = "exportUserInfo")
    public void export(HttpServletResponse response) throws IOException {
        Collection<UserEntity> allUserInfoList = userService.getAllUserInfo();
        String fileName = "用户详细信息.xls";
        String[] titles = {"ID", "姓名", "密码", "类全路径"};
        userService.export(response, fileName, titles, allUserInfoList);
    }

}
