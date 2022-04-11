package com.wyhw.pmp.util;

import java.time.format.DateTimeFormatter;

/**
 * @author wanyanhw
 */
public class DateUtil {
    public final static DateTimeFormatter STANDARD_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public final static DateTimeFormatter STANDARD_DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
