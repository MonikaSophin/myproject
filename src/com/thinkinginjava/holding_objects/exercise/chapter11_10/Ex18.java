package com.thinkinginjava.holding_objects.exercise.chapter11_10;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/19 22:46
 * @Version: 1.0
 * @Description: page 235
 * 练习18：用键值对填充一个HashMap。打印结果，通过散列码来展示其排序。抽取这些
 * 键值对，按照键进行排序，并将结果置于一个LinkedHashMap中。展示其所维护的插入
 * 顺序。
 */
class Pet {
    private int gerbilNumber;
    public Pet(int i) {
        gerbilNumber = i;
    }
    public void hop() {
        System.out.println("gerbil " + gerbilNumber + " hops");
    }
}

public class Ex18 {
    public static void main(String[] args) {
        Map<String, Pet> pets = new HashMap<>();
        pets.put("Fuzzy", new Pet(0));
        pets.put("Spot", new Pet(1));
        pets.put("Happy", new Pet(2));
        pets.put("Dopey", new Pet(3));
        pets.put("Apple", new Pet(4));
        System.out.println(pets);
        System.out.println();

        Set<String> sortedKeys =
                new TreeSet<>(pets.keySet());
        System.out.println(sortedKeys);
        System.out.println();

        Map<String, Pet> sortedGerbils =
                new LinkedHashMap<>();
        for(String s : sortedKeys) {
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
/**output：
 * {Apple=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@4554617c, Happy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@74a14482, Spot=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@1540e19d, Fuzzy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@677327b6, Dopey=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@14ae5a5}
 *
 * [Apple, Dopey, Fuzzy, Happy, Spot]
 *
 * Adding Apple, Adding Dopey, Adding Fuzzy, Adding Happy, Adding Spot,
 *
 * {Apple=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@4554617c, Dopey=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@14ae5a5, Fuzzy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@677327b6, Happy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@74a14482, Spot=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@1540e19d}
 *
 * {Apple=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@4554617c, Dopey=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@14ae5a5, Fuzzy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@677327b6, Happy=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@74a14482, Spot=com.thinkinginjava.holding_objects.exercise.chapter11_10.Pet@1540e19d}
 */
