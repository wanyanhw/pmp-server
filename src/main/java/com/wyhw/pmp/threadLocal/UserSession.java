package com.wyhw.pmp.threadLocal;

import com.wyhw.pmp.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserSession {
    private static final ThreadLocal<UserEntity> LOCAL = new ThreadLocal<>();
    public static void setUser(UserEntity user) {
        LOCAL.set(user);
    }
    public static UserEntity getUser() {
        return LOCAL.get();
    }
    public static void removeUser() {
        LOCAL.remove();
    }
}
