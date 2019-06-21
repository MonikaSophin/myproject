package com.design_mode.behavioral_patterns.observer_pattern.myself.observer.impl;

import com.design_mode.behavioral_patterns.observer_pattern.model.Display;
import com.design_mode.behavioral_patterns.observer_pattern.model.Message;
import com.design_mode.behavioral_patterns.observer_pattern.myself.observer.Observer;
import com.design_mode.behavioral_patterns.observer_pattern.myself.subject.Subject;

/**
 * 观察者B只希望得到报社更新发布的  书名与描述
 */
public class BObserver implements Observer, Display {

    private Subject newspaper;
    private Message message;

    public BObserver(Subject newspaper){
        this.newspaper = newspaper;
        newspaper.addObserver(this);
    }

    @Override
    public void update(Message message) {//得到所有报社发来的信息
        this.message = message;
        display();
    }

    @Override
    public void display() {
        System.out.println(String.format("我是%s,从报社得到的消息是--书名是%s,描述为%s。",
                this.getClass().getSimpleName(),
                message.getTitle(),
                message.getDesc()));
    }
}
