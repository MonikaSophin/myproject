package com.thinkinginjava.arrays.example.chapter16_6.ex16_6_3;

import com.thinkinginjava.util.ConvertTo;
import com.thinkinginjava.util.CountingGenerator;
import com.thinkinginjava.util.Generated;
import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description:
 */
public class PrimiticeConversionDemonstration {
    public static void main(String[] args) {
        Integer[] _a = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        int[] a = ConvertTo.primitive(_a);
        System.out.println(Arrays.toString(a));

        boolean[] b = ConvertTo.primitive(Generated.array(
                Boolean.class, new CountingGenerator.Boolean(), 7));
        System.out.println(Arrays.toString(b));
    }
}
/**output:
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
 * [true, false, true, false, true, false, true]
 */