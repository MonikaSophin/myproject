package com.thinkinginjava.arrays.exercise.chapter16_3;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;
import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description: page 437
 * 练习02：编写一个方法，它接受一个int参数，并返回一个具有该尺寸的数组，用
 * BerylliumSphere对象填充该数组。
 */
public class Ex02 {
    static BerylliumSphere[] fillArrays(int size) {
        BerylliumSphere[] berys = new BerylliumSphere[size];
        // 使用fill(Object[] a, Object val)方法，数组中填充的只有一个val对象。
        Arrays.fill(berys, new BerylliumSphere());
        return berys;
    }

    static BerylliumSphere[] fillArrays2(int size) {
        BerylliumSphere[] berys = new BerylliumSphere[size];
        for (int i = 0; i < size; i++)
            berys[i] = new BerylliumSphere();
        return berys;
    }

    public static void main(String[] args) {
        System.out.println("使用fill(Object[] a, Object val)的结果:");
        BerylliumSphere[] berys = fillArrays(5);
        System.out.println(Arrays.toString(berys));
        System.out.println();

        BerylliumSphere[] berys2 = fillArrays2(5);
        System.out.println(Arrays.toString(berys2));
    }
}
/**output:
 * 使用fill(Object[] a, Object val)的结果:
 * [Shpere 0, Shpere 0, Shpere 0, Shpere 0, Shpere 0]
 *
 * [Shpere 1, Shpere 2, Shpere 3, Shpere 4, Shpere 5]
 */
