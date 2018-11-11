package com.thinkinginjava.Initialize_clean.exercise.chapter5_4;

/**
 * @Author: monika
 * @Date: 2018/11/9 22:47
 * @Version: 1.0
 * @Description: page 85
 * 练习08：编写具有两个方法的类，在第一个方法内调用第二个方法两次：第一次调用时
 * 不使用this关键字，第二次调用时使用this关键字——这里只是为了验证它是起作用的，
 * 你不该在实践中使用这种方式。
 */
public class Ex08 {
    void test1(){
        System.out.println("在test1()方法内调用两次test()方法");
        this.test2();//使用this
        test2();//不使用this
    }
    void test2(){
        System.out.println("test2");
    }

    public static void main(String[] args) {
        new Ex08().test1();
    }
}
/**
 * 在test1()方法内调用两次test()方法
 * test2
 * test2
 */