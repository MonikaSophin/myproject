package com.design_mode.behavioral_patterns.mediator_pattern;

import java.util.Date;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 * 步骤1.
 * 创建中介者类--聊天室
 */
public class ChatRoom {

    public static void showMessage(User user, String message) {
        System.out.println(String.format(
                "%s [%s] : %s", new Date(), user.getName(), message));
    }
}
