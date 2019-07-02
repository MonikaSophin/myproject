package com.design_mode.behavioral_patterns.state_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/2
 * @description:
 * 步骤2.
 * 创建一个Context类，其中包含State状态
 */
public class Context {
    private State state;

    public Context() {
        this.state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
