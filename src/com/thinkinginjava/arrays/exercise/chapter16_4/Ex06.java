package com.thinkinginjava.arrays.exercise.chapter16_4;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;
import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description: page 440
 * 练习06：编写一个方法，它接受两个表示二维数组尺寸的int参数。这个方法应该这两个
 * 根据尺寸参数，创建并填充一个BerylliumSphere二维数组。
 */
public class Ex06 {
    static BerylliumSphere[][] initArrays(int size1, int size2) {
        BerylliumSphere[][] b = new BerylliumSphere[size1][size2];
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[i].length; j++)
                b[i][j] = new BerylliumSphere();
        return b;
    }

    public static void main(String[] args) {
        BerylliumSphere[][] spheres = initArrays(3, 2);
        System.out.println(Arrays.deepToString(spheres));
    }
}
/**output:
 * [[Shpere 0, Shpere 1], [Shpere 2, Shpere 3], [Shpere 4, Shpere 5]]
 */