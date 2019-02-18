package com.thinkinginjava.generics.example.chapter15_16;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
public class Robot implements Performs {
    @Override
    public void speak() { System.out.println("Click!"); }
    @Override
    public void sit() { System.out.println("Clank!"); }
    public void oilChange() {}
}
