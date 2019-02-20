package com.thinkinginjava.arrays.exercise.chapter16_4;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description: page 440
 * 练习04：重复前一个练习，但改为三维数组。
 */
public class Ex04 {
    static double[][][] initArrays(int size1, int size2, int size3, double from, double to) {
        if (size1 < 0 || size2 < 0 || size3 < 0)
            return null;
        if (from > to)
            return null;
        Random random = new Random();
        double[][][] a = new double[size1][size2][size3];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                for (int k = 0; k < a[i][j].length; k++)
                    a[i][j][k] = random.doubles(from, to).iterator().nextDouble();

        return a;
    }
    static void print(int size1, int size2, int size3, double from, double to) {
        double[][][] a = initArrays(size1, size2, size3, from, to);
        System.out.println(Arrays.deepToString(a));
    }

    public static void main(String[] args) {
        print(2, 3, 1,1.0, 3.0);
        print(2, 3, 1,1.0, 5.0);
        print(3, 2, 2,1.0, 10.0);
    }
}
/**output:
 * [[[1.8405508362269432], [1.8400410432292404], [1.9296087344092911]], [[2.7066916849252527], [2.0641334687729507], [2.952629607026334]]]
 * [[[3.0425044514154016], [2.309027977577937], [3.883823106225996]], [[1.9372388172443227], [3.676728977457882], [2.429647926912878]]]
 * [[[8.312251981917289, 9.026108675478863], [1.0009188308124572, 6.185240516800075]], [[4.915031627636346, 5.870610152778673], [2.6679741823402123, 3.2777834372081083]], [[6.932222172958762, 1.7318603457792816], [7.951292233439925, 7.2002103565589]]]
 */