package com.thinkinginjava.generics.example.chapter15_10.ex15_10_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/15
 * @description:
 */
public class UnboundedWildcards2 {
    static Map map1;
    static Map<?,?> map2;
    static Map<String, ?> map3;
    static void assign1(Map map) { map1 = map; }
    static void assign2(Map<?,?> map) { map2 = map; }
    static void assign3(Map<String,?> map) { map3 = map; }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap());
        // 警告：未经检查的转化， 找到：HashMap 必填：Map<String,?>
        assign3(new HashMap());

        assign1(new HashMap<String,Integer>());
        assign2(new HashMap<String,Integer>());
        assign3(new HashMap<String,Integer>());
    }
}
