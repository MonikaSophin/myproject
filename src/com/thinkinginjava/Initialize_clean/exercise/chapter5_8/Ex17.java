package com.thinkinginjava.Initialize_clean.exercise.chapter5_8;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:10
 * @Version: 1.0
 * @Description: page 101
 * 创建一个类，它有一个接受一个String参数的构造器。在构造阶段，打印该参数。
 * 创建一个该类的对象引用数组，但是不实际去创建对象赋值给该数组。当运行程序时，
 * 请注意来自对该构造器的调用中的初始化消息是否打印了出来。
 */
class InitTest {
    InitTest(String s) {
        System.out.println("InitTest()");
        System.out.println(s);
    }
}

public class Ex17 {
    public static void main(String[] args) {
        InitTest[] it = new InitTest[10];//仅仅是数组对象引用，并无赋值对象。
    }
}

