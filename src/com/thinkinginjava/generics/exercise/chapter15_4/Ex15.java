package com.thinkinginjava.generics.exercise.chapter15_4;

import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.TupleTest2;
import com.thinkinginjava.util.TwoTuple;

/**
 * @Author: monika
 * @Date: 2019/2/4 22:25
 * @Version: 1.0
 * @Description: page 367
 * 练习15：验证前面的陈述是否属实。
 */
public class Ex15 {
    public static void main(String[] args) {
        TwoTuple<String, Integer> twoTuple = TupleTest2.f2();
        System.out.println(twoTuple);
    }
}
/**output:
 * (hi, 47)
 */
