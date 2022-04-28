package com.wyhw.pmp.service;

import com.wyhw.pmp.entity.model.PersonInfoBrief;

/**
 * 账号相关接口
 * @author wanyanhw
 * @date 2022/4/28 14:42
 */
public interface IAccountService {
    /**
     * 账号密码登录
     * @param username 登录账号
     * @param password 登录密码
     * @return 用户信息
     */
    PersonInfoBrief login(String username, String password);

    /**
     * 注销登录
     * @param username 登录账号
     * @return 注销结果
     */
    Boolean logout(String username);

    /**
     * 修改登录账号
     * @param username 登录账号
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 用户信息
     */
    PersonInfoBrief updatePassword(String username, String oldPassword, String newPassword);
}
