package com.thinkinginjava.annotations.exercise.chapter20_5;

import com.thinkinginjava.util.atunit.Test;

import java.util.HashMap;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description: page 642
 * 练习09：为HashMap编写一些基本的@Unit测试。
 */
public class Ex09 extends HashMap<Integer,String> {
    @Test void _put() {
        put(1, "Hi");
        assert get(1).equals("Hi");
    }
    @Test void _containsKey() {
        put(2, "Bye");
        assert containsKey(2);
    }
    @Test void _containsValue() {
        put(3, "yes");
        assert containsValue("yes");
    }
    @Test void _get() {
        put(4, "hello");
        assert get(4).equals("hello");
    }
    @Test void _size() {
        assert size() == 0;
    }
    @Test void _clear() {
        put(5, "so long");
        clear();
        assert size() == 0;
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\exercise\chapter20_5\Ex09
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.exercise.chapter20_5.Ex09
 *   . _get
 *   . _put
 *   . _size
 *   . _containsKey
 *   . _clear
 *   . _containsValue
 * OK (6 tests)
 */