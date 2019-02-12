package com.thinkinginjava.generics.example.chapter15_7.ex15_7_1;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
public class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T obj) { this.obj = obj; }
    public void manipulate() { obj.f(); }
}
