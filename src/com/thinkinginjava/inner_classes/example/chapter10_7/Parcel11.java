package com.thinkinginjava.inner_classes.example.chapter10_7;

import com.thinkinginjava.inner_classes.example.chapter10_4.Contents;
import com.thinkinginjava.inner_classes.example.chapter10_4.Destination;

/**
 * @Author: monika
 * @Date: 2018/12/8 11:08
 * @Version: 1.0
 * @Description:
 */
public class Parcel11 {
    private static class ParcelContents implements Contents{
        private int i = 1;
        @Override
        public int value(){ return i; }
    }

    protected static class ParcelDestination implements Destination{
        private String label;
        private ParcelDestination(String whereTo){ label = whereTo; }
        @Override
        public String readLabel() { return label; }
        public static void f(){}
        static int x = 10;
        static class AnotherLevel{
            public static void f(){}
            static int x = 10;
        }
    }

    public static Destination destination(String s){
        return new ParcelDestination(s);
    }

    public static Contents contents(){
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }
}
