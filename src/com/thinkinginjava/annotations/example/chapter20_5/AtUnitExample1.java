package com.thinkinginjava.annotations.example.chapter20_5;

import com.thinkinginjava.util.atunit.Test;
import java.io.IOException;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class AtUnitExample1 {
    public String methodOne() {
        return "This is methodOne";
    }
    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }
    @Test boolean m2() {
        return methodTwo() == 2;
    }
    @Test private boolean m3() {
        return true;
    }
    @Test boolean failureTest() {
        return false;
    }
    @Test boolean anotherDisappointment() {
        return false;
    }

    public static void main(String[] args) throws IOException {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\example\chapter20_5\AtUnitExample1
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample1
 *   . anotherDisappointment (failed)
 *   . methodOneTest
 *   . failureTest (failed)
 *   . m2 This is methodTwo
 *
 *   . m3
 * (5 tests)
 *
 * >>> 2 FAILURES <<<
 *   com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample1: anotherDisappointment
 *   com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample1: failureTest
 */