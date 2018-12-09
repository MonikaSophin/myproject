package com.thinkinginjava.inner_classes.exercise.chapter10_4.package2;

import com.thinkinginjava.inner_classes.exercise.chapter10_4.package1.Interface1;

/**
 * @Author: monika
 * @Date: 2018/12/4 22:17
 * @Version: 1.0
 * @Description:
 */
public class Clazz1 {
    /**
     * 该protected访问权限修饰符表示的是 该内部类的访问权限修饰。并不是作为Clazz1成员的访问权限。
     * 所以，如果Clazz1的子类中没有继承该内部类的类则访问不了该内部类成员。
     */
    protected class InnerClazz1 implements Interface1{
        //此处构造函数为public，是为了package3/Clazz2中能创建该内部类的对象。
        //否则在子类中创建不了该内部类对象。
        public InnerClazz1() {}
        @Override
        public void method() { System.out.println("Clazz1.InnerClazz1#method()"); }
    }

}
