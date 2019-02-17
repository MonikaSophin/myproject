package com.thinkinginjava.generics.example.chapter15_12.ex15_12_1;

/**
 * @Author: monika
 * @Date: 2019/2/17 20:20
 * @Version: 1.0
 * @Description:
 */
public class BasicHolder<T> {
    T element;
    public void set(T arg) { element = arg; }
    public T get() { return element; }
    public void f() { System.out.println(element.getClass().getSimpleName()); }
}
