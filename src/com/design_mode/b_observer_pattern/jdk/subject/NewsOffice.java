package com.design_mode.b_observer_pattern.jdk.subject;

import com.design_mode.b_observer_pattern.model.Message;

import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者对象继承了由jdk封装的Observable对象
 */
public class NewsOffice extends Observable {

    private Message message;


    public void statusChange(){
        this.setChanged();//为true
        /**
         * 这里并没有传输Message对象 而是由{@link #notifyObservers}
         *  去调用{@link Observer#update}
         *  从而将本类的Message对象传输给观察者
         */
        notifyObservers();//
    }

    public void setMessage(Message message){
        this.message = message;
        statusChange();
    }

    /**
     *   注意 ：观察者可以通过pull的方式获取数据
     */
    public Message getMessage() {
        return message;
    }
}
