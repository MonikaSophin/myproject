package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_1;

/**
 * @Author: monika
 * @Date: 2018/12/28 22:31
 * @Version: 1.0
 * @Description:
 */
public class OnOffSwitch {
    public static Switch sw = new Switch();
    public static void f() throws OnOffException1, OnOffException2{}

    public static void main(String[] args) {
        try {
            sw.on();
            f();
            sw.off();
        }catch (OnOffException1 e){
            System.out.println("OnOffException1");
            sw.off();
        }catch (OnOffException2 e){
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}
/**output:
 * on
 * off
 */