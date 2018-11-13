package com.thinkinginjava.access_control.example.chapter6_2.ex6_2_3.access;

/**
 * @Author: monika
 * @Date: 2018/11/13 21:33
 * @Version: 1.0
 * @Description:  默认访问权限（包访问权限）
 */
class Sundae {
    private Sundae() {}
    static Sundae makeASundae() {
        return new Sundae();
    }
}

public class IceCream {
    public static void main(String[] args) {
        //! Sundae x = new Sundae();
        Sundae x = Sundae.makeASundae();
    }
}
