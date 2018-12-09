package com.thinkinginjava.inner_classes.exercise.chapter10_6;

import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/12/7 23:06
 * @Version: 1.0
 * @Description: page 201
 * 练习17：修改第9章中练习19的解决方案，让它使用匿名内部类。
 */
interface Games { void play();}

interface GamesFactory { Games getGames();}

//抛硬币
class CoinToss implements Games {
    private CoinToss(){}
    private Random rand = new Random();
    public void play() {
        System.out.print("Toss Coin: ");
        switch(rand.nextInt(2)) {
            case 0 : System.out.println("Heads--"); return;
            case 1 : System.out.println("Tails--"); return;
            default: System.out.println("OnEdge--"); return;
        }
    }
    public static GamesFactory factory =
            () -> new CoinToss();
}

//掷骰子
class DiceThrow implements Games {
    private DiceThrow(){}
    private Random rand = new Random();
    public void play() {
        System.out.println("Throw Dice: " + (rand.nextInt(6) + 1));
    }
    public static GamesFactory factory =
            () -> new DiceThrow();
}

public class Ex17 {
    private static void gamesFactoryConsumer(GamesFactory factory){
        Games games = factory.getGames();
        games.play();
    }

    public static void main(String[] args) {
        gamesFactoryConsumer(CoinToss.factory);
        gamesFactoryConsumer(DiceThrow.factory);
    }
}
/**输出（随机）：
 * Toss Coin: Tails--
 * Throw Dice: 6
 */