package com.thinkinginjava.inner_classes.exercise.chapter10_7;

/**
 * @Author: monika
 * @Date: 2018/12/8 11:16
 * @Version: 1.0
 * @Description: page 202
 * 练习18：创建一个包含嵌套类的类。在main()中创建其内部类的实例。
 */
public class Ex18 {
    private static class NestedClass{
        public NestedClass() { System.out.println("NestedClass construction"); }
    }

    public static void main(String[] args) {
        new NestedClass();
    }
}
/**输出：
 * NestedClass construction
 */