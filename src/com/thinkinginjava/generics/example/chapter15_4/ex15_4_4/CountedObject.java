package com.thinkinginjava.generics.example.chapter15_4.ex15_4_4;

/**
 * @Author: monika
 * @Date: 2019/2/4 16:35
 * @Version: 1.0
 * @Description:
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;
    public long id() { return id; }
    public String toString() { return "CounterObject " + id; }
}
