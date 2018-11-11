package com.thinkinginjava.Initialize_clean.example.chapter5_4;

/**
 * @Author: monika
 * @Date: 2018/11/10 21:09
 * @Version: 1.0
 * @Description:
 */
class Banana { void peel(int i) { /* ... */ } }

public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(),
                b = new Banana();
        a.peel(1);
        b.peel(2);
    }
}
