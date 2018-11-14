package com.thinkinginjava.reusing_classes.exercise.chapter7_2;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:43
 * @Version: 1.0
 * @Description: page 129
 * 练习03：证明这句话。基类在导出类构造器可以访问它之前，就已经完成了初始化。即使你不为Cartoon()创建构造器，
 *                 编译器也会为你合成一个默认的构造器，该构造器将调用基类的构造器。
 */
class ClassA{
    public ClassA() {
        System.out.println("ClassA()");
    }
}

public class Ex03 extends ClassA{
    public Ex03() {
        super();
        System.out.println("Ex03()--在子类中基类的构造器总是会先被调用。");
    }

    public static void main(String[] args) {
        new Ex03();
    }
}
/**输出：
 * ClassA()
 * Ex03()--在子类中基类的构造器总是会先被调用。
 */