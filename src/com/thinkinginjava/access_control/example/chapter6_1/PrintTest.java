package com.thinkinginjava.access_control.example.chapter6_1;

import static com.thinkinginjava.access_control.example.chapter6_1.mypackage.Print.print;

/**
 * @Author: monika
 * @Date: 2018/11/12 21:47
 * @Version: 1.0
 * @Description:   方法或成员变量 必须 是static修饰的，才能使用静态导入（import static）。
 */
public class PrintTest {
    public static void main(String[] args) {
        print("Available from now on!");
        print(100);
        print(100L);
        print(3.14159);
    }
}
/**输出：
 * Available from now on!
 * 100
 * 100
 * 3.14159
 */