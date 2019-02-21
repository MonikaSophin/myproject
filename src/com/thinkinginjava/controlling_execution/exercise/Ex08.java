package com.thinkinginjava.controlling_execution.exercise;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/6 22:24
 * @Version: 1.0
 * @Description: page 75
 * 练习08：写一个switch开关语句，为每个case打印一个消息。然后把这个switch放进for循环来测试每个case。
 * 先让每个case后面都有break，测试一下会怎样；然后把break删了，看看会怎样。
 */
public class Ex08 {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            switch (i) {
                case 0:
                    Print.print("zero");
                    //若此处没有break，当满足条件时，进入case语句。但是不会直接退出switch语句，直至遇到break为止。
                    break;
                case 1:
                    Print.print("one");
                    break;
                case 2:
                    Print.print("two");
                    break;
                case 3:
                    Print.print("three");
                    break;
                case 4:
                    Print.print("four");
                    break;
                case 5:
                    Print.print("five");
                    break;
                case 6:
                    Print.print("six");
                    break;
                case 7:
                    Print.print("seven");
                    break;
                case 8:
                    Print.print("eight");
                    break;
                case 9:
                    Print.print("nine");
                    break;
                default:
                    Print.print("default");
            }
        }
    }
}
/**输出：
 * zero
 * one
 * two
 * three
 * four
 * five
 * six
 * seven
 * eight
 * nine
 * default
 */
