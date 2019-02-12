package com.thinkinginjava.generics.example.chapter15_7;

import java.util.ArrayList;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class<? extends ArrayList> c1 = new ArrayList<String>().getClass();
        Class<? extends ArrayList> c2 = new ArrayList<Integer>().getClass();
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("c1 == c2 : " + (c1 == c2));
        System.out.println();

        /**
         * {@link Class#isPrimitive()} 确定指定的Class对象是否表示基本类型。
         */
        Class string = new String().getClass();
        Class int1 = int.class;
        System.out.println("string: " + string);
        System.out.println("int1: " + int1);
        System.out.println("string.isPrimitive(): " + string.isPrimitive());
        System.out.println("int1.isPrimitive(): " + int1.isPrimitive());
        System.out.println("string == int : " + (string == int1));
    }
}
/**output:
 * c1: class java.util.ArrayList
 * c2: class java.util.ArrayList
 * c1 == c2 : true
 *
 * string: class java.lang.String
 * int1: int
 * string.isPrimitive(): false
 * int1.isPrimitive(): true
 * string == int : false
 */