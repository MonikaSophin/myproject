package com.thinkinginjava.generics.example.chapter15_15.ex15_15_2;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
public class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    @Override
    public long getSerilaNumber() { return serialNumber; }
}
