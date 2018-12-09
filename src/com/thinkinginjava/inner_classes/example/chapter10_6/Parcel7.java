package com.thinkinginjava.inner_classes.example.chapter10_6;

import com.thinkinginjava.inner_classes.example.chapter10_4.Contents;

/**
 * @Author: monika
 * @Date: 2018/12/6 21:15
 * @Version: 1.0
 * @Description: 简单的匿名内部类的例子（采用了默认的构造器来生成匿名内部类）。
 */
public class Parcel7 {
    public Contents contents(){
        return new Contents() {
            private int i = 11;
            @Override
            public int value() { return i; }
        }; //在这种情况下需要分号
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents contents = p.contents();
    }
}
