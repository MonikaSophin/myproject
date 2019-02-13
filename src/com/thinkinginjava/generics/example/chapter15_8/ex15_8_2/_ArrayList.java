package com.thinkinginjava.generics.example.chapter15_8.ex15_8_2;

import java.util.Collection;

/**
 * @Author: monika
 * @Date: 2019/2/13 21:17
 * @Version: 1.0
 * @Description:
 */
public class _ArrayList<E> {
    int size;
    E[] elementData;

    @SuppressWarnings("unchecked")
    public _ArrayList(Collection c) {
        size = c.size();
        // ArrayList源码充满了这种转型。
        elementData = (E[]) new Object[size];
        c.toArray(elementData);
    }
}
