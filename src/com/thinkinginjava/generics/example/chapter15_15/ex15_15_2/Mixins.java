package com.thinkinginjava.generics.example.chapter15_15.ex15_15_2;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin();
        Mixin mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerilaNumber());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerilaNumber());
    }
}
/**output(80% match):
 * test string 1 1550457635518 1
 * test string 2 1550457635518 2
 */