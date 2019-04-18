package com.thinkinginjava.annotations.example.chapter20_5;

import com.thinkinginjava.util.atunit.Test;

import java.util.HashSet;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class HashSetTest {
    HashSet<String> testObject = new HashSet<>();

    @Test void initialization() {
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
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\example\chapter20_5\HashSetTest
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.example.chapter20_5.HashSetTest
 *   . _remove
 *   . initialization
 *   . _contains
 * OK (3 tests)
 */