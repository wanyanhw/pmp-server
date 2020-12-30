package com.wyhw.pmp.effective_java.chapter2;

/**
 * 静态工厂方法代替构造器
 */
public class Unit1 {
        private static String NAME;
        private static int AGE;
        private static String SEX;
        public Unit1(String name, int age, String sex) {
            this.NAME = name;
            this.AGE = age;
            this.SEX = sex;
        }
        public static Unit1 setName(String name) {
            return new Unit1(name, AGE, SEX);
        }
}
