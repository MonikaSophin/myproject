package com.design_mode.behavioral_patterns.template_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤2.
 * 实现模板方法抽象类
 */
public class GameLol extends AbstractTemplate {

    @Override
    void initGameRole() {
        System.out.println("LOL Create game role!");
    }

    @Override
    void playingGame() {
        System.out.println("LOL playing!");
    }

    @Override
    void gameOver() {
        System.out.println("LOL game over!");
    }
}
