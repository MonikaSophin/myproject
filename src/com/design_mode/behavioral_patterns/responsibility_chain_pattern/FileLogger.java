package com.design_mode.behavioral_patterns.responsibility_chain_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
