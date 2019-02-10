package com.thinkinginjava.generics.exercise.chapter15_4;

import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.TupleTest2;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Amphibian;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.SixTuple;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Vehicle;

/**
 * @Author: monika
 * @Date: 2019/2/4 22:30
 * @Version: 1.0
 * @Description: page 367
 * 练习16：为Tuple.java添加一个SixTuple,并在TupleTest2.java中进行测试。
 */
public class Ex16 {
    public static void main(String[] args) {
        SixTuple<Vehicle, Amphibian, String, Integer, Double, Long> l = TupleTest2.l();
        System.out.println(l);
    }
}
/**output:
 * (com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Vehicle@4554617c, com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Amphibian@74a14482, hi, 47, 11.111)
 */