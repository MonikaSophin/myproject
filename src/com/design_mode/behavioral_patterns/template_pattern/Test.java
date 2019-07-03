package com.design_mode.behavioral_patterns.template_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        AbstractTemplate game1 = new GameLol();
        game1.play();
        System.out.println();

        AbstractTemplate game2 = new GameDnf();
        game2.play();
    }
}
