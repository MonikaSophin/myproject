package com.thinkinginjava.arrays.exercise.chapter16_6;

import com.thinkinginjava.util.ConvertTo;
import com.thinkinginjava.util.CountingGenerator;
import com.thinkinginjava.util.Generated;
import java.util.Arrays;
import static com.thinkinginjava.util.Print.print;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description: page 450
 * 练习14：对每个基本类型都创建一个数组，然后用CountingGenerator来填充每个数组并打印所有的数组。
 */
public class Ex14 {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = ConvertTo.primitive(Generated.array(
                Boolean.class, new CountingGenerator.Boolean(), size));
        byte[] a2 = ConvertTo.primitive(Generated.array(
                Byte.class, new CountingGenerator.Byte(), size));
        char[] a3 = ConvertTo.primitive(Generated.array(
                Character.class, new CountingGenerator.Character(), size));
        short[] a4 = ConvertTo.primitive(Generated.array(
                Short.class, new CountingGenerator.Short(), size));
        int[] a5 = ConvertTo.primitive(Generated.array(
                Integer.class, new CountingGenerator.Integer(), size));
        long[] a6 = ConvertTo.primitive(Generated.array(
                Long.class, new CountingGenerator.Long(), size));
        float[] a7 = ConvertTo.primitive(Generated.array(
                Float.class, new CountingGenerator.Float(), size));
        double[] a8 = ConvertTo.primitive(Generated.array(
                Double.class, new CountingGenerator.Double(), size));

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
 * boolean[] = [true, false, true, false, true, false]
 * byte[] = [0, 1, 2, 3, 4, 5]
 * char[] = [a, b, c, d, e, f]
 * short[] = [0, 1, 2, 3, 4, 5]
 * int[] = [0, 1, 2, 3, 4, 5]
 * long[] = [0, 1, 2, 3, 4, 5]
 * float[] = [0.0, 1.0, 2.0, 3.0, 4.0, 5.0]
 * double[] = [0.0, 1.0, 2.0, 3.0, 4.0, 5.0]
 */