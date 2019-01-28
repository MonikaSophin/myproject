package com.thinkinginjava.type_information.exercise.chapter14_2;

/**
 * @Author: monika
 * @Date: 2019/1/25 22:26
 * @Version: 1.0
 * @Description: page 318
 * 练习10：写一个程序，使它能判断char数组究竟是个基本类型，还是一个对象。
 */
public class Ex10 {
    public static void main(String[] args) {
        char[] c = new char[10];
        // c is an Object:
        System.out.println("Superclass of char[] c: " +
                c.getClass().getSuperclass());
        System.out.println("char[] c instanceof Object: " +
                (c instanceof Object));
    }
}
/**output:
 * Superclass of char[] c: class java.lang.Object
 * char[] c instanceof Object: true
 */