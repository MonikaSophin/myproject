package com.thinkinginjava.annotations.exercise.chapter20_5;

import com.thinkinginjava.annotations.example.chapter20_5.HashSetTest;
import com.thinkinginjava.util.atunit.Test;

import java.util.LinkedList;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description: page 638
 * 练习06：使用{@link HashSetTest}演示的方式测试LinkedList类。
 */
public class Ex06 {
    LinkedList<String> testObject = new LinkedList<>();

    @Test
    void initialization() {
        assert testObject.isEmpty();
    }
    @Test void _contains() {
        testObject.add("one");
        assert testObject.contains("one");
    }
    @Test void _remove() {
        testObject.add("one");
        testObject.remove("one");
        assert testObject.isEmpty();
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\exercise\chapter20_5\Ex06
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.exercise.chapter20_5.Ex06
 *   . _remove
 *   . initialization
 *   . _contains
 * OK (3 tests)
 */