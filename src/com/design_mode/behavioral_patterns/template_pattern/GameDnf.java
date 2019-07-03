package com.design_mode.behavioral_patterns.template_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤2.
 * 实现模板方法抽象类
 */
public class GameDnf extends AbstractTemplate {

    @Override
    void initGameRole() {
        System.out.println("DNF Create game role!");
    }

    @Override
    void playingGame() {
        System.out.println("DNF playing!");
    }

    @Override
    void gameOver() {
        System.out.println("DNF game over!");
    }
}
