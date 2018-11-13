package com.thinkinginjava.access_control.example.chapter6_2.ex6_2_2.access;

import com.thinkinginjava.access_control.example.chapter6_2.ex6_2_2.access.dessert.Cookie;

/**
 * @Author: monika
 * @Date: 2018/11/13 21:31
 * @Version: 1.0
 * @Description:
 */
public class Dinner {
    public static void main(String[] args) {
        Cookie x = new Cookie();
        //! x.bite(); // Can't access
    }
}
