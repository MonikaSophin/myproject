package com.thinkinginjava.string.example.chapter13_7;

import java.util.Scanner;

/**
 * @Author: monika
 * @Date: 2019/1/13 19:34
 * @Version: 1.0
 * @Description:
 */
public class BetterRead {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(SimpleRead.input);
        System.out.println("What is your name?");
        String name = stdin.nextLine();
        System.out.println(name);

        System.out.println("How old are you? What is your favorite double?");
        System.out.println("(input: <age> <double>)");
        int age = stdin.nextInt();
        double favorite = stdin.nextDouble();
        System.out.println(String.format("%d %f", age, favorite));

        System.out.format("Hi %s. \n", name);
        System.out.println(String.format("In 5 years you will be %d.", age + 5));
        System.out.println(String.format("My favorite double is %f.", favorite/2));
    }
}
/**output:
 * What is your name?
 * Sir Robin of camelot
 * How old are you? What is your favorite double?
 * (input: <age> <double>)
 * 22 1.618030
 * Hi Sir Robin of camelot.
 * In 5 years you will be 27.
 * My favorite double is 0.809015.
 */