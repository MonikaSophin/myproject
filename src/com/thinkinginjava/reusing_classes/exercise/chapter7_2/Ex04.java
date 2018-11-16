package com.thinkinginjava.reusing_classes.exercise.chapter7_2;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:45
 * @Version: 1.0
 * @Description: page 129
 * 练习04：证明基类构造器：（a）总是会被调用；（b）在导出类构造器之前被调用。
 */
public class Ex04 extends ClassA{
    public Ex04() {
        System.out.println("Ex04()--在子类中基类的构造器总是会先被调用。");
        //! super(); //编译出错--基类要在子类构造器的第一行。
    }

    public static void main(String[] args) {
        new Ex04();
    }
}
/**输出：
 * ClassA()
 * Ex04()--在子类中基类的构造器总是会先被调用。
 */