package com.thinkinginjava.interfaces.exercise.chapter9_1;

/**
 * @Author: monika
 * @Date: 2018/11/23 21:24
 * @Version: 1.0
 * @Description: page 171
 * 练习03：创建一个基类，让它包含抽象方法print(),并在导出类中覆盖该方法。覆盖后
 * 的方法版本可以打印导出类中定义的某个整型变量的值。在定义该变量之处，赋予它非零值。
 * 在基类的构造器中调用这个方法。现在，在main()方法中，创建一个导出类对象，然后调用它
 * 的print()方法。请解释发生的情形。
 */
abstract class A{
    public A() { print(); }
    abstract void print();
}

class B extends A{
    private int i = 47;
    @Override
    void print() { System.out.println(i); }
}

public class Ex03 {
    public static void main(String[] args) {
        B b = new B();
        b.print();
    }
}
/**输出：
 * 0
 * 47
 *
 * 基类为抽象类时，子类继承该基类（仍然具有继承的特性）。
 * 在构造子类的对象时，会先访问基类的构造器，在此之前，基类的成员变量已经初始化完毕，
 * 而后，才是子类构造器的执行。
 */