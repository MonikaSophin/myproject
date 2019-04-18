package com.thinkinginjava.annotations.example.chapter20_5;

import com.thinkinginjava.util.atunit.Test;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class AtUnitCompsition {
    AtUnitExample1 testObject = new AtUnitExample1();

    @Test
    boolean _methodOne() {
        return testObject.methodOne().equals("This is methodOne");
    }
    @Test boolean _methodTwo() {
        return testObject.methodTwo() == 2;
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\example\chapter20_5\AtUnitCompsition
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.example.chapter20_5.AtUnitCompsition
 *   . _methodOne
 *   . _methodTwo This is methodTwo
 *
 * OK (2 tests)
 */