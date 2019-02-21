package com.thinkinginjava.arrays.exercise.chapter16_6;

import com.thinkinginjava.util.CountingGenerator;
import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description: page 450
 * 练习12：用CountingGenerator创建一个初始化过的double数组并打印结果。
 */
public class Ex12 {
    public static void main(String[] args) {
        double[] a = new double[6];
        CountingGenerator.Double d = new CountingGenerator.Double();
        for (int i = 0; i < a.length; i++)
            a[i] = d.next();
        System.out.println(Arrays.toString(a));
    }
}
/**output:
 * [0.0, 1.0, 2.0, 3.0, 4.0, 5.0]
 */