package com.data_structures_and_algorithms.recursion.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/25
 * @description: 清单 6.2 变位字
 */
public class AnagramApp {
    private static int size;
    private static int count;
    private static char[] arrChar = new char[100];

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a word: ");
        String input = getString();
        size = input.length();
        count = 0;
        for (int j = 0; j < size; j++)
            arrChar[j] = input.charAt(j);
        doAnagram(size);
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    private static void doAnagram(int newSize) {
        if (newSize == 1)
            return;
        for (int j = 0; j < newSize; j++) {
            doAnagram(newSize - 1);
            if (newSize == 2)
                displayWord();
            rotate(newSize);
        }
    }

    private static void rotate(int newSize) {
        int j;
        int position = size - newSize;
        char temp = arrChar[position];
        for (j = position + 1; j < size; j++)
            arrChar[j - 1] = arrChar[j];
        arrChar[j - 1] = temp;
    }

    private static void displayWord() {
        if (count < 99)
            System.out.print(" ");
        if (count < 9)
            System.out.print(" ");
        System.out.print(++count + " ");
        for (int j = 0; j < size; j++)
            System.out.print(arrChar[j]);
        System.out.print("    ");
        System.out.flush();
        if (count % 6 == 0)
            System.out.println();
    }
}
/**output:
 * Enter a word: cats
 *   1 cats      2 cast      3 ctsa      4 ctas      5 csat      6 csta
 *   7 atsc      8 atcs      9 asct     10 astc     11 acts     12 acst
 *  13 tsca     14 tsac     15 tcas     16 tcsa     17 tasc     18 tacs
 *  19 scat     20 scta     21 satc     22 sact     23 stca     24 stac
 */