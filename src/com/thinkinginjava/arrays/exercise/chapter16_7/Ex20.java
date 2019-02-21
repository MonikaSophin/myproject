package com.thinkinginjava.arrays.exercise.chapter16_7;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description: page 452
 * 练习20：演示用于多维数组的deepEquals()方法。
 */
public class Ex20 {
    public static void main(String[] args) {
        int[][][] a1 = new int[2][3][2];
        int[][][] a2 = new int[2][][];

        for (int i = 0; i < a1.length; i++)
            for (int j = 0; j < a1[i].length; j++)
                for (int k = 0; k < a1[i][j].length; k++)
                    a1[i][j][k] = 8;

        for (int i = 0; i < a2.length; i++){
            a2[i] = new int[3][];
            for (int j = 0; j < a2[i].length; j++){
                a2[i][j] = new int[2];
                for (int k = 0; k < a2[i][j].length; k++) {
                    a2[i][j][k] = 8;
                }
            }
        }

        System.out.println(String.format("int[][][] a1 = %s", Arrays.deepToString(a1)));
        System.out.println(String.format("int[][][] a2 = %s", Arrays.deepToString(a2)));
        System.out.println(String.format("Arrays.deepEquals(a1, a2): %s", Arrays.deepEquals(a1, a2)));
    }
}
/**output:
 * int[][][] a1 = [[[8, 8], [8, 8], [8, 8]], [[8, 8], [8, 8], [8, 8]]]
 * int[][][] a2 = [[[8, 8], [8, 8], [8, 8]], [[8, 8], [8, 8], [8, 8]]]
 * Arrays.deepEquals(a1, a2): true
 */