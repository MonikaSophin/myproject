package com.thinkinginjava.generics.example.chapter15_7.ex15_7_4;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind) { this.kind = kind; }
    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] strings = stringMaker.create(9);
        System.out.println(Arrays.toString(strings));
    }
}
/**output:
 * [null, null, null, null, null, null, null, null, null]
 */