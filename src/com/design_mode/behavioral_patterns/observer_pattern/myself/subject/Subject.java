package com.design_mode.behavioral_patterns.observer_pattern.myself.subject;


import com.design_mode.behavioral_patterns.observer_pattern.myself.observer.Observer;

/**
 * 主题（被观察者）接口 ：
 *    添加、删除、通知观察者  状态变化的设置（可能需要）
 */
public interface Subject {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObserver();
}
