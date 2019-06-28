package com.design_mode.behavioral_patterns.responsibility_chain_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 步骤2.
 * 
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
