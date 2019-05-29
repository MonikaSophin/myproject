package com.thinkinginjava.concurrency.example.chapter21_7.ex21_7_6;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/28
 * @description:
 */
public class Fat {
    private volatile double d;
    private static int counter = 0;
    private final int id = counter++;
    public Fat() {
        for (int i = 0; i < 10000; i++) {
            d += (Math.PI + Math.E)/ (double) i;
        }
    }
    public void operation() { System.out.println(this); }
    @Override
    public String toString() { return "Fat id: " + id; }
}
