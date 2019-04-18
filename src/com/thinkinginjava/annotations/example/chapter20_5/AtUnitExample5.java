package com.thinkinginjava.annotations.example.chapter20_5;

import com.thinkinginjava.util.atunit.Test;
import com.thinkinginjava.util.atunit.TestObjectCleanup;
import com.thinkinginjava.util.atunit.TestObjectCreate;
import com.thinkinginjava.util.atunit.TestProperty;

import java.io.PrintWriter;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class AtUnitExample5 {
    private String text;
    public AtUnitExample5(String text) { this.text = text; }
    @Override
    public String toString() { return text; }

    @TestProperty static PrintWriter output;
    @TestProperty static int counter;
    @TestObjectCreate static AtUnitExample5 create() {
        String id = Integer.toString(counter++);
        try {
            output = new PrintWriter("Test" + id + ".txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new AtUnitExample5(id);
    }
    @TestObjectCleanup static void cleanup(AtUnitExample5 obj) {
        System.out.println("Running cleanup");
        output.close();
    }

    @Test boolean test1() {
        output.print("test1");
        return true;
    }
    @Test boolean test2() {
        output.print("test2");
        return true;
    }
    @Test boolean test3() {
        output.print("test3");
        return true;
    }

    public static void main(String[] args) {
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\example\chapter20_5\AtUnitExample5
         */
    }
}
/**output:
 * com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample5
 *   . test3
 * Running cleanup
 *   . test2
 * Running cleanup
 *   . test1
 * Running cleanup
 * OK (3 tests)
 */