package com.thinkinginjava.annotations.example.chapter20_5;

import com.thinkinginjava.util.atunit.Test;
import com.thinkinginjava.util.atunit.TestObjectCreate;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class AtUnitExample3 {
    private int n;
    public AtUnitExample3(int n) { this.n = n; }
    public int getN() { return n; }
    public String methodOne() {
        return "This is methodOne";
    }
    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @TestObjectCreate static AtUnitExample3 create() {
        return new AtUnitExample3(47);
    }
    @Test boolean initlization() {
        return n == 47;
    }
    @Test boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }
    @Test boolean m2() {
        return methodTwo() == 2;
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\example\chapter20_5\AtUnitExample3
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample3
 *   . m2 This is methodTwo
 *   . methodOneTest
 *   . initlization
 * OK (3 tests)
 */