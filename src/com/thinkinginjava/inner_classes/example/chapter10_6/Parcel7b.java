package com.thinkinginjava.inner_classes.example.chapter10_6;

import com.thinkinginjava.inner_classes.example.chapter10_4.Contents;

/**
 * @Author: monika
 * @Date: 2018/12/6 21:24
 * @Version: 1.0
 * @Description: Parcel7b的简化形式（没使用匿名内部类）。
 */
public class Parcel7b {
    class MyContents implements Contents{
        private int i = 11;
        @Override
        public int value() { return i; }
    }
    public Contents contents(){ return new MyContents(); }
    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents contents = p.contents();
    }
}
