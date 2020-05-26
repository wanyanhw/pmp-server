package com.wyhw.pmp.util;

import com.alibaba.druid.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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

        String ip = request.getHeader("x-Forward-For");
        if (!StringUtils.isEmpty(ip) && !unknown.equalsIgnoreCase(ip)) {
            if (ip.contains(ipSplitChar)) {
                ip = ip.split(ipSplitChar)[0];
                log.info("x-Forward-For Ip : {{}}", ip);
            }
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info("Proxy-Client-IP Ip : {{}}", ip);
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.info("WL-Proxy-Client-IP Ip : {{}}", ip);
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.info("HTTP_CLIENT_IP Ip : {{}}", ip);
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.info("HTTP_X_FORWARDED_FOR Ip : {{}}", ip);
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            log.info("X-Real-IP Ip : {{}}", ip);
        }
        if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            log.info("getRemoteAddr Ip : {{}}", ip);
        }
        log.info("客户端Ip : {{}}", ip);
        return ip;
    }
}
