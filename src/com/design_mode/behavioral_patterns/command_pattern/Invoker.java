package com.design_mode.behavioral_patterns.command_pattern;

/**
 * @Author: monika
 * @Date: 2019/6/30 21:22
 * @Version: 1.0
 * @Description:
 * 步骤5.
 * 命令的调用者.让命令者去执行命令即可。不需要知道具体执行命令者是谁。
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        if (command == null) {
            System.out.println("请传入具体的Command对象！");
        }
        command.execute();
    }
}
