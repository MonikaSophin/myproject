package com.thinkinginjava.type_information.exercise.chapter14_2;

import java.lang.reflect.Field;

/**
 * @Author: monika
 * @Date: 2019/1/25 22:19
 * @Version: 1.0
 * @Description: page 318
 * 练习09：修改前一个练习，让这个方法使用Class.getDeclaredFields()来打印一个类中的
 * 域的相关信息。
 */
public class Ex09 {
    public static void main(String[] args) {
        print(new C());
    }

    private static void print(Object obj) {
        Class<?> c = obj.getClass();
        if(c.getSuperclass() != null) {
            Field[] declaredFields = c.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField);
            }
            try {
                print(c.getSuperclass().newInstance());
            } catch(InstantiationException e) {
                System.out.println("Unable to instantiate obj");
            } catch(IllegalAccessException e) {
                System.out.println("Unable to access");
            }
        }
    }
}
/**output:
 * private int com.thinkinginjava.type_information.exercise.chapter14_2.C.c1
 * protected int com.thinkinginjava.type_information.exercise.chapter14_2.C.c2
 * public int com.thinkinginjava.type_information.exercise.chapter14_2.C.c3
 * private int com.thinkinginjava.type_information.exercise.chapter14_2.B.b1
 * protected int com.thinkinginjava.type_information.exercise.chapter14_2.B.b2
 * public int com.thinkinginjava.type_information.exercise.chapter14_2.B.b3
 * private int com.thinkinginjava.type_information.exercise.chapter14_2.A.a1
 * protected int com.thinkinginjava.type_information.exercise.chapter14_2.A.a2
 * public int com.thinkinginjava.type_information.exercise.chapter14_2.A.a3
 */