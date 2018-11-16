package com.thinkinginjava.reusing_classes.example.chapter7_2.ex7_2_1;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:40
 * @Version: 1.0
 * @Description:  如果没有默认的基类构造器，或者想调用一个带参数的基类构造器，就必须
 *               使用super显式地编写调用基类构造器的语句，并配以适当的参数列表。
 */
class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }
    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
/**输出：
 * Game constructor
 * BoardGame constructor
 * Chess constructor
 */