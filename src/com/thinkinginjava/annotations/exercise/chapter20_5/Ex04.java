package com.thinkinginjava.annotations.exercise.chapter20_5;

import com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample2;
import com.thinkinginjava.util.atunit.Test;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description: page 638
 * 练习04：验证是否每个测试都会生成一个新的testObject。
 */
public class Ex04 {
    AtUnitExample2 testObject = new AtUnitExample2();

    @Test boolean _methodOne() {
        return testObject.methodOne().equals("This is methodOne");
    }
    @Test boolean _methodTwo() {
        return testObject.methodTwo() == 2;
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\exercise\chapter20_5\Ex04
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.exercise.chapter20_5.Ex04
 *   . _methodOne
 *   . _methodTwo This is methodTwo
 *
 * OK (2 tests)
 */