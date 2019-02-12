package com.thinkinginjava.generics.exercise.chapter15_5;

import com.thinkinginjava.generics.example.chapter15_3.coffee.Generator;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_3.Generators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/11
 * @description: page 370
 * 练习18：遵循BankTeller.java的形式，创建一个Occan中BigFish吃LittleFish的例子。
 */
class LittleFish {
    private static long counter = 1;
    private final long id = counter++;
    private LittleFish() {}
    @Override
    public String toString() { return "LittleFish " + id; }
    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            @Override
            public LittleFish next() { return new LittleFish(); }
        };
    }
}

class BigFish {
    private static long counter = 1;
    private final long id = counter++;
    private BigFish() {}
    @Override
    public String toString() { return "BigFish " + id; }
    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() { return new BigFish(); }
        };
    }
}

public class Ex18 {
    public static void serve(BigFish bigFish, LittleFish littleFish) {
        System.out.println(String.format("%s eat %s", bigFish, littleFish));
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<LittleFish> line = new LinkedList<>();
        Generators.fill(line, LittleFish.generator(), 15);// 填充消费者队列

        List<BigFish> bigFishs = new ArrayList<>();
        Generators.fill(bigFishs, BigFish.generator(), 4);
        for (LittleFish littleFish : line)
            serve(bigFishs.get(rand.nextInt(bigFishs.size())), littleFish);
    }
}
/**output:
 * BigFish 3 eat LittleFish 1
 * BigFish 2 eat LittleFish 2
 * BigFish 3 eat LittleFish 3
 * BigFish 1 eat LittleFish 4
 * BigFish 1 eat LittleFish 5
 * BigFish 3 eat LittleFish 6
 * BigFish 1 eat LittleFish 7
 * BigFish 2 eat LittleFish 8
 * BigFish 3 eat LittleFish 9
 * BigFish 3 eat LittleFish 10
 * BigFish 2 eat LittleFish 11
 * BigFish 4 eat LittleFish 12
 * BigFish 2 eat LittleFish 13
 * BigFish 1 eat LittleFish 14
 * BigFish 1 eat LittleFish 15
 */