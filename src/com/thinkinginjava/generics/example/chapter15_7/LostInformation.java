package com.thinkinginjava.generics.example.chapter15_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 * {@link Class#getTypeParameters()} 返回一个TypeVariable对象数组，表示有泛型声明的类型参数。
 * 从输出中所看到的，你能够发现的只是用作参数占位符的标识符，这并非有用的信息。
 *
 * 在泛型代码内部，无法获得任何有关泛型参数类型的信息。Java泛型是使用擦除来实现的，这意味着当你使用
 * 泛型时，任何具体的类型信息都被擦除了，你唯一知道的就是你在使用一个对象。
 */
class Frob {}
class Fnorkie {}
class Quark<Q> {}
class Particle<POSITION, MOMENTUM> {}

public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkie> map = new HashMap<>();
        Quark<Fnorkie> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}
/**output:
 * [E]
 * [K, V]
 * [Q]
 * [POSITION, MOMENTUM]
 */