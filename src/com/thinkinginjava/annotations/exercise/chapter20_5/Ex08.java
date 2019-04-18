package com.thinkinginjava.annotations.exercise.chapter20_5;

import com.thinkinginjava.util.atunit.Test;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description: page 642
 * 继承使我们失去了访问被测试的类中的private方法的能力。
 * --1.要么 将private方法改为protected
 * --2.要么 添加一个非private的@TestProperty方法，由它来调用private方法。
 *
 * 练习08：写一个带有private方法的类，然后像上面介绍的那样添加一个非private @TestProperty方法，
 * 并在你的测试代码中调用此方法。
 */
public class Ex08 extends Test08<String> {
    @Test void _add() {
        add("A");
        assert remove(0).equals("A");
        add("B");
        assert  remove(0).equals("B");
    }
    @Test void _get() {
        add("A");
        assert get(0).equals("A");
        add("B");
        assert  get(1).equals("B");
    }
    @Test void _remove() {
        add("A");
        add("B");
        assert remove(0).equals("A");
        //assert remove(0).equals("B");
        assert remove(1).equals("B");
    }

    @Test void _isEmpty() {
        add("A");
        add("B");
        remove(0);
        remove(0);
        assert testIsEmpty();
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\exercise\chapter20_5\Ex08
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.exercise.chapter20_5.Ex08
 *   . _get
 *   . _isEmpty
 *   . _add
 *   . _remove java.lang.IndexOutOfBoundsException: Index: 1, Size: 1
 * (failed)
 * (4 tests)
 *
 * >>> 1 FAILURE <<<
 *   com.thinkinginjava.annotations.exercise.chapter20_5.Ex08: _remove
 */