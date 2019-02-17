package com.thinkinginjava.generics.example.chapter15_12.ex15_12_2;

/**
 * @Author: monika
 * @Date: 2019/2/17 20:44
 * @Version: 1.0
 * @Description: 自限定泛型参数 可以 应用于泛型方法上。
 */
public class SelfBoundingMethods {
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
    }
}
