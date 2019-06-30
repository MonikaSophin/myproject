package com.design_mode.behavioral_patterns.command_pattern;

/**
 * @Author: monika
 * @Date: 2019/6/30 21:20
 * @Version: 1.0
 * @Description:
 * 步骤4.
 * 真正的执行命令的具体实现类。
 */
public class ConcreteExecuteB implements Execute {

    @Override
    public void doSomething() {
        System.out.println("ConcreteExecuteB doSomething()");
    }
}
