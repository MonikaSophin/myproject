package com.thinkinginjava.enumerated_types.example.chapter19_11;

import java.util.Random;

import static com.thinkinginjava.enumerated_types.example.chapter19_11.OutCome.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/16
 * @description:
 */

interface Item {
    OutCome compete(Item it);
    OutCome eval(Paper it);
    OutCome eval(Scissors it);
    OutCome eval(Rock it);
}

class Paper implements Item { // 布
    @Override
    public OutCome compete(Item it) { return it.eval(this); }
    @Override
    public OutCome eval(Paper it) { return DRAW; }
    @Override
    public OutCome eval(Scissors it) { return WIN; }
    @Override
    public OutCome eval(Rock it) { return LOSE; }
    @Override
    public String toString() { return "Paper"; }
}

class Scissors implements Item { //剪刀
    @Override
    public OutCome compete(Item it) { return it.eval(this); }
    @Override
    public OutCome eval(Paper it) { return LOSE; }
    @Override
    public OutCome eval(Scissors it) { return DRAW; }
    @Override
    public OutCome eval(Rock it) { return WIN; }
    @Override
    public String toString() { return "Scissors"; }
}

class Rock implements Item { //石头
    @Override
    public OutCome compete(Item it) { return it.eval(this); }
    @Override
    public OutCome eval(Paper it) { return WIN; }
    @Override
    public OutCome eval(Scissors it) { return LOSE; }
    @Override
    public OutCome eval(Rock it) { return DRAW; }
    @Override
    public String toString() { return "Rock"; }
}

public class RoshamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);
    public static Item newItem() {
        switch (rand.nextInt(3)) {
            default:
            case 0: return new Scissors();
            case 1: return new Paper();
            case 2: return new Rock();
        }
    }
    public static void match(Item a, Item b) {
        System.out.println(String.format("%s vs. %s : %s", a, b , a.compete(b)));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++)
            match(newItem(), newItem());
    }
}
/**output:
 * Rock vs. Rock : DRAW
 * Paper vs. Rock : WIN
 * Paper vs. Rock : WIN
 * Paper vs. Rock : WIN
 * Scissors vs. Paper : WIN
 * Scissors vs. Scissors : DRAW
 * Scissors vs. Paper : WIN
 * Rock vs. Paper : LOSE
 * Paper vs. Paper : DRAW
 * Rock vs. Paper : LOSE
 * Paper vs. Scissors : LOSE
 * Paper vs. Scissors : LOSE
 * Rock vs. Scissors : WIN
 * Rock vs. Paper : LOSE
 * Paper vs. Rock : WIN
 * Scissors vs. Paper : WIN
 * Paper vs. Scissors : LOSE
 * Paper vs. Scissors : LOSE
 * Paper vs. Scissors : LOSE
 * Paper vs. Scissors : LOSE
 */