package com.thinkinginjava.arrays.example.chapter16_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/2/19 21:05
 * @Version: 1.0
 * @Description:
 */
public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++)
            spheres[i] = new BerylliumSphere();
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        List<BerylliumSphere> sphereList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            sphereList.add(new BerylliumSphere());
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        List<Integer> intList = new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.add(97);
        System.out.println(intList);
        System.out.println(intList.get(4));
    }
}
/**output:
 * [Shpere 0, Shpere 1, Shpere 2, Shpere 3, Shpere 4, null, null, null, null, null]
 * Shpere 4
 * [Shpere 5, Shpere 6, Shpere 7, Shpere 8, Shpere 9]
 * Shpere 9
 * [0, 1, 2, 3, 4, 5]
 * 4
 * [0, 1, 2, 3, 4, 5, 97]
 * 4
 */
