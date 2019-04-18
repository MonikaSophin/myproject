package com.thinkinginjava.annotations.example.chapter20_5;

import com.thinkinginjava.util.atunit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description: java assert断言机制 一般要求程序员在java命令行中加上-ea参数。
 */
public class AtUnitExample2 {
    public String methodOne() {
        return "This is methodOne";
    }
    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test void assertExample() {
        assert methodOne().equals("This is methodOne");
    }
    @Test void assertFailureException() {
        assert 1 == 2 : "What a surprise!";
    }
    @Test void exceptionExample() throws IOException {
        new FileInputStream("nofile.txt");
    }
    @Test boolean assertAndReturn() {
        assert methodTwo() == 2: "methodTwo must equal 2";
        return methodOne().equals("This is methodOne");
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\example\chapter20_5\AtUnitExample2
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample2
 *   . assertFailureException java.lang.AssertionError: What a surprise!
 * (failed)
 *   . assertExample
 *   . exceptionExample java.io.FileNotFoundException: nofile.txt (系统找不到指定的文件。)
 * (failed)
 *   . assertAndReturn This is methodTwo
 *
 * (4 tests)
 *
 * >>> 2 FAILURES <<<
 *   com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample2: assertFailureException
 *   com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample2: exceptionExample
 */