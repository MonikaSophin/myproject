package com.thinkinginjava.arrays.example.chapter16_2;

import com.thinkinginjava.arrays.example.chapter16_1.BerylliumSphere;
import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
public class ArrayOptions {
    public static void main(String[] args) {
        BerylliumSphere[] a;
        //数组聚集初始化
        BerylliumSphere[] b = new BerylliumSphere[5];
        System.out.println("b: " + Arrays.toString(b));
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == null)
                c[i] = new BerylliumSphere();
        }
        //聚集初始化
        BerylliumSphere[] d = { new BerylliumSphere(),
                new BerylliumSphere(), new BerylliumSphere() };
        //动态地聚集初始化
        a = new BerylliumSphere[]{ new BerylliumSphere(), new BerylliumSphere() };


        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);
        a = d;
        System.out.println("a.length = " + a.length);
        System.out.println();

        int[] e;
        int[] f = new int[5];
        System.out.println("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++)
            g[i] = i*i;
        int[] h = { 11, 47, 93 };

        //! System.out.println("e.length = " + e.length);
        System.out.println("f.length = " + f.length);
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        e = h;
        System.out.println("e.length = " + e.length);
        e = new int[]{ 1, 2 };
        System.out.println("e.length = " + e.length);
    }
}
/**output:
 * b: [null, null, null, null, null]
 * a.length = 2
 * b.length = 5
 * c.length = 4
 * d.length = 3
 * a.length = 3
 *
 * f: [0, 0, 0, 0, 0]
 * f.length = 5
 * g.length = 4
 * h.length = 3
 * e.length = 3
 * e.length = 2
 */