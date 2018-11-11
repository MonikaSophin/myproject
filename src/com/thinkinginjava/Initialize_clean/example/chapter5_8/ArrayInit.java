package com.thinkinginjava.Initialize_clean.example.chapter5_8;

import java.util.Arrays;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:06
 * @Version: 1.0
 * @Description:
 */
public class ArrayInit {
    public static void main(String[] args) {
        Integer[] a = {
                new Integer(1),
                new Integer(2),
                3, // Autoboxing
        };
        Integer[] b = new Integer[]{
                new Integer(1),
                new Integer(2),
                3, // Autoboxing
        };
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
/**输出：
 * [1, 2, 3]
 * [1, 2, 3]
 */