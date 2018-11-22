package com.thinkinginjava.polymorphism.exercise.chapter8_5;

/**
 * @Author: monika
 * @Date: 2018/11/22 22:01
 * @Version: 1.0
 * @Description: page 165
 * 练习16：遵循Transmogrify.java这个例子，创建一个Starship类，包含AlertStatus引用，
 * 此引用可以指示三种不同的状态。纳入一些可以改变这些状态的方法。
 */
class Starship{
    private AlertStatus alertStatus;
    public Starship() {
        this.alertStatus = new AlertStatus();
    }
    public void changeOpen(){
        this.alertStatus = new OpenStatus();
    }
    public void changeClose(){
        this.alertStatus = new CloseStatus();
    }
    public void statusCheck() {
        System.out.println(alertStatus.status());
    }
}

class AlertStatus{
    public String status() { return "AlertStatus"; }
}

class OpenStatus extends AlertStatus{
    @Override
    public String status() { return "OpenStatus"; }
}

class CloseStatus extends AlertStatus{
    @Override
    public String status() { return "CloseStatus"; }
}

public class Ex16 {
    public static void main(String[] args) {
        Starship starship = new Starship();
        starship.statusCheck();

        starship.changeOpen();
        starship.statusCheck();

        starship.changeClose();
        starship.statusCheck();
    }
}
/**输出：
 * AlertStatus
 * OpenStatus
 * CloseStatus
 */