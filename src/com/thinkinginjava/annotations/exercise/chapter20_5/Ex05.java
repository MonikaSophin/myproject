package com.thinkinginjava.annotations.exercise.chapter20_5;

import com.thinkinginjava.util.atunit.Test;

import java.util.HashSet;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class Ex05 extends HashSet<String> {
    @Test void initialization() {
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
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\exercise\chapter20_5\Ex05
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.exercise.chapter20_5.Ex05
 *   . _remove
 *   . initialization
 *   . _contains
 * OK (3 tests)
 */