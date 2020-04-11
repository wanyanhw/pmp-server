package com.wyhw.pmp.service;

import com.wyhw.pmp.entity.UserEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public interface UserService {

    /**
     * 根据Id获取用户信息
     * @param params 用户信息
     * @return 用户信息对象
     */
    UserEntity getUserInfo(String ... params);

    Collection<UserEntity> getAllUserInfo();

    void export(HttpServletResponse response, String fileName, String[] titles, Collection<UserEntity> allUserInfoList);
}
