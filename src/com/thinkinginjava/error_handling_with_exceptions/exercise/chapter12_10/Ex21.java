package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_10;

/**
 * @Author: monika
 * @Date: 2018/12/30 16:24
 * @Version: 1.0
 * @Description: page 275
 * 练习21：试证明，派生类的构造器不能捕获它的基类构造器所抛出的异常。
 */
class ExceptionA extends Exception{}

class A {
    public A() throws ExceptionA{
        throw new ExceptionA();
    }
}
class B extends A{
    public B() throws ExceptionA {
        super();
//        try{
//           // 调用'super()'必须是构造函数体中的第一条语句
//            super();
//        }catch (ExceptionA e){
//            System.out.println("Caught ExceptionA in B constructor");
//        }
    }
}

public class Ex21 {
    public static void main(String[] args) {
        try {
            new B();
        } catch (ExceptionA e) {
            System.out.println("Caught ExceptionA in main()");
        }
    }
}
/**output:
 * Caught ExceptionA in main()
 */