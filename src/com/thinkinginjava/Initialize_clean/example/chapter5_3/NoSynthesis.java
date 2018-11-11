package com.thinkinginjava.Initialize_clean.example.chapter5_3;

/**
 * @Author: monika
 * @Date: 2018/11/9 22:13
 * @Version: 1.0
 * @Description:
 */

class Bird2 {
    Bird2(int i) {}
    Bird2(double d) {}
}

public class NoSynthesis {
    public static void main(String[] args) {
        //! Bird2 b = new Bird2(); // No default
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2(1.0);
    }
}
