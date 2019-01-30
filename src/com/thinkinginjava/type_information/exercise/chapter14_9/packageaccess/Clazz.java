package com.thinkinginjava.type_information.exercise.chapter14_9.packageaccess;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description:
 * 创建一个包含private、protected和包访问权限方法的类
 */
public class Clazz {
    static { System.out.println("static load"); }
    public Clazz() { System.out.println("Clazz init"); }

    private void f1() { System.out.println("private Clazz.f1()"); }
    protected void f2() { System.out.println("protected Clazz.f2()"); }
    String f3() {
        System.out.println("package Clazz.f3()");
        return "Clazz.f3() return value";
    }
}
