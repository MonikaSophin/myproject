package com.thinkinginjava.access_control.exercise.chapter6_1;

import static com.thinkinginjava.access_control.exercise.chapter6_1.debug.Ex03Test.dubug;
import static com.thinkinginjava.access_control.exercise.chapter6_1.debugoff.Ex03Test.debug;

/**
 * @Author: monika
 * @Date: 2018/11/12 21:28
 * @Version: 1.0
 * @Description: page 115
 * 练习3:创建两个包：debug和debugoff，它们都包含一个相同的类，该类有一个debug()方法。
 * 第一个版本显示发送给控制台的String参数，而第二个版本什么也不做。使用静态import语句
 * 将该类导入到一个测试程序中，并示范条件编译效果。
 */
public class Ex03 {
    public static void main(String[] args) {
        debug("s");
    }
}
