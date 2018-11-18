package com.thinkinginjava.reusing_classes.exercise.chapter7_4;

/**
 * @Author: monika
 * @Date: 2018/11/17 18:27
 * @Version: 1.0
 * @Description: page 136
 * 练习13：创建一个类，它应带有一个被重载了三次的方法。继承产生了一个新类，并添加一个
 * 该方法的新的重载定义，展示这四个方法在导出类中都是可以使用的。
 */
class AClass{
    void f(char c){ System.out.println("f(char)"); }
    void f(float c){ System.out.println("f(float)"); }
    void f(int c){ System.out.println("f(int)"); }
    void f(double c){ System.out.println("f(double)"); }
}

public class Ex13 extends AClass{
    void f(String s){ System.out.println("f(String)"); }
    public static void main(String[] args) {
        Ex13 ex13 = new Ex13();
        ex13.f('c');
        ex13.f(1.0f);
        ex13.f(1);
        ex13.f(1.0d);
        ex13.f("String");
    }
}
/**输出：
 * f(char)
 * f(float)
 * f(int)
 * f(double)
 * f(String)
 */