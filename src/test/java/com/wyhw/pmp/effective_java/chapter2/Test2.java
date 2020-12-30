package com.wyhw.pmp.effective_java.chapter2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 找出最长对称字符串
 *
 * @author Your Name
 *
 */
public class Test2 {
    /**
     * TODO 请从这里开始补充代码
     *
     * 测试1：138 1234 1234
     *	结果：通过此手机号注册成功
     *
     * 测试2：13812345abc
     *	结果：通知本手机号无法注册，提示为非法手机号
     *
     * 测试3：13812345678
     *	结果：通知此手机号注册成功
     *
     * 测试4：138 1234 5678
     *	结果：提示此手机号已经被其他用户注册
     *
     * 测试5：98765432101
     *	结果：此手机号码为中国大陆非法手机号码
     */
    /**
     * 已注册手机号
     */
    private static Set<String> PHONE_SET = new HashSet<>();
    public static void main(String[] args) {
        System.out.println("开始注册");
        String next;
        do {
            System.out.print("请输入手机号码（输入'##'退出程序）：");
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            next = scanner.next();
            if (!"##".equals(next)) {
                String verifyResult = verifyPhone(next);
                System.out.println(verifyResult);
            } else {
                System.out.println("退出注册");
            }
        } while (!"##".equals(next));
    }

    /**
     * 校验手机号并返回结果
     * @param phoneNumber 手机号
     * @return result
     */
    private static String verifyPhone(String phoneNumber) {
        // 去除字符串中的空格、回车、换行符、制表符
        Pattern p1 = Pattern.compile("\\s*|\t|\r|\n");
        String trimPhone = p1.matcher(phoneNumber).replaceAll("");

        // 校验手机号码合法性
        Pattern p2 = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p2.matcher(trimPhone);
        if (!m.matches()) {
            return "无法注册，非法手机号";
        }

        // 校验手机号是否已注册
        if (PHONE_SET.contains(trimPhone)) {
            return "此手机号已经被其他用户注册";
        }

        // 保存已注册手机号
        PHONE_SET.add(trimPhone);
        return "注册成功";
    }
}
