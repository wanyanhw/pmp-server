package com.wyhw.pmp.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wanyanhw
 * @date 2020/5/26 13:54
 */
public class IpUtil {

    /**
     * 获取源IP地址
     * @param request 请求内容
     * @return ip地址
     */
    public static String getIpAddress(HttpServletRequest request) {
        String unknown = "unknown";
        // ip地址分割符号
        String ipSplitChar = ",";
        // 本机Ip
        Set<String> localhostIps = new HashSet<>();
        localhostIps.add("0:0:0:0:0:0:0:1");
        localhostIps.add("127.0.0.1");

        String ip = request.getHeader("x-forwarded-for");
        if (!StringUtils.isEmpty(ip) && !unknown.equalsIgnoreCase(ip)) {
            if (ip.contains(ipSplitChar)) {
                ip = ip.split(ipSplitChar)[0];
            }
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            if (localhostIps.contains(ip)) {
                ip = inetAddress.getHostAddress();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }
}
