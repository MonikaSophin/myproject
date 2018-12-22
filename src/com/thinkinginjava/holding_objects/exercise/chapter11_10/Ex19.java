package com.thinkinginjava.holding_objects.exercise.chapter11_10;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/19 23:01
 * @Version: 1.0
 * @Description: page 236
 * 练习19：使用HashSet和LinkedHashSet重复上一个练习。
 */
public class Ex19 {
    public static void main(String[] args) {
        Map<String, Pet> pets = new HashMap<>();
        pets.put("Fuzzy", new Pet(0));
        pets.put("Spot", new Pet(1));
        pets.put("Happy", new Pet(2));
        pets.put("Dopey", new Pet(3));
        pets.put("Bob", new Pet(4));
        System.out.println(pets);
        System.out.println();

        Set<String> hashKeys = new HashSet<>(pets.keySet());
        // LinkedHashSet与HashSet并没有排序的作用。 TreeSet具有排序的作用。
        // Set<String> hashKeys = new LinkedHashSet<>(pets.keySet());
        System.out.println(hashKeys);
        System.out.println();

        Map<String, Pet> sortedGerbils =
                new LinkedHashMap<>();
        for(String s : hashKeys) {
            System.out.print("Adding " + s + ", ");
            sortedGerbils.put(s, pets.get(s));
        }
        System.out.println();

        System.out.println();
        System.out.println(sortedGerbils);
        System.out.println();
        // or, just:
        Map<String, Pet> sortedGerbils2 =
                new TreeMap<>(pets);
        System.out.println(sortedGerbils2);
    }
}
/**output:
 * {Happy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@4554617c, Bob=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@74a14482, Spot=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@1540e19d, Fuzzy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@677327b6, Dopey=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@14ae5a5}
 *
 * [Happy, Bob, Spot, Fuzzy, Dopey]
 *
 * Adding Happy, Adding Bob, Adding Spot, Adding Fuzzy, Adding Dopey,
 *
 * {Happy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@4554617c, Bob=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@74a14482, Spot=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@1540e19d, Fuzzy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@677327b6, Dopey=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@14ae5a5}
 *
 * {Bob=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@74a14482, Dopey=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@14ae5a5, Fuzzy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@677327b6, Happy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@4554617c, Spot=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@1540e19d}
 */