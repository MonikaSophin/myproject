package com.thinkinginjava.reusing_classes.exercise.chapter7_2;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:51
 * @Version: 1.0
 * @Description: page 130
 * 练习08：修改练习05,使A和B以带参数的构造器取代默认的构造器。
 * 为C写一个构造器，并在其中执行所有的初始化。
 */
class A1 {
    A1(char c, int i) {
        System.out.println("A1(char, int)");}
}

class B1 extends A1 {
    B1(String s, float f){
        super(' ', 0);
        System.out.println("B1(String, float)");
    }
}

class C1 extends A1 {
    private char c;
    private int i;
    C1(char a, int j) {
        super(a, j);
        System.out.println("C1(char, int)");
        c = a;
        i = j;
    }
    B1 b = new B1("hi", 1f); // will then construct another A and then a B
}

public class Ex07{
    public static void main(String[] args) {
        new C1('b', 2); // will construct an A first
    }
}
/**输出：
 * A1(char, int)
 * A1(char, int)
 * B1(String, float)
 * C1(char, int)
 *
 * 结论：
 *  先初始化基类成员，然后初始化基类的构造器，再初始化自身成员，然后初始化自身构造器。
 */