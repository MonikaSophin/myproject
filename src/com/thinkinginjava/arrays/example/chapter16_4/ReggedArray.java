package com.thinkinginjava.arrays.example.chapter16_4;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
public class ReggedArray {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int[][][] a = new int[rand.nextInt(7)][][];
        //第一层
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][];
            // 第二层
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = new int[rand.nextInt(5)];
                //第三层
                for (int k = 0; k < a[i][j].length; k++) {
                    a[i][j][k] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
/**output:
 * [[], [[0], [0], [0, 0, 0, 0]], [[], [0, 0], [0, 0]], [[0, 0, 0], [0], [0, 0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0], []], [[0], [], [0]]]
 */