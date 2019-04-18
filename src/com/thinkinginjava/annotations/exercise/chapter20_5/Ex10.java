package com.thinkinginjava.annotations.exercise.chapter20_5;

import com.thinkinginjava.util.atunit.Test;
import com.thinkinginjava.util.atunit.TestObjectCreate;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description: page 642
 * 练习10：从本书中选择一个示例程序，为其编写@Unit测试。
 */
public class Ex10 {
    private String ident;
    public Ex10(String id) { ident = id; }
    public String toString() { return ident; }
    public int hashCode() { return ident.hashCode(); }
    public boolean equals(Object r) {
        return r instanceof Ex10 &&
                ident.equals(((Ex10)r).ident);
    }
    protected void finalize() {
        System.out.println("Finalizing " +
                getClass().getSimpleName() + " " + ident);
    }
    @TestObjectCreate
    static Ex10 create() {
        return new Ex10("hi");
    }
    @Test void _hashCode() {
        String s = "hi";
        assert hashCode() == s.hashCode();
    }
    @Test void _equals() {
        Ex10 e = new Ex10("hi");
        assert this.equals(e);
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\exercise\chapter20_5\Ex10
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.exercise.chapter20_5.Ex10
 *   . _equals
 *   . _hashCode
 * OK (2 tests)
 */