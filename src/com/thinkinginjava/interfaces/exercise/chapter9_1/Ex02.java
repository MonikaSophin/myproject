package com.thinkinginjava.interfaces.exercise.chapter9_1;

/**
 * @Author: monika
 * @Date: 2018/11/23 21:21
 * @Version: 1.0
 * @Description: page 171
 * 练习02：创建一个不包含任何抽象方法的抽象类，并验证我们不能为该类创建任何实例。
 */
abstract class AbstractClass {
}

public class Ex02 {
    public static void main(String[] args) {
        AbstractClass abstractClass;
        //  'AbstractClass' is abstract; cannot be instantiated
        //! abstractClass = new AbstractClass();
    }
}
