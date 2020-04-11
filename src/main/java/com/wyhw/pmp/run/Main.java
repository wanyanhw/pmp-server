package com.wyhw.pmp.run;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Long[], Object> longMap = new HashMap();
        Long[] a = {10L, 20L};
        longMap.put(a, "一无所有");

        Long[] b = {10L, 20L};
        longMap.get(b);

        System.out.println("a:" + a);
        System.out.println("a.hashCode():" + a.hashCode());
        System.out.println("b:" + b);
        System.out.println("b.hashCode():" + b.hashCode());
        System.out.println("a == b:" + (a == b));
        System.out.println("a.equals(b):" + (a.equals(b)));
        System.out.println("Arrays.equals(a, b):" + Arrays.equals(a, b));
        System.out.println("结果：" + longMap.get(b));
    }
}
