package com.thinkinginjava.annotations.exercise.chapter20_5;

import com.thinkinginjava.util.atunit.TestProperty;
import java.util.ArrayList;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class Test08<T> {
    private ArrayList<T> list = new ArrayList<>();
    public boolean add(T t) { return list.add(t); }
    public T get(int index) { return list.get(index); }
    public T remove(int index) { return list.remove(index); }
    private boolean isEmpty() { return list.isEmpty(); }

    @TestProperty boolean testIsEmpty() { return isEmpty(); }
}
