package com.thinkinginjava.arrays.exercise.chapter16_2;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;
import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:  page 436
 * 练习01：创建一个受BerylliumSphere数组作为参数，把并动态地创建参数去调用这个
 * 方法。证明在本例找那个普通的聚集数组初始化不能奏效。去发现总结在哪些情况下，
 * 普通的聚集初始化可以起作用，而又在哪些情况下，动态聚集初始化显得多余。
 */
class A { public String toString() { return "A Object"; } }

public class Ex01 {
    // 将BerylliumSphere[]作为参数并将参数作为数组元素和List或String打印的方法：
    public static void test(BerylliumSphere[] a) {
        System.out.println(Arrays.asList(a));
    }
    // Generic version:
    public static <T> void test(T[] t) {
        System.out.println(Arrays.asList(t));
    }
    // int version:
    public static void test(int[] ia) {
        System.out.println(Arrays.toString(ia));
    }

    public static void main(String[] args) {
        System.out.println("For objects, e.g., BerylliumSpheres:");
        // 创建并初始化数组（聚合初始化)但所有元素都为null，而不是BerylliumSpheres:
        test(new BerylliumSphere[3]);
        // 动态聚合初始化工作; 元素现在是BerylliumSpheres:
        test(new BerylliumSphere[]{ new BerylliumSphere(), new BerylliumSphere() });
        // 这种方式的聚合初始化有效:
        BerylliumSphere[] a = { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() };
        test(a);
        // 元素初始化为null:
        BerylliumSphere[] bsa = new BerylliumSphere[2];
        test(bsa);
        bsa = a;
        test(bsa);
        System.out.println("-------------");
        System.out.println("For primitives, e.g., int:");
        // 动态聚合初始化工作;:
        test(new int[]{ new Integer(0), new Integer(0) });
        // 但可能被认为是冗余的，因为聚合初始化起作用：元素初始化为零（非空）:
        test(new int[2]);
        // 这种方式的普通聚合初始化也有效:
        int[] ia = { 1, 2, 3, };
        test(ia);
    }
}
