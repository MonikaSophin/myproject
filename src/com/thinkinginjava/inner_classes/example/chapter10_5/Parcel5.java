package com.thinkinginjava.inner_classes.example.chapter10_5;

import com.thinkinginjava.inner_classes.example.chapter10_4.Destination;

/**
 * @Author: monika
 * @Date: 2018/12/5 17:24
 * @Version: 1.0
 * @Description: 该示例展示了在方法的作用域内（而不是在其他类的作用域内）创建一个完整的类。
 *              这被称作为 局部内部类。
 */
public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;
            private PDestination(String whereTo){
                label = whereTo;
            }
            public String readLabel(){return label;}
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmanis");
    }
}
