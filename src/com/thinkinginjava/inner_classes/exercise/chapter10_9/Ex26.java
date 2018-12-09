package com.thinkinginjava.inner_classes.exercise.chapter10_9;

/**
 * @Author: monika
 * @Date: 2018/12/9 20:17
 * @Version: 1.0
 * @Description: page 212
 * 练习26：创建一个包含内部类的类，此内部类有一个非默认的构造器（需要参数的构造器）。
 * 创建另一个也包含内部类的类，此内部类继承自第一个内部类。
 */
class Clazz26{
    class InnerClazz26{
        InnerClazz26(int i) { System.out.println("Clazz26$InnerClazz26 -- " + i); }
    }
}

class Clazz26_1{
    class InnerClazz26_1 extends Clazz26.InnerClazz26{
        InnerClazz26_1(Clazz26 clazz26 ,int i) {
            clazz26.super(i);
            System.out.println("Clazz26_1$InnerClazz26_1 -- " + i);
        }
    }
}

public class Ex26 {
    public static void main(String[] args) {
        Clazz26 clazz26 = new Clazz26();
        Clazz26_1 clazz26_1 = new Clazz26_1();
        Clazz26_1.InnerClazz26_1 innerClazz26_1
                = clazz26_1.new InnerClazz26_1(clazz26,47);
    }
}
/**输出：
 * Clazz26$InnerClazz26 -- 47
 * Clazz26_1$InnerClazz26_1 -- 47
 */