package com.design_mode.behavioral_patterns.mediator_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        User user1 = new User("Alex");
        User user2 = new User("Bob");

        user1.sendMessage("Hi! " + user2.getName());
        user2.sendMessage("Hi! " + user1.getName());
    }
}
/**output:
 * Mon Jul 01 11:18:46 CST 2019 [Alex] : Hi! Bob
 * Mon Jul 01 11:18:46 CST 2019 [Bob] : Hi! Alex
 */