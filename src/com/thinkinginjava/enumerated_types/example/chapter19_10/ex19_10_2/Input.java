package com.thinkinginjava.enumerated_types.example.chapter19_10.ex19_10_2;

import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/16
 * @description:
 */
public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP { //STOP 必须为最后一个enum实例
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    int value;
    Input(int value) {this.value = value; }
    Input() {}
    int amount() { return value; }
    static Random random = new Random(47);
    public static Input randomSelection() {
        //不能包含 STOP
        return values()[random.nextInt(values().length - 1)];
    }
}
