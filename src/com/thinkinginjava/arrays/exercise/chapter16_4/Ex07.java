package com.thinkinginjava.arrays.exercise.chapter16_4;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description: page 440
 * 练习07：重复前一个练习，但改为三维数组。
 */
public class Ex07 {
    static BerylliumSphere[][][] initArrays(int size1, int size2, int size3) {
        BerylliumSphere[][][] b = new BerylliumSphere[size1][size2][size3];
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[i].length; j++)
                for (int k = 0; k < b[i][j].length; k++)
                    b[i][j][k] = new BerylliumSphere();
        return b;
    }

    public static void main(String[] args) {
        BerylliumSphere[][][] spheres = initArrays(3, 2, 2);
        System.out.println(Arrays.deepToString(spheres));
    }
}
/**output:
 * [[[Shpere 0, Shpere 1], [Shpere 2, Shpere 3]], [[Shpere 4, Shpere 5], [Shpere 6, Shpere 7]], [[Shpere 8, Shpere 9], [Shpere 10, Shpere 11]]]
 */