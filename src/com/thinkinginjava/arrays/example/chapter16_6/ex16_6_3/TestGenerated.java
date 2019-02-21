package com.thinkinginjava.arrays.example.chapter16_6.ex16_6_3;

import com.thinkinginjava.util.CountingGenerator;
import com.thinkinginjava.util.Generated;
import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description:
 */
public class TestGenerated {
    public static void main(String[] args) {
        Integer[] a = { 9, 8, 7, 6 };
        System.out.println(Arrays.toString(a));

        a = Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));

        Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        System.out.println(Arrays.toString(b));
    }
}
/**output:
 * [9, 8, 7, 6]
 * [0, 1, 2, 3]
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
 */