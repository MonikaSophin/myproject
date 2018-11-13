package com.thinkinginjava.access_control.exercise.chapter6_4;

/**
 * @Author: monika
 * @Date: 2018/11/13 22:12
 * @Version: 1.0
 * @Description: page 123
 * 练习08：效仿示例Lunch.java的形式，创建一个名为ConnectionManager的类，该类管理
 * 一个元素为Connection对象的固定数组。客户端程序员不能直接创建Connection对象，而只能
 * 通过ConnectionManager中的某个static方法来获取它们，当ConnectionManager之外不再
 * 有对象时，它会返回null引用。在main()之中检测这些类。
 */
public class Ex08 {
    public static void main(String[] args) {
        System.out.println(ConnectionManager.howManyLeft);
        ConnectionManager.getConnection();
        System.out.println(ConnectionManager.howManyLeft);
        ConnectionManager.getConnection();
        System.out.println(ConnectionManager.howManyLeft);
        ConnectionManager.getConnection();

        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.howManyLeft);
    }
}
/**
 * 输出：
 * Connection()
 * Connection()
 * Connection()
 * 3
 * 2
 * 1
 * No more connections
 * null
 * 0
 */