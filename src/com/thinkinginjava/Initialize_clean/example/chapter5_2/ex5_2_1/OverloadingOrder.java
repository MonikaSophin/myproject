package com.thinkinginjava.Initialize_clean.example.chapter5_2.ex5_2_1;

/**
 * @Author: monika
 * @Date: 2018/11/8 22:06
 * @Version: 1.0
 * @Description:
 */
public class OverloadingOrder {
    static void f(String s, int i) {
        System.out.println("String: " + s + ", int: " + i);
    }

    static void f(int i, String s) {
        System.out.println("int: " + i + ", String: " + s);
    }

    public static void main(String[] args) {
        f("String first", 11);
        f(99, "Int first");
    }
}
/**输出：
 * String: String first, int: 11
 * int: 99, String: Int first
 */