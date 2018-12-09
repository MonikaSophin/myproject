package com.thinkinginjava.inner_classes.example.chapter10_6.ex10_6_1;

/**
 * @Author: monika
 * @Date: 2018/12/7 22:51
 * @Version: 1.0
 * @Description:  对interface/Games.java用匿名内部类进行重构
 */
interface Game{ boolean move(); }
interface GameFactory{ Game getGame(); }

class Checkers implements Game{
    private Checkers(){}
    private int moves = 0;
    private static final int MOVES = 3;
    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }
    public static GameFactory factory =
            () -> new Checkers();
}

class Chess implements Game{
    private Chess(){}
    private int moves = 0;
    private static final int MOVES = 4;
    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
    public static GameFactory factory =
            () -> new Chess();
}

public class Games {
    public static void playGame(GameFactory factory) {
        Game game = factory.getGame();
        while (game.move()){ }
    }

    public static void main(String[] args) {
        playGame(Checkers.factory);
        playGame(Chess.factory);

    }
}
/**输出：
 * Checkers move 0
 * Checkers move 1
 * Checkers move 2
 * Chess move 0
 * Chess move 1
 * Chess move 2
 * Chess move 3
 */