package com.design_mode.behavioral_patterns.template_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤1.
 * 创建一个模板方法的抽象类容器
 */
public abstract class AbstractTemplate {

    /**
     * 初始化游戏角色
     */
    abstract void initGameRole();

    /**
     * 正在玩游戏
     */
    abstract void playingGame();

    /**
     * 结束游戏
     */
    abstract void gameOver();


    public void play() {
        initGameRole();
        playingGame();
        gameOver();
    }
}
