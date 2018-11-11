package com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:40
 * @Version: 1.0
 * @Description:
 */
public class OverloadingVarargs2 {
    static void f(float i, Character... args) {
        System.out.println("first");
    }
    static void f(Character... args) {
        System.out.print("second");
    }
    public static void main(String[] args) {
       //! f(1, 'a');
       //！ f('a', 'b');
    }
}
/**
 * 手动编译它，得到错误的消息：
 *   对象的引用不明确。
 * 解决方法：给两个方法都添加一个非可变参数。
 */