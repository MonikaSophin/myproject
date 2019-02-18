package com.thinkinginjava.generics.example.chapter15_15.ex15_15_2;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
public class BasicImp implements Basic {
    private String value;
    @Override
    public void set(String val) { value = val; }
    @Override
    public String get() { return value; }
}

