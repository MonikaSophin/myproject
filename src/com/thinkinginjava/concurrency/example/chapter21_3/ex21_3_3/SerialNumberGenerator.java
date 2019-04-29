package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_3;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/28
 * @description:
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++; //非线程安全的。
    }
}
