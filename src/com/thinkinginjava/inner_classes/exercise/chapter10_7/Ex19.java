package com.thinkinginjava.inner_classes.exercise.chapter10_7;

/**
 * @Author: monika
 * @Date: 2018/12/8 11:48
 * @Version: 1.0
 * @Description: page 202
 * 练习19：创建一个包含了内部类的类，而此内部类又包含内部类。使用嵌套类重复这
 * 个过程。注意编译器生成的.class文件的名字。
 */
public class Ex19 {
    public static class NestClass{
        public NestClass() { System.out.println("NestClass construction"); }
        public static class NestClass1{
            public NestClass1() { System.out.println("NestClass1 construction"); }
        }
    }

    public static void main(String[] args) {
        new NestClass();
        new NestClass.NestClass1();
    }
}
/**输出：
 * NestClass construction
 * NestClass1 construction
 *
 * .class文件名，如下：
 * Ex19$NestClass$NestClass1.class
 * Ex19$NestClass.class
 * Ex19.class
 */