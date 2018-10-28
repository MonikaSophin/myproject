package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_12;

public class UnResponsiveUI {
    private volatile double d = 1;
    public UnResponsiveUI() throws Exception{
        while(d > 0) {
            d = d + 1;
            System.out.println(d);
        }
        System.in.read(); //这一行永远读不到
    }
}
