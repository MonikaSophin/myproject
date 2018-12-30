package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_1;

/**
 * @Author: monika
 * @Date: 2018/12/28 22:27
 * @Version: 1.0
 * @Description:
 */
public class Switch {
    private boolean state = false;
    public boolean read() { return state; }
    public void on() {
        state = true;
        System.out.println(this);
    }
    public void off() {
        state = false;
        System.out.println(this);
    }
    @Override
    public String toString() { return state ? "on" : "off"; }
}
