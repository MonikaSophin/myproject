package com.thinkinginjava.arrays.example.chapter16_1;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
public class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    @Override
    public String toString() { return "Shpere " + id; }
}