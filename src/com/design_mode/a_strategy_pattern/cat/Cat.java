package com.design_mode.a_strategy_pattern.cat;

import com.design_mode.a_strategy_pattern.call.ICall;
import com.design_mode.a_strategy_pattern.run.IRun;

/**
 * 超类 猫
 */
public abstract class Cat {
    //定义算法族变量
    ICall callable;//有一个叫的行为
    IRun runable;//有一个跑的行为

    public void setCallable(ICall callable) {
        this.callable = callable;
    }

    public void setRunable(IRun runable) {
        this.runable = runable;
    }

    public abstract void display();
    public void preformCall(){ callable.call(); }
    public void preformRun(){ runable.run(); }
}
