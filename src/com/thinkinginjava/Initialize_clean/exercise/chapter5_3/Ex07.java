package com.thinkinginjava.Initialize_clean.exercise.chapter5_3;

/**
 * @Author: monika
 * @Date: 2018/11/9 22:40
 * @Version: 1.0
 * @Description: page 83
 * 练习07：创建一个没有构造器的类，并在main()方法中创建其对象，用以验证编译器是否真
 * 的自动加入了默认构造器。
 */
class Clazz {
    void test() {
        System.out.println("验证编译器是否自动加入默认构造器（无参构造器）？");
        System.out.println("该对象被创建才能调用此方法！");
    }
}

public class Ex07 {
    public static void main(String[] args) {
        new Clazz().test();
    }
}
/**输出：
 * 验证编译器是否自动加入默认构造器（无参构造器）？
 * 该对象被创建才能调用此方法！
 */