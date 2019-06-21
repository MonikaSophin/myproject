package com.design_mode.behavioral_patterns.strategy_pattern.call;

/**
 * 是一个‘猫叫声’的算法族
 */
public class MewsCall implements ICall {
    @Override
    public void call(){
        System.out.println("喵喵叫--");
    }
}
