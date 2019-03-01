package com.thinkinginjava.containers.example.chapter17_10.ex17_10_1;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/1
 * @description:
 */
public abstract class Test<C> {
    public String name;
    public Test(String name) { this.name = name; }
    public abstract int test(C container, TestParam tp);
}
