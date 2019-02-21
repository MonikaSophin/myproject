package com.thinkinginjava.arrays.exercise.chapter16_6;

import com.thinkinginjava.util.ConvertTo;
import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.Generator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import static com.thinkinginjava.util.Print.print;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description: page 450
 * 练习16：从CountingGenerator.java开始，创建一个SkipGenerator类，它可以根据构造器
 * 参数，通过递增产生新值。修改TestArrayGeneration.java，以展示新类可以正确地工作。
 */
interface SkipGenerator<T> extends Generator<T> {
    T next(int n);
}

class CountingSkipGenerator {
    public static class Boolean implements SkipGenerator<java.lang.Boolean> {
        private boolean value = false;
        private int n;
        Boolean(int n) { this.n = n; }
        public java.lang.Boolean next() { return !value; }
        public java.lang.Boolean next(int n) {
            value = n % 2 == 0 ? true : false;
            return value;
        }
    }
    public static class Byte implements SkipGenerator<java.lang.Byte> {
        private byte value = 0;
        private int n;
        Byte(int n) { this.n = n; }
        public java.lang.Byte next() { return value++; }
        public java.lang.Byte next(int n) { return value += n; }
    }
    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static class Character implements SkipGenerator<java.lang.Character> {
        int index = -1;
        private int n;
        Character() { int index = -1; }
        Character(int n) { this.n = n; }
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
        public java.lang.Character next(int n) {
            index = (index + 1 + n) % chars.length;
            return chars[index];
        }
    }
    public static class String implements SkipGenerator<java.lang.String> {
        private int length = 7;
        SkipGenerator<java.lang.Character> cg = new Character();
        public String() {}
        public String(int length) { this.length = length; }
        public java.lang.String next() {
            char[] buf = new char[length];
            for(int i = 0; i < length; i++)
                buf[i] = cg.next();
            return new java.lang.String(buf);
        }
        public java.lang.String next(int n) {
            char[] buf = new char[length];
            for(int i = 0; i < length; i++)
                buf[i] = cg.next(n);
            return new java.lang.String(buf);
        }
    }
    public static class Short implements SkipGenerator<java.lang.Short> {
        private short value = 0;
        private int n;
        Short(int n) { this.n = n; }
        public java.lang.Short next() { return value++; }
        public java.lang.Short next(int n) { return value += n; }
    }
    public static class Integer implements SkipGenerator<java.lang.Integer> {
        private int value = 0;
        private int n;
        Integer(int n) { this.n = n; }
        public java.lang.Integer next() { return value++; }
        public java.lang.Integer next(int n) { return value += n; }
    }
    public static class Long implements SkipGenerator<java.lang.Long> {
        private long value = 0;
        private int n;
        Long(int n) { this.n = n; }
        public java.lang.Long next() { return value++; }
        public java.lang.Long next(int n) { return value += n; }
    }
    public static class Float implements SkipGenerator<java.lang.Float> {
        private float value = 0;
        private int n;
        Float(int n) { this.n = n; }
        public java.lang.Float next() {
            float result = value;
            value += 1.0;
            return result;
        }
        public java.lang.Float next(int n) {
            float result = value;
            value += (1.0 * n);
            return result;
        }
    }
    public static class Double implements SkipGenerator<java.lang.Double> {
        private double value = 0.0;
        private int n;
        Double(int n) { this.n = n; }
        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }
        public java.lang.Double next(int n) {
            double result = value;
            value += (1.0 * n);
            return result;
        }
    }
}

class CollectionData16<T> extends ArrayList<T> {
    public CollectionData16(SkipGenerator<T> gen, int size, int skip) {
        for(int i = 0; i < size; i++)
            add(gen.next(skip));
    }
}

class Generated16 {
    // 填充现有数组:
    public static <T> T[] array(T[] a, SkipGenerator<T> gen, int skip) {
        return new CollectionData16<>(gen, a.length, skip).toArray(a);
    }
    // 创建一个新数组:
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, SkipGenerator<T> gen, int size, int skip) {
        T[] a = (T[]) Array.newInstance(type, size);
        return new CollectionData16<>(gen, size, skip).toArray(a);
    }
}

public class Ex16 {
    public static void main(String[] args) {
        int size = 6;
        int skip = 3;
        boolean[] a1 = ConvertTo.primitive(Generated16.array(
                new Boolean[size], new CountingSkipGenerator.Boolean(skip), skip));
        byte[] a2 = ConvertTo.primitive(Generated16.array(
                new Byte[size], new CountingSkipGenerator.Byte(skip), skip));
        char[] a3 = ConvertTo.primitive(Generated16.array(
                new Character[size], new CountingSkipGenerator.Character(skip), skip));
        short[] a4 = ConvertTo.primitive(Generated16.array(
                new Short[size], new CountingSkipGenerator.Short(skip), skip));
        int[] a5 = ConvertTo.primitive(Generated16.array(
                Integer.class, new CountingSkipGenerator.Integer(skip), size, skip));
        long[] a6 = ConvertTo.primitive(Generated16.array(
                Long.class, new CountingSkipGenerator.Long(skip), size, skip));
        float[] a7 = ConvertTo.primitive(Generated16.array(
                Float.class, new CountingSkipGenerator.Float(skip), size, skip));
        double[] a8 = ConvertTo.primitive(Generated16.array(
                Double.class, new CountingSkipGenerator.Double(skip), size, skip));

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
 * boolean[] = [false, false, false, false, false, false]
 * byte[] = [3, 6, 9, 12, 15, 18]
 * char[] = [d, h, l, p, t, x]
 * short[] = [3, 6, 9, 12, 15, 18]
 * int[] = [3, 6, 9, 12, 15, 18]
 * long[] = [3, 6, 9, 12, 15, 18]
 * float[] = [0.0, 3.0, 6.0, 9.0, 12.0, 15.0]
 * double[] = [0.0, 3.0, 6.0, 9.0, 12.0, 15.0]
 */