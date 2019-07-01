package com.design_mode.behavioral_patterns.mediator_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 * 步骤2.
 * 创建用户类，
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
