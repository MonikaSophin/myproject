package com.thinkinginjava.inner_classes.example.chapter10_6;

import com.thinkinginjava.inner_classes.example.chapter10_4.Destination;

/**
 * @Author: monika
 * @Date: 2018/12/6 21:39
 * @Version: 1.0
 * @Description: 如果定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，
 *              那么编译器会要求其参数引用是final的。如果你忘记了，将会得到一
 *              个编译时错误消息。
 */
public class Parcel9 {
    public Destination destination(final String dest){
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() { return label; }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
        System.out.println( d.readLabel() );
    }
}
/**输出：
 * Tasmania
 */