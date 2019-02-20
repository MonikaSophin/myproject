package com.thinkinginjava.arrays.exercise.chapter16_4;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description: page 440
 * 练习03：编写一个方法，能够产生二维双精度型数组并加以初始化。数组的容量由方法
 * 的形式参数决定，其初值必须落在另外两个形式参数所指定的区间之内。编写第二个方法，
 * 打印出第一个方法所产生的数组。在main()中通过产生不同容量的数组并打印其内容来
 * 测试这两个方法。
 */
public class Ex03 {
    static double[][] initArrays(int size1, int size2, double from, double to) {
        if (size1 < 0 || size2 < 0)
            return null;
        if (from > to)
            return null;
        Random random = new Random();
        double[][] a = new double[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                a[i][j] = random.doubles(from, to).iterator().nextDouble();
            }
        }
        return a;
    }
    static void print(int size1, int size2, double from, double to) {
        double[][] a = initArrays(size1, size2, from, to);
        System.out.println(Arrays.deepToString(a));
    }

    public static void main(String[] args) {
        print(2, 3, 1.0, 3.0);
        print(2, 3, 1.0, 5.0);
        print(3, 2, 1.0, 10.0);
        print(3, 2, 2.0, 1.0);
    }
}
/**output(10% match):
 * [[1.1389066509587493, 1.864466036766873, 1.606248776996735], [1.2615908876534334, 1.4670424611463464, 1.2347618186473475]]
 * [[2.352536293353525, 2.7856593205370994, 2.39072223834094], [2.8557420516077436, 4.9011617208355, 4.30103497109659]]
 * [[2.003086028544429, 8.561652531043132], [6.894122387415521, 1.599005155538828], [2.5254787707576716, 9.983186922371393]]
 * null
 */