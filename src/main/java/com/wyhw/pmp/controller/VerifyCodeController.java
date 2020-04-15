package com.wyhw.pmp.controller;

import com.wyhw.pmp.util.VerifyCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/verify")
public class VerifyCodeController {
    private final static String RANDOM_CODE_KEY = "RANDOM_CODE_KEY";
    private static Map<String, String> session = new HashMap<>();

    @ApiOperation("获取图片验证码")
    @GetMapping("/getCodeImg")
    public void getCodeImg(HttpServletRequest request, HttpServletResponse response) {
        VerifyCode code = new VerifyCode();
        code.getCodeImg(request, response);
        String randomCodeKey = (String) request.getSession().getAttribute("RANDOM_CODE_KEY");
        session.put(RANDOM_CODE_KEY, randomCodeKey);
    }

    @ApiOperation("校验验证码")
    @GetMapping("/verifyCode")
    public boolean verifyCode(String code) {
        String verifyCode = session.get(RANDOM_CODE_KEY);
        verifyCode = verifyCode.toLowerCase();
        return verifyCode.equals(code.toLowerCase());
    }

}
