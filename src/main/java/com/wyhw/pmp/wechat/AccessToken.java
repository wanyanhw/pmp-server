package com.wyhw.pmp.wechat;

import lombok.Data;

@Data
public class AccessToken {
    private String accessToken;
    private int expiresIn;
}
