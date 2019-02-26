package com.thinkinginjava.containers.exercise.chapter17_8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description: page 484
 * 练习12：在AssociativeArray.java的main()中替代为使用HashMap、TreeMap和
 * LinkedHashMap。
 */
public class Ex12 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        }catch (Exception e) {
            System.out.println("Too many objects");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));

        Map<String, String> map2 = new TreeMap<>();
        map2.put("sky", "blue");
        map2.put("grass", "green");
        map2.put("ocean", "dancing");
        map2.put("tree", "tall");
        map2.put("earth", "brown");
        map2.put("sun", "warm");
        try {
            map2.put("extra", "object");
        }catch (Exception e) {
            System.out.println("Too many objects");
        }
        System.out.println(map2);
        System.out.println(map2.get("ocean"));

        Map<String, String> map3 = new LinkedHashMap<>(6);
        map3.put("sky", "blue");
        map3.put("grass", "green");
        map3.put("ocean", "dancing");
        map3.put("tree", "tall");
        map3.put("earth", "brown");
        map3.put("sun", "warm");
        try {
            map3.put("extra", "object");
        }catch (Exception e) {
            System.out.println("Too many objects");
        }
        System.out.println(map3);
        System.out.println(map3.get("ocean"));
    }
}
/**output:
 * {sky=blue, ocean=dancing, grass=green, earth=brown, extra=object, tree=tall, sun=warm}
 * dancing
 * {earth=brown, extra=object, grass=green, ocean=dancing, sky=blue, sun=warm, tree=tall}
 * dancing
 * {sky=blue, grass=green, ocean=dancing, tree=tall, earth=brown, sun=warm, extra=object}
 * dancing
 */