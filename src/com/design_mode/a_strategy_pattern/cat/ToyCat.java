package com.design_mode.a_strategy_pattern.cat;

import com.design_mode.a_strategy_pattern.call.NoCall;
import com.design_mode.a_strategy_pattern.run.NoRun;

/**
 * 玩具猫  是一个猫
 */
public class ToyCat extends Cat{
    public ToyCat(){
        callable = new NoCall();
        runable = new NoRun();
    }
    @Override
    public void display(){
        System.out.println("我是一只玩具猫。");
    }
}
