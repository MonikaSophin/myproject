package com.thinkinginjava.inner_classes.exercise.chapter10_4.package2;

import com.thinkinginjava.inner_classes.exercise.chapter10_4.package1.Interface1;

/**
 * @Author: monika
 * @Date: 2018/12/4 22:17
 * @Version: 1.0
 * @Description:
 */
public class Clazz1 {
    protected class InnerClazz1 implements Interface1{
        //必须需要公共构造函数创建一个在Clazz1的子例程:
        //否则在子类中创建不了该内部类对象。
        public InnerClazz1() {}
        @Override
        public void method() { System.out.println("Clazz1.InnerClazz1#method()"); }
    }

}
