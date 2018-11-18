package com.thinkinginjava.reusing_classes.exercise.chapter7_8;

/**
 * @Author: monika
 * @Date: 2018/11/18 12:36
 * @Version: 1.0
 * @Description: page 145
 * 练习22：创建一个final类并试着继承它。
 */
final class Clazz{
    private int i;
    void f(){}
}

//! error: Cannot inherit from final 'Clazz'
//! public class Ex22 extends Clazz{ }

public class Ex22{}