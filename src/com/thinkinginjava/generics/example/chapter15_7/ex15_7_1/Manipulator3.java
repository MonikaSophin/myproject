package com.thinkinginjava.generics.example.chapter15_7.ex15_7_1;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
public class Manipulator3 {
    private HasF obj;
    public Manipulator3(HasF obj) { this.obj = obj; }
    public void manipulate() { obj.f(); }
}
