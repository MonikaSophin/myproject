package com.thinkinginjava.generics.exercise.chapter15_8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: monika
 * @Date: 2019/2/13 20:30
 * @Version: 1.0
 * @Description: page 383
 * 练习22：使用类型标签与反射来创建一个方法，它将使用newInstance()的参数版本来
 * 创建某个类的对象，这个类拥有一个具有参数的构造器。
 */
class A {
    public A(String s) {
        System.out.println("init -> " + s);
    }
}

public class Ex22 {
    private static <T> T f(Class<T> tClass) {
        T t = null;
        try {
            Constructor<T> constructor = tClass.getConstructor(String.class);
            t = constructor.newInstance("带有参数");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) {
        A f = f(A.class);
    }
}
/**output:
 * init -> 带有参数
 */