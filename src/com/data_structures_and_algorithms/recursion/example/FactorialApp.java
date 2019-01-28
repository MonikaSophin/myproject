package com.data_structures_and_algorithms.recursion.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/25
 * @description: 阶乘
 */
public class FactorialApp {
    private static int theNumber;
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        int theAnswer = factorial(theNumber);
        System.out.println("Factorial = " + theAnswer);
    }

    private static int factorial(int n) {
        System.out.println("Entering n = " + n);
        if (n == 0) {
            System.out.println("Returning 1");
            return 1;
        }else {
            int temp = n * factorial(n -1 );
            System.out.println("Returning " + temp);
            return temp;
        }
    }

    private static int getInt() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        int i = Integer.parseInt(s);
        return i;
    }
}
/**output:
 * Enter a number: 6
 * Entering n = 6
 * Entering n = 5
 * Entering n = 4
 * Entering n = 3
 * Entering n = 2
 * Entering n = 1
 * Entering n = 0
 * Returning 1
 * Returning 1
 * Returning 2
 * Returning 6
 * Returning 24
 * Returning 120
 * Returning 720
 * Factorial = 720
 */