package com.thinkinginjava.arrays.exercise.chapter16_4;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description: page 440
 * 练习05：证明类类型的多维数组会自动被初始化为null。
 */
class A {}
public class Ex05 {
    public static void main(String[] args) {
        A[][][] a = new A[2][3][2];
        System.out.println(Arrays.deepToString(a));
    }
}
/**output:
 * [[[null, null], [null, null], [null, null]], [[null, null], [null, null], [null, null]]]
 */