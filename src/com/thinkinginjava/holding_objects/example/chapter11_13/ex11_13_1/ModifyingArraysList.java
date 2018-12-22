package com.thinkinginjava.holding_objects.example.chapter11_13.ex11_13_1;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/22 19:42
 * @Version: 1.0
 * @Description:
 */
public class ModifyingArraysList {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] ia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //ArrayList操作的是底层的数组。
        List<Integer> list1 = new ArrayList<>(Arrays.asList(ia));
        System.out.println("Before shuffling: " + list1);
        Collections.shuffle(list1,rand);
        System.out.println("After shuffling: " + list1);
        System.out.println("array: " + Arrays.toString(ia));
        System.out.println();

        //Arrays.asList(数组1)直接作为List，操作的数组是数组1，所有操作会改变原数组1的元素。
        List<Integer> list2 = Arrays.asList(ia);
        System.out.println("Before shuffling: " + list2);
        Collections.shuffle(list2,rand);
        System.out.println("After shuffling: " + list2);
        System.out.println("array: " + Arrays.toString(ia));
    }
}
/**output:
 * Before shuffling: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * After shuffling: [4, 6, 3, 1, 8, 7, 2, 5, 10, 9]
 * array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 *
 * Before shuffling: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * After shuffling: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
 * array: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
 */