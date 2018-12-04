package com.thinkinginjava.inner_classes.exercise.chapter10_4;

import com.thinkinginjava.inner_classes.exercise.chapter10_4.package1.Interface1;
import com.thinkinginjava.inner_classes.exercise.chapter10_4.package3.Clazz2;

/**
 * @Author: monika
 * @Date: 2018/12/4 22:14
 * @Version: 1.0
 * @Description: page 195
 * 练习06：在第一个包中创建一个至少有一个方法的接口。然后在第二个包内创建一个类，
 * 在其中增加一个protected的内部类以实现那个接口。在第三个包中，继承这个类，并在
 * 一个方法中返回该protected内部类的对象，在返回的时候向上转型为第一个包中的接口的类型。
 */
public class Ex06 {
    public static void main(String[] args) {
        Clazz2 clazz2 = new Clazz2();
        Interface1 innerClazz1 = clazz2.getInnerClazz1();
        innerClazz1.method();
    }
}
/**输出：
 * Clazz1.InnerClazz1#method()
 */