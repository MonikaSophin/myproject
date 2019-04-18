package com.thinkinginjava.annotations.example.chapter20_5.ex20_5_1;

import java.util.LinkedList;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class StackL<T> {
    private LinkedList<T> list = new LinkedList<>();
    public void push(T v) { list.addFirst(v); }
    public T top() { return list.getFirst(); }
    public T pop() { return list.removeFirst(); }
}
