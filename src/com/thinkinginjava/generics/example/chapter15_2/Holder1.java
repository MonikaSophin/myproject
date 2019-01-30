package com.thinkinginjava.generics.example.chapter15_2;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description:
 */
class Automobile {}

public class Holder1 {
    private Automobile a;
    public Holder1(Automobile a) { this.a = a; }
    Automobile getA() { return a; }
}
