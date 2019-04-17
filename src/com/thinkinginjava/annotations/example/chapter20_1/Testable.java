package com.thinkinginjava.annotations.example.chapter20_1;

import com.thinkinginjava.annotations.example.chapter20_1.ex20_1_1.Test;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/17
 * @description:
 */
public class Testable {
    public void execute() {
        System.out.println("Executing");
    }
    @Test
    void testExecute() {
        execute();
    }
}
