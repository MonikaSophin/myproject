package com.thinkinginjava.arrays.example.chapter16_4;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
public class AssemblingMultidlmensionalArrays {
    public static void main(String[] args) {
        Integer[][] a;
        a = new Integer[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i*j;
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
/**output:
 * [[0, 0, 0], [0, 1, 2], [0, 2, 4]]
 */