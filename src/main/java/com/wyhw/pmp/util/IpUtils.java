package com.wyhw.pmp.util;

import com.alibaba.druid.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wanyanhw
 * @date 2020/5/26 13:54
 */
@Component
@Slf4j
public class IpUtils {
    public String getIpAddress(HttpServletRequest request) {
        String unknown = "unknown";
        // ip地址分割符号
        String ipSplitChar = ",";
        // 本机Ip
        Set<String> localhostIps = new HashSet<>();
        localhostIps.add("0:0:0:0:0:0:0:1");
        localhostIps.add("127.0.0.1");

        String ip = request.getHeader("x-forwarded-for");
        log.info("x-forwarded-for Ip : {}", ip);
        if (!StringUtils.isEmpty(ip) && !unknown.equalsIgnoreCase(ip)) {
            if (ip.contains(ipSplitChar)) {
                ip = ip.split(ipSplitChar)[0];
            }
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info("Proxy-Client-IP Ip : {}", ip);
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.info("WL-Proxy-Client-IP Ip : {}", ip);
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.info("HTTP_CLIENT_IP Ip : {}", ip);
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.info("HTTP_X_FORWARDED_FOR Ip : {}", ip);
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            log.info("X-Real-IP Ip : {}", ip);
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            log.info("getRemoteAddr Ip : {}", ip);
        }
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            if (localhostIps.contains(ip)) {
                ip = inetAddress.getHostAddress();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        log.info("客户端Ip : {}", ip);
        return ip;
    }
}
