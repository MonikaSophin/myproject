package com.data_structures_and_algorithms.recursion.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/24
 * @description: 清单6.1 三角数字
 */
public class TriangleApp {
    static int theNumber;
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        int theAnswer = triangle(theNumber);
        System.out.println("Triangle = " + theAnswer);
    }

//    private static int triangle(int n) {
//        if (n == 1)
//            return 1;
//        else
//            return n + triangle(n - 1);
//    }

    private static int triangle(int n) {
        System.out.println("Entering n = " + n);
        if (n == 1) {
            System.out.println("Returning 1");
            return 1;
        }else {
            int temp = n + triangle(n - 1);
            System.out.println("Returning " + temp);
            return temp;
        }
    }
    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    private static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
/**output:
 * Enter a number: 5
 * Entering n = 5
 * Entering n = 4
 * Entering n = 3
 * Entering n = 2
 * Entering n = 1
 * Returning 1
 * Returning 3
 * Returning 6
 * Returning 10
 * Returning 15
 * Triangle = 15
 */