package com.thinkinginjava.access_control.example.chapter6_2.ex6_2_4.access.Cookie2;

/**
 * @Author: monika
 * @Date: 2018/11/13 21:42
 * @Version: 1.0
 * @Description:
 */
public class Cookie {
    public Cookie() {
        System.out.println("Cookie constructor");
    }
    protected void bite() {
        System.out.println("bite");
    }
}
