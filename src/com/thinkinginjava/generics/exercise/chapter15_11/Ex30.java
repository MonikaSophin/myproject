package com.thinkinginjava.generics.exercise.chapter15_11;

import com.thinkinginjava.generics.example.chapter15_10.ex15_10_1.Holder;

/**
 * @Author: monika
 * @Date: 2019/2/15 21:50
 * @Version: 1.0
 * @Description: page 401
 * 练习30：为每一种基本类型的包装器类型都创建一个Holder,并展示自动包装盒自动
 * 拆包机制对每个实例的setValue()和getValue()方法都起作用。
 */
public class Ex30 {
    public static void main(String[] args) {
        Holder<Character> charHolder = new Holder<>();
        Holder<Byte> byteHolder = new Holder<>();
        Holder<Short> shortHolder = new Holder<>();
        Holder<Integer> intHolder = new Holder<>();
        Holder<Long> longHolder = new Holder<>();
        Holder<Float> floatHolder = new Holder<>();
        Holder<Double> doubleHolder = new Holder<>();

        // Autoboxing and autounboxing work:
        charHolder.setValue('a');
        System.out.print(charHolder.getValue() + ", ");
        System.out.println(charHolder.getValue().getClass());
        char c = charHolder.getValue();
        System.out.println("char c = charHolder.getValue() = " + c);
        System.out.println();

        byte b = 1;
        byteHolder.setValue(b);
        System.out.print(byteHolder.getValue() + ", ");
        System.out.println(byteHolder.getValue().getClass());
        byte bb = byteHolder.getValue();
        System.out.println("byte bb = byteHolder.getValue() = " + bb);
        System.out.println();

        short s = 1;
        shortHolder.setValue(s);
        System.out.print(shortHolder.getValue() + ", ");
        System.out.println(shortHolder.getValue().getClass());
        short ss = shortHolder.getValue();
        System.out.println("short ss = shortHolder.getValue() = " + ss);
        System.out.println();

        int i = 1;
        intHolder.setValue(i);
        System.out.print(intHolder.getValue() + ". ");
        System.out.println(intHolder.getValue().getClass());
        int i1 = intHolder.getValue();
        System.out.println("int i = intHolder.getValue() = " + i1);
        System.out.println();

        long l = 2;
        longHolder.setValue(l);
        System.out.print(longHolder.getValue() + ", ");
        System.out.println(longHolder.getValue().getClass());
        long ll = longHolder.getValue();
        System.out.println("long ll = longHolder.getValue() = " + ll);
        System.out.println();

        float f = 1f;
        floatHolder.setValue(f);
        System.out.print(floatHolder.getValue() + ", ");
        System.out.println(floatHolder.getValue().getClass());
        float ff = floatHolder.getValue();
        System.out.println("float ff = floatHolder.getValue() = " + ff);
        System.out.println();

        double d = 1.1;
        doubleHolder.setValue(d);
        System.out.print(doubleHolder.getValue() + ", ");
        System.out.println(doubleHolder.getValue().getClass());
        double dd = doubleHolder.getValue();
        System.out.println("double dd = doubleHolder.getValue() = " + dd);
    }
}
/**output:
 * a, class java.lang.Character
 * char c = charHolder.getValue() = a
 *
 * 1, class java.lang.Byte
 * byte bb = byteHolder.getValue() = 1
 *
 * 1, class java.lang.Short
 * short ss = shortHolder.getValue() = 1
 *
 * 1. class java.lang.Integer
 * int i = intHolder.getValue() = 1
 *
 * 2, class java.lang.Long
 * long ll = longHolder.getValue() = 2
 *
 * 1.0, class java.lang.Float
 * float ff = floatHolder.getValue() = 1.0
 *
 * 1.1, class java.lang.Double
 * double dd = doubleHolder.getValue() = 1.1
 */