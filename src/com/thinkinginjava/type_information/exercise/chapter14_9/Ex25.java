package com.thinkinginjava.type_information.exercise.chapter14_9;

import com.thinkinginjava.type_information.exercise.chapter14_9.packageaccess.Clazz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description: page 350
 * 练习25：创建一个包含private、protected和包访问权限方法的类，编写代码在该类所处的包
 * 的外部调用访问这些方法。
 */
public class Ex25 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Clazz clazz = new Clazz();
        System.out.println();

        Method f1 = clazz.getClass().getDeclaredMethod("f1");
        f1.setAccessible(true);
        System.out.println(f1.invoke(clazz));
        System.out.println();

        Method f2 = clazz.getClass().getDeclaredMethod("f2");
        f2.setAccessible(true);
        System.out.println(f2.invoke(clazz));
        System.out.println();

        Method f3 = clazz.getClass().getDeclaredMethod("f3");
        f3.setAccessible(true);
        Object invoke3 = f3.invoke(clazz);
        System.out.println(invoke3);
    }
}
/**output:
 * static load
 * Clazz init
 *
 * private Clazz.f1()
 * null
 *
 * protected Clazz.f2()
 * null
 *
 * package Clazz.f3()
 * Clazz.f3() return value
 */