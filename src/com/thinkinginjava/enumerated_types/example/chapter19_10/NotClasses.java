package com.thinkinginjava.enumerated_types.example.chapter19_10;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/16
 * @description:
 */
enum LikeClass {
    WINKEN {
        void behavior() { System.out.println("Behavior1"); }
    },
    BLINKEN {
        void behavior() { System.out.println("Behavior2"); }
    },
    NOD {
        void behavior() { System.out.println("Behavior3"); }
    };
    abstract void behavior();
}

public class NotClasses {
    public static void main(String[] args) {

    }
}
