package com.thinkinginjava.generics.example.chapter15_4.ex15_4_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/2/3 20:23
 * @Version: 1.0
 * @Description:
 *  泛型方法与可变参数列表能够很好地共存。
 */
public class GenericVarargs {
    static <T> List<T> makeList(T... args) {
         return Arrays.asList(args);
//        List<T> result = new ArrayList<>();
//        for (T arg : args)
//            result.add(arg);
//        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
/**output：
 * [A]
 * [A, B, C]
 * [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
 */