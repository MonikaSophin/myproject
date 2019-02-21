package com.thinkinginjava.arrays.example.chapter16_7.ex16_7_2;

import java.util.Arrays;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description:
 * {@link java.util.Arrays#equals(Object[], Object[])}：
 * 重载了equals()方法，用来比较整个数组。同样对所有基本类型和Object都做了重载。
 */
public class ComparingArrays {
    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1, 47);
        Arrays.fill(a2, 47);
        print(String.format("a1: %s", Arrays.toString(a1)));
        print(String.format("a2: %s", Arrays.toString(a2)));
        print(String.format("Arrays.equals(a1, a2): %s", Arrays.equals(a1, a2)));
        System.out.println();

        a2[3] = 11;
        print(String.format("a1: %s", Arrays.toString(a1)));
        print(String.format("a2: %s", Arrays.toString(a2)));
        print(String.format("Arrays.equals(a1, a2): %s", Arrays.equals(a1, a2)));
        System.out.println();

        String[] s1 = new String[4];
        String[] s2 = { "Hi", "Hi", "Hi", "Hi"};
        Arrays.fill(s1, "Hi");
        print(String.format("s1: %s", Arrays.toString(s1)));
        print(String.format("s2: %s", Arrays.toString(s2)));
        print(String.format("Arrays.equals(s1, s2): %s", Arrays.equals(s1, s2)));
    }
}
/**output:
 * a1: [47, 47, 47, 47, 47, 47, 47, 47, 47, 47]
 * a2: [47, 47, 47, 47, 47, 47, 47, 47, 47, 47]
 * Arrays.equals(a1, a2): true
 *
 * a1: [47, 47, 47, 47, 47, 47, 47, 47, 47, 47]
 * a2: [47, 47, 47, 11, 47, 47, 47, 47, 47, 47]
 * Arrays.equals(a1, a2): false
 *
 * s1: [Hi, Hi, Hi, Hi]
 * s2: [Hi, Hi, Hi, Hi]
 * Arrays.equals(s1, s2): true
 */