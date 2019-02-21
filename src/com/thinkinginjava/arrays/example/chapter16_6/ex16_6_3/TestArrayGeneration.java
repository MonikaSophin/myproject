package com.thinkinginjava.arrays.example.chapter16_6.ex16_6_3;

import com.thinkinginjava.util.ConvertTo;
import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.RandomGenerator;

import java.util.Arrays;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description:
 */
public class TestArrayGeneration {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = ConvertTo.primitive(Generated.array(
                Boolean.class, new RandomGenerator.Boolean(), size));
        byte[] a2 = ConvertTo.primitive(Generated.array(
                Byte.class, new RandomGenerator.Byte(), size));
        char[] a3 = ConvertTo.primitive(Generated.array(
                Character.class, new RandomGenerator.Character(), size));
        short[] a4 = ConvertTo.primitive(Generated.array(
                Short.class, new RandomGenerator.Short(), size));
        int[] a5 = ConvertTo.primitive(Generated.array(
                Integer.class, new RandomGenerator.Integer(), size));
        long[] a6 = ConvertTo.primitive(Generated.array(
                Long.class, new RandomGenerator.Long(), size));
        float[] a7 = ConvertTo.primitive(Generated.array(
                Float.class, new RandomGenerator.Float(), size));
        double[] a8 = ConvertTo.primitive(Generated.array(
                Double.class, new RandomGenerator.Double(), size));

        print(String.format("boolean[] = %s", Arrays.toString(a1)));
        print(String.format("byte[] = %s", Arrays.toString(a2)));
        print(String.format("char[] = %s", Arrays.toString(a3)));
        print(String.format("short[] = %s", Arrays.toString(a4)));
        print(String.format("int[] = %s", Arrays.toString(a5)));
        print(String.format("long[] = %s", Arrays.toString(a6)));
        print(String.format("float[] = %s", Arrays.toString(a7)));
        print(String.format("double[] = %s", Arrays.toString(a8)));
    }
}
/**output:
 * boolean[] = [true, false, true, false, false, true]
 * byte[] = [104, -79, -76, 126, 33, -64]
 * char[] = [Z, n, T, c, Q, r]
 * short[] = [-13408, 22612, 15401, 15161, -28466, -12603]
 * int[] = [7704, 7383, 7706, 575, 8410, 6342]
 * long[] = [7674, 8804, 8950, 7826, 4322, 896]
 * float[] = [0.01, 0.2, 0.4, 0.79, 0.27, 0.45]
 * double[] = [0.16, 0.87, 0.7, 0.66, 0.87, 0.59]
 */