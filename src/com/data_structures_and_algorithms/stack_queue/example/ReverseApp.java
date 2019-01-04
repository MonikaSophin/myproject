package com.data_structures_and_algorithms.stack_queue.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/29
 * @description: 清单4.2 单词逆序
 */
class StackY {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackY(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char c) { stackArray[++top] = c; }
    public char pop() { return stackArray[top--]; }
    public char peek() { return stackArray[top]; }
    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == maxSize - 1; }
}

class Reverser{
    private String input;
    private String output;

    public Reverser(String input) { this.input = input; }

    public String doRev(){
        int stackSize = input.length();
        StackY theStack = new StackY(stackSize);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.push(ch);
        }

        output = "";
        while (!theStack.isEmpty()){
            char ch = theStack.pop();
            output += ch;
        }
        return output;
    }
}

public class ReverseApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while(true){
            System.out.print("Enter a String: ");
            System.out.flush();
            input = getString();
            if (input.equals(""))
                break;
            if (input.compareToIgnoreCase("over") == 0)
                return;

            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();
            System.out.println("Reversed: " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
/**output:
 * Enter a String: abcd
 * Reversed: dcba
 * Enter a String: stack
 * Reversed: kcats
 * Enter a String: reverser
 * Reversed: resrever
 * Enter a String: over
 */