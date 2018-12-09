package com.thinkinginjava.inner_classes.exercise.chapter10_7;

/**
 * @Author: monika
 * @Date: 2018/12/8 20:34
 * @Version: 1.0
 * @Description: page 203
 * 练习20; 创建一个包含嵌套类的接口，实现此接口并创建嵌套类的实例。
 */
public interface Ex20 {
    void method20();
    class NestClazz20 implements Ex20{
        @Override
        public void method20() { System.out.println("NestClazz20#method20()"); }
    }

    public static void main(String[] args) {
        NestClazz20 clazz20 = new NestClazz20();
        clazz20.method20();
    }
}
/**输出：
 * NestClazz20#method20()
 */