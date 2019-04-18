package com.thinkinginjava.annotations.exercise.chapter20_5;

import com.thinkinginjava.util.atunit.Test;

import java.util.LinkedList;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description: page 638
 * 练习07：使用继承的方式修改前一个练习的结果。
 */
public class Ex07 extends LinkedList<String> {
    @Test
    void initialization() {
        assert this.isEmpty();
    }
    @Test void _contains() {
        this.add("one");
        assert this.contains("one");
    }
    @Test void _remove() {
        this.add("one");
        this.remove("one");
        assert this.isEmpty();
    }
    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\exercise\chapter20_5\Ex07
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.exercise.chapter20_5.Ex07
 *   . _remove
 *   . initialization
 *   . _contains
 * OK (3 tests)
 */