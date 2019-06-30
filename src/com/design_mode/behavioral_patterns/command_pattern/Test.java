package com.design_mode.behavioral_patterns.command_pattern;

/**
 * @Author: monika
 * @Date: 2019/6/30 21:24
 * @Version: 1.0
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Execute executeA = new ConcreteExecuteA();
        Command commandA = new ConcreteCommandA(executeA);
        Command commandB = new ConcreteCommandB(executeA);

        Invoker invoker = new Invoker();
        //执行命令A
        invoker.setCommand(commandA);
        invoker.action();
        System.out.println();

        //执行命令B
        invoker.setCommand(commandB);
        invoker.action();
    }
}
/**output:
 * ConcreteCommandA execute()
 * ConcreteExecuteA doSomething()
 *
 * ConcreteCommandB execute()
 * ConcreteExecuteA doSomething()
 */