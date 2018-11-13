package com.thinkinginjava.access_control.example.chapter6_2.ex6_2_4.access;

import com.thinkinginjava.access_control.example.chapter6_2.ex6_2_4.access.Cookie2.Cookie;

/**
 * @Author: monika
 * @Date: 2018/11/13 21:42
 * @Version: 1.0
 * @Description: protected ：继承访问权限
 */
public class ChocolateChip2 extends Cookie {
    public ChocolateChip2() {
        System.out.println("ChocolateChip2 constructor");
    }
    public void chomp() { bite(); } // Protected method
    public static void main(String[] args) {
        ChocolateChip2 x = new ChocolateChip2();
        x.chomp();
    }
}
/**输出：
 * Cookie constructor
 * ChocolateChip2 constructor
 * bite
 */