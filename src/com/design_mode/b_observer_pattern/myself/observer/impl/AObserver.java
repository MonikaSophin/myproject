package com.design_mode.b_observer_pattern.myself.observer.impl;

import com.design_mode.b_observer_pattern.model.Display;
import com.design_mode.b_observer_pattern.model.Message;
import com.design_mode.b_observer_pattern.myself.observer.Observer;
import com.design_mode.b_observer_pattern.myself.subject.Subject;

/**
 * 观察者A只希望得到报社更新发布的 作者与书名
 */
public class AObserver implements Observer, Display {

    private Subject newspaper;
    private Message message;

    public AObserver(Subject newspaper){
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
        System.out.println(String.format("我是%s,从报社得到的消息是--作者是%s,书名为%s。",
                this.getClass().getSimpleName(),
                message.getAuthor(),
                message.getTitle()));
    }
}
