package com.design_mode.behavioral_patterns.command_pattern;

/**
 * @Author: monika
 * @Date: 2019/6/30 21:12
 * @Version: 1.0
 * @Description:
 * 步骤3.
 * 创建具体的Command对象实现Command接口，
 * 要传入具体的Execute类
 */
public class ConcreteCommandB implements Command {

    private Execute execute;

    public ConcreteCommandB(Execute execute) {
        this.execute = execute;
    }

    @Override
    public void execute() {
        //一些具体业务实现。。
        System.out.println("ConcreteCommandB execute()");
        execute.doSomething();
    }
}
