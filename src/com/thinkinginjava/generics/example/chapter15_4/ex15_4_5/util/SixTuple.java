package com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util;

/**
 * @Author: monika
 * @Date: 2019/2/4 22:42
 * @Version: 1.0
 * @Description:
 */
public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {
    private F f;
    public SixTuple(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        this.f = f;
    }
    public String toString() {
        return "(" + first + ", " + second + ", " +
                third + ", " + fourth + ", " + fifth + f +")";
    }
}
