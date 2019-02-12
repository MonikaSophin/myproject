package com.thinkinginjava.generics.example.chapter15_6;

import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Amphibian;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.FourTuple;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Vehicle;
import java.util.ArrayList;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl =
                new TupleList<>();
        tl.add(new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47));
        tl.add(new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47));

        for (FourTuple<Vehicle, Amphibian, String, Integer> i : tl)
            System.out.println(i);
    }
}
/**output(70% match):
 * com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Vehicle@4554617c, com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Amphibian@74a14482, hi, 47)
 * (com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Vehicle@1540e19d, com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Amphibian@677327b6, hi, 47)
 */