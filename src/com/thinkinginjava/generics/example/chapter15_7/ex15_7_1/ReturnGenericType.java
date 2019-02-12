package com.thinkinginjava.generics.example.chapter15_7.ex15_7_1;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
public class ReturnGenericType<T extends HasF> {
    private T obj;
    public ReturnGenericType(T obj) { this.obj = obj; }
    public T get() { return obj; }
}
