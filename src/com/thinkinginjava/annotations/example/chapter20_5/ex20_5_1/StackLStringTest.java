package com.thinkinginjava.annotations.example.chapter20_5.ex20_5_1;

import com.thinkinginjava.util.atunit.Test;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class StackLStringTest extends StackL<String> {
    @Test void _push() {
        push("one");
        assert top().equals("one");
        push("two");
        assert top().equals("two");
    }
    @Test void _pop() {
        push("one");
        push("two");
        assert pop().equals("two");
        assert pop().equals("one");
    }
    @Test void _top() {
        push("A");
        push("B");
        assert top().equals("B");
        assert top().equals("B");
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\example\chapter20_5\ex20_5_1\StackLStringTest
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.example.chapter20_5.ex20_5_1.StackLStringTest
 *   . _top
 *   . _push
 *   . _pop
 * OK (3 tests)
 */