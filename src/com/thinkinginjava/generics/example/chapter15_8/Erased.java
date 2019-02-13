package com.thinkinginjava.generics.example.chapter15_8;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/13
 * @description:
 *  泛型类型只有在静态类型检查期间才出现。
 *  在此之后，程序中的所有泛型类型都将被擦除，替换为它们的非泛型上界。
 */
public class Erased<T> {
    private final int SIZE = 100;
    public static void f(Object arg) {
       //!! if (arg instanceof T){} //编译错误：不能从静态上下文中引用
       //!! T t = new T(); //编译错误：不能从静态上下文中引用
       //!! T[] array = new T[SIZE]; //编译错误：不能从静态上下文中引用
       //!! T[] array = (T)new Object[SIZE]; //编译错误：不能从静态上下文中引用
    }
}
