package com.thinkinginjava.type_information.exercise.chapter14_2;

/**
 * @Author: monika
 * @Date: 2019/1/25 22:12
 * @Version: 1.0
 * @Description: page 318
 * 练习08：写一个方法，令它接受任意对象作为参数，并能够递归打印出该对象所在的继承
 * 体系中的所有类。
 */
class A {
    private int a1;
    protected int a2;
    public int a3;
}

class B extends A {
    private int b1;
    protected int b2;
    public int b3;
}

class C extends B {
    private int c1;
    protected int c2;
    public int c3;
}

public class Ex08 {
    public static void main(String[] args) {
        print(new C());
    }

    private static void print(Object obj) {
        Class<?> c = obj.getClass();
        if(c.getSuperclass() != null) {
            System.out.println(c + " is a subclass of " + c.getSuperclass());
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
 * class com.thinkinginjava.type_information.exercise.chapter14_2.C is a subclass of class com.thinkinginjava.type_information.exercise.chapter14_2.B
 * class com.thinkinginjava.type_information.exercise.chapter14_2.B is a subclass of class com.thinkinginjava.type_information.exercise.chapter14_2.A
 * class com.thinkinginjava.type_information.exercise.chapter14_2.A is a subclass of class java.lang.Object
 */