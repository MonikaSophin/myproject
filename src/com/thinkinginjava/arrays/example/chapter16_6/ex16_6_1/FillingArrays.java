package com.thinkinginjava.arrays.example.chapter16_6.ex16_6_1;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description:
 * {@link Arrays#fill(Object[], Object)} :
 *             只能用同一个值填充各个位置，而针对对象而言，就是复制同一个引用进行填充。
 * {@link Arrays#fill(Object[], int, int, Object)} :
 *             只填充数组的某个区域。
 */
public class FillingArrays {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        char[] a3 = new char[size];
        short[] a4 = new short[size];
        int[] a5 = new int[size];
        long[] a6 = new long[size];
        float[] a7 = new float[size];
        double[] a8 = new double[size];
        String[] a9 = new String[size];

        Arrays.fill(a1, true);
        Arrays.fill(a2, (byte) 11);
        Arrays.fill(a3, 'x');
        Arrays.fill(a4, (short) 17);
        Arrays.fill(a5, 19);
        Arrays.fill(a6, 23);
        Arrays.fill(a7, 29);
        Arrays.fill(a8, 47);
        Arrays.fill(a9, "Hello");

        System.out.println(String.format("a1 = %s", Arrays.toString(a1)));
        System.out.println(String.format("a2 = %s", Arrays.toString(a2)));
        System.out.println(String.format("a3 = %s", Arrays.toString(a3)));
        System.out.println(String.format("a4 = %s", Arrays.toString(a4)));
        System.out.println(String.format("a5 = %s", Arrays.toString(a5)));
        System.out.println(String.format("a6 = %s", Arrays.toString(a6)));
        System.out.println(String.format("a7 = %s", Arrays.toString(a7)));
        System.out.println(String.format("a8 = %s", Arrays.toString(a8)));
        System.out.println(String.format("a9 = %s", Arrays.toString(a9)));

        Arrays.fill(a9, 3, 5, "world");
        System.out.println(String.format("a9 = %s", Arrays.toString(a9)));
    }
}
/**output:
 * a1 = [true, true, true, true, true, true]
 * a2 = [11, 11, 11, 11, 11, 11]
 * a3 = [x, x, x, x, x, x]
 * a4 = [17, 17, 17, 17, 17, 17]
 * a5 = [19, 19, 19, 19, 19, 19]
 * a6 = [23, 23, 23, 23, 23, 23]
 * a7 = [29.0, 29.0, 29.0, 29.0, 29.0, 29.0]
 * a8 = [47.0, 47.0, 47.0, 47.0, 47.0, 47.0]
 * a9 = [Hello, Hello, Hello, Hello, Hello, Hello]
 * a9 = [Hello, Hello, Hello, world, world, Hello]
 */