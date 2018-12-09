package com.thinkinginjava.inner_classes.example.chapter10_6;

/**
 * @Author: monika
 * @Date: 2018/12/6 21:46
 * @Version: 1.0
 * @Description: 如果想做一些类似构造器的行为，该怎么办呢？在匿名类中不可能
 *              有命名构造器（因为它根本没名字！），但通过实例初始化，就能够
 *              达到为匿名内部类创建一个构造器的效果，例子如下：
 */
abstract class Base{
    public Base(int i){
        System.out.println("Base constructor,i = " + i);
    }
    public abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(int i){
        return new Base(i) {
            { System.out.println("Inside instance initializer"); }
            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
/**输出：
 * Base constructor,i = 47
 * Inside instance initializer
 * In anonymous f()
 */