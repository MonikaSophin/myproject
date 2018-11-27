package com.thinkinginjava.interfaces.exercise.chapter9_9;

import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/11/27 21:57
 * @Version: 1.0
 * @Description: page 188
 * 练习19：使用工厂方法来创建一个框架，它可以执行抛硬币和掷骰子功能。
 */
interface Games {
    void play();
}

interface GamesFactory {
    Games getGames();
}

//抛硬币
class CoinToss implements Games {
    Random rand = new Random();
    public void play() {
        System.out.print("Toss Coin: ");
        switch(rand.nextInt(2)) {
            case 0 : System.out.println("Heads"); return;
            case 1 : System.out.println("Tails"); return;
            default: System.out.println("OnEdge"); return;
        }
    }
}

class CoinTossFactory implements GamesFactory {
    public Games getGames() {
        return new CoinToss();
    }
}

//掷骰子
class DiceThrow implements Games {
    Random rand = new Random();
    public void play() {
        System.out.println("Throw Dice: " + (rand.nextInt(6) + 1));
    }
}

class DiceThrowFactory implements GamesFactory {
    public Games getGames() {
        return new DiceThrow();
    }
}

public class Ex19 {
    public static void playGame(GamesFactory factory) {
        Games g = factory.getGames();
        g.play();
    }
    public static void main(String [] args) {
        playGame(new CoinTossFactory());
        playGame(new DiceThrowFactory());
    }
}
/**输出:
 * 略~
 */