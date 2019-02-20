package com.thinkinginjava.arrays.example.chapter16_4;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
public class ThreeDWithNew {
    public static void main(String[] args) {
        int[][][] a = new int[2][3][4];
        System.out.println(Arrays.deepToString(a));
    }
}
/**output:
 * [[[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]], [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]]
 */