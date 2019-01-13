package com.thinkinginjava.string.example.chapter13_1;

/**
 * @Author: monika
 * @Date: 2018/12/30 21:18
 * @Version: 1.0
 * @Description:
 */
public class Immutable {
    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q);// howdy
        String qq = upcase(q);
        System.out.println(qq);// HOWDY
        System.out.println(q);// howdy
    }
}
/**output:
 * howdy
 * HOWDY
 * howdy
 */