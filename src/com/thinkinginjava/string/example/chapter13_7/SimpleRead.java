package com.thinkinginjava.string.example.chapter13_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @Author: monika
 * @Date: 2019/1/13 19:25
 * @Version: 1.0
 * @Description:
 */
public class SimpleRead {
    public static BufferedReader input = new BufferedReader(
            new StringReader("Sir Robin of camelot\n22 1.61803"));

    public static void main(String[] args) {
        try{
            System.out.println("What is your name?");
            String name = input.readLine();
            System.out.println(name);

            System.out.println("How old are you? What is your favorite double?");
            System.out.println("(input: <age> <double>)");
            String numbers = input.readLine();
            System.out.println(numbers);

            String[] numArray = numbers.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.format("Hi %s. \n", name);
            System.out.println(String.format("In 5 years you will be %d.", age + 5));
            System.out.println(String.format("My favorite double is %f.", favorite/2));
        }catch (IOException e){
            System.err.println("I/O exception");
        }
    }
}
/**output:
 * What is your name?
 * Sir Robin of camelot
 * How old are you? What is your favorite double?
 * (input: <age> <double>)
 * 22 1.61803
 * Hi Sir Robin of camelot.
 * In 5 years you will be 27.
 * My favorite double is 0.809015.
 */