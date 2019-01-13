package com.thinkinginjava.string.example.chapter13_5.ex13_5_3;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @Author: monika
 * @Date: 2019/1/1 13:47
 * @Version: 1.0
 * @Description:
 */
public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }
    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
        Turtle terry = new Turtle("terry", new Formatter(outAlias));
        tommy.move(0,0);
        terry.move(4,8);
        tommy.move(3,4);
        terry.move(2,5);
        tommy.move(3,3);
        terry.move(3,3);
    }
}
/**output:
 * Tommy The Turtle is at (0,0)
 * terry The Turtle is at (4,8)
 * Tommy The Turtle is at (3,4)
 * terry The Turtle is at (2,5)
 * Tommy The Turtle is at (3,3)
 * terry The Turtle is at (3,3)
 */