package com.thinkinginjava.generics.example.chapter15_4.ex15_4_5;

import static com.thinkinginjava.util.Tuple.*;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Amphibian;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.SixTuple;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Vehicle;
import com.thinkinginjava.util.FiveTuple;
import com.thinkinginjava.util.FourTuple;
import com.thinkinginjava.util.ThreeTuple;
import com.thinkinginjava.util.TwoTuple;

/**
 * @Author: monika
 * @Date: 2019/2/4 22:10
 * @Version: 1.0
 * @Description:
 */
public class TupleTest2 {
    static TwoTuple<String,Integer> f(){
        return tuple("hi", 47);
    }
    public static TwoTuple f2(){ return tuple("hi", 47); }
    static ThreeTuple<Amphibian, String, Integer> g(){
        return tuple(new Amphibian(), "hi", 47);
    }
    static FourTuple<Vehicle, Amphibian, String, Integer> h(){
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }
    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k(){
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static SixTuple<Vehicle, Amphibian, String, Integer, Double, Long> l() {
        return new SixTuple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1, 11L);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
/**output:
 * (hi, 47)
 * (hi, 47)
 * (com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.Amphibian@4554617c, hi, 47)
 * (com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.Vehicle@74a14482, com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.Amphibian@1540e19d, hi, 47)
 * (com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.Vehicle@677327b6, com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.Amphibian@14ae5a5, hi, 47, 11.1)
 */