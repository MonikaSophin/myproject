package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_1;

/**
 * @Author: monika
 * @Date: 2018/12/28 22:35
 * @Version: 1.0
 * @Description:
 */
public class WithFinally {
    public static Switch sw = new Switch();
    public static void main(String[] args) {
        try {
            sw.on();
            OnOffSwitch.f();
        }catch (OnOffException1 e){
            System.out.println("OnOffException1");
        }catch (OnOffException2 e){
            System.out.println("OnOffException2");
        }finally {
            sw.off();
        }
    }
}
/**output:
 * on
 * off
 */