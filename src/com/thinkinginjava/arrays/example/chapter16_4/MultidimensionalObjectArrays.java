package com.thinkinginjava.arrays.example.chapter16_4;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
public class MultidimensionalObjectArrays {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
                { new BerylliumSphere(), new BerylliumSphere() },
                { new BerylliumSphere(), new BerylliumSphere(),
                  new BerylliumSphere(), new BerylliumSphere() },
                { new BerylliumSphere(), new BerylliumSphere(),
                  new BerylliumSphere(), new BerylliumSphere(),
                  new BerylliumSphere(), new BerylliumSphere() }
        };
        System.out.println(Arrays.deepToString(spheres));
    }
}
/**output:
 * [[Shpere 0, Shpere 1], [Shpere 2, Shpere 3, Shpere 4, Shpere 5], [Shpere 6, Shpere 7, Shpere 8, Shpere 9, Shpere 10, Shpere 11]]
 */