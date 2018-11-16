package com.thinkinginjava.reusing_classes.exercise.chapter7_2;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:50
 * @Version: 1.0
 * @Description: page 130
 * 练习06：用Chess.java来证明前一段话。
 */
class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}
class BoardGame extends Game {
    BoardGame(int i) {
        // print("BoardGame constructor"); // call to super must be first
        // statement in constructor
        super(i); // else: "cannot find symbol: constructor Game()
        System.out.println("BoardGame constructor");
    }
}
class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }
}

public class Ex06 {
    public static void main(String[] args) {
        new Chess();
    }
}
/**输出：
 * Game constructor
 * BoardGame constructor
 * Chess constructor
 */