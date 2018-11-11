package com.thinkinginjava.Initialize_clean.exercise.chapter5_3;

/**
 * @Author: monika
 * @Date: 2018/11/9 22:33
 * @Version: 1.0
 * @Description: page 83
 * 练习06：修改前一个练习的程序，让两个重载方法各自接受两个类型的不同的参数，但
 * 二者顺序相反。验证其是否工作。
 */
class Dog2 {
    public void barking(int x, char y) {
        System.out.println("int: " + x + " char: " + y);
    }
    public void barking(char x, int y) {
        System.out.println("char: " + x + " int: " + y);
    }
}

public class Ex06 {
    public static void main(String[] args) {
        Dog2 dog =  new Dog2();
        int a = 97;
        char b = 'b';
        dog.barking(a,b);
        dog.barking(b,a);
    }
}
/**输出：
 * int: 97 char: b
 * char: b int: 97
 */
