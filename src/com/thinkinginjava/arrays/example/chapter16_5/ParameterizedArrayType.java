package com.thinkinginjava.arrays.example.chapter16_5;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
class ClassParameter<T> {
    public T[] f(T[] args) { return args; }
}

class MethodParameter {
    public static <T> T[] f(T[] arg) { return arg; }
}

public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = { 1, 2, 3, 4, 5 };
        Double[] doubles = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = MethodParameter.f(doubles);
    }
}
