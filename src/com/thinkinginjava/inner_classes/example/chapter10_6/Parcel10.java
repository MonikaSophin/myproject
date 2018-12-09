package com.thinkinginjava.inner_classes.example.chapter10_6;

import com.thinkinginjava.inner_classes.example.chapter10_4.Destination;

/**
 * @Author: monika
 * @Date: 2018/12/6 21:54
 * @Version: 1.0
 * @Description:
 */
public class Parcel10 {
    public Destination destination(final String dest, final float price){
        return new Destination() {
            private int cost;
            {
                cost = Math.round(price);//101
                if (cost > 100)
                    System.out.println("Over budget!");
            }
            private String label = dest;
            @Override
            public String readLabel() { return label; }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);
    }
}
/**输出：
 * Over budget!
 */
