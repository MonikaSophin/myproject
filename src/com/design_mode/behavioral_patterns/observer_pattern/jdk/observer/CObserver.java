package com.design_mode.behavioral_patterns.observer_pattern.jdk.observer;

import com.design_mode.behavioral_patterns.observer_pattern.jdk.subject.NewsOffice;
import com.design_mode.behavioral_patterns.observer_pattern.model.Display;
import com.design_mode.behavioral_patterns.observer_pattern.model.Message;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者A只希望得到报社更新发布的 作者与书名
 */
public class CObserver implements Observer, Display {

    private Message message;

    /**
     * 只需要{@link Observable#addObserver(Observer)}到Vector即可
     *  在调用{@link Observable#notifyObservers()}时
     * 会开始调用{@link #update(Observable, Object)}                                    00
     */
    public CObserver(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {//告知观察者 被观察者信息
        if (o instanceof NewsOffice){
            NewsOffice newspaper = (NewsOffice) o;
            this.message = newspaper.getMessage();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println(String.format("我是%s,从报社得到的消息是--作者是%s,书名为%s。",
                this.getClass().getSimpleName(),
                message.getAuthor(),
                message.getTitle()));
    }
}
