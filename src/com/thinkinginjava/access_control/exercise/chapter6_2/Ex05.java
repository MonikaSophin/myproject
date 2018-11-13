package com.thinkinginjava.access_control.exercise.chapter6_2;

/**
 * @Author: monika
 * @Date: 2018/11/13 21:53
 * @Version: 1.0
 * @Description: page 120
 * 练习05：创建一个带有public，private，protected和包访问权限域以及方法成员的类。创建
 * 该类的一个对象，看看在你试图调用所有类成员时，会得到什么类型的编译信息。请注意：处于同一
 * 个目录中的所有类都是默认包的一部分。
 */
public class Ex05 {
    int a = 1;
    public int b = 2;
    protected int c = 3;
    private int d = 4;
    Ex05() { System.out.println("Ex05() constructor"); }
    void showa() { System.out.println(a); }
    public void showb() { System.out.println(b); }
    protected void showc() { System.out.println(c); }
    private void showd() { System.out.println(d); }
}


