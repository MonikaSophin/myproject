package com.design_mode.behavioral_patterns.strategy_pattern.cat;

import com.design_mode.behavioral_patterns.strategy_pattern.call.MewsCall;
import com.design_mode.behavioral_patterns.strategy_pattern.run.FastRun;

/**
 * 波斯猫  是一个猫
 */
public class PersianCat extends Cat{
    public PersianCat(){
        callable = new MewsCall();
        runable = new FastRun();
    }
    @Override
    public void display(){
        System.out.println("我是一只波斯猫。");
    }
}
