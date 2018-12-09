package com.thinkinginjava.inner_classes.example.chapter10_6;

/**
 * @Author: monika
 * @Date: 2018/12/6 21:28
 * @Version: 1.0
 * @Description: 一个有参构造器的内部类例子
 */
public class Parcel8 {
    public Wrapping wrapping(int x){
        return new Wrapping(x){
            @Override
            public int value(){return super.value() * 47;}
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping wrapping = p.wrapping(10);
        System.out.println(wrapping.value());
    }
}
/**输出；
 * 470
 */