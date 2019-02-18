package com.thinkinginjava.generics.example.chapter15_17.ex15_17_2;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: monika
 * @Date: 2019/2/18 21:25
 * @Version: 1.0
 * @Description:
 */
public class SimpleQueue<T> implements Iterable<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void add(T t) { storage.add(t); }
    public T get() {
        return storage.poll();
        // return storage.getFirst();
    }
    @Override
    public Iterator<T> iterator() { return storage.iterator(); }
}
