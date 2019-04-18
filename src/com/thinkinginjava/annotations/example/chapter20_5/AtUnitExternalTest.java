package com.thinkinginjava.annotations.example.chapter20_5;

import com.thinkinginjava.util.atunit.Test;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class AtUnitExternalTest  extends AtUnitExample1 {
    @Test boolean _methodOne() {
        return methodOne().equals("This is methodOne");
    }
    @Test boolean _methodTwo() {
        return methodTwo() == 2;
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\example\chapter20_5\AtUnitExternalTest
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.example.chapter20_5.AtUnitExternalTest
 *   . _methodOne
 *   . _methodTwo This is methodTwo
 *
 * OK (2 tests)
 */
