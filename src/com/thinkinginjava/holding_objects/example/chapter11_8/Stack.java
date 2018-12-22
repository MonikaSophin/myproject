package com.thinkinginjava.holding_objects.example.chapter11_8;

import java.util.LinkedList;

/**
 * @Author: monika
 * @Date: 2018/12/16 11:14
 * @Version: 1.0
 * @Description:
 */
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T t){ storage.addFirst(t); }
    public T peek(){ return storage.getFirst(); }
    public T pop(){ return storage.removeFirst(); }
    public boolean empty(){ return storage.isEmpty(); }
    public String toString(){ return storage.toString(); }
}
