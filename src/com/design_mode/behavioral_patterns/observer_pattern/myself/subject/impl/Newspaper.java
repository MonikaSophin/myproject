package com.design_mode.behavioral_patterns.observer_pattern.myself.subject.impl;

import com.design_mode.behavioral_patterns.observer_pattern.model.Message;
import com.design_mode.behavioral_patterns.observer_pattern.myself.observer.Observer;
import com.design_mode.behavioral_patterns.observer_pattern.myself.subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者  报社
 */
public class Newspaper implements Subject {

    private List<Observer> observers;
    private Message message;

    public Newspaper(){
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);//简单的实现 并没有去判断是否重复定义 如果有需要在自行调整
    }

    @Override
    public void deleteObserver(Observer observer) {
        if (observers.size()>0){
            int i = observers.indexOf(observer);
            if (i>=0)
                observers.remove(i);
        }
    }

    /**
     * 这里采用了被观察者push数据给观察者的方式  通知了所有观察者所有的更新信息
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : observers){
            observer.update(message);
        }
    }

    public void statusChange(){
        notifyObserver();
    }

    /**
     *  注意 没有getter message的方法 所以只能通过push的方式给观察者
     */
    public void setMessage(Message message){
        this.message = message;
        statusChange();
    }


}
