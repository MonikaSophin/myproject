package com.thinkinginjava.inner_classes.exercise.chapter10_7;

/**
 * @Author: monika
 * @Date: 2018/12/8 20:39
 * @Version: 1.0
 * @Description: page 203
 * 练习21：创建一个包含嵌套类的接口，该嵌套类中有一个static方法，它将调用接口中
 * 的方法并显示结果。实现这个接口，并将这个实现的一个实例传递给这个方法。
 */
interface Interface21{
    void method21();
    class NestClazz21 {
        public static void staticMethod21(Interface21 interface21) {
            interface21.method21();
        }
    }
}

public class Ex21 {
    class Clazz21 implements Interface21{
        @Override
        public void method21() { System.out.println("Ex21$Clazz21#method21()"); }
    }

    public static void main(String[] args) {
        Ex21 ex21 = new Ex21();
        Clazz21 clazz21 = ex21.new Clazz21();
        Interface21.NestClazz21.staticMethod21(clazz21);
    }
}
/**输出：
 * Ex21$Clazz21#method21()
 */