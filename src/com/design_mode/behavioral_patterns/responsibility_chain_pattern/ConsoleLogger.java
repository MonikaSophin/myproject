package com.design_mode.behavioral_patterns.responsibility_chain_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 步骤2.
 * 创建实现该抽象日志类的实体类
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
