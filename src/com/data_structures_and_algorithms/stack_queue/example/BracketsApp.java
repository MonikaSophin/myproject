package com.data_structures_and_algorithms.stack_queue.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/29
 * @description: 清单4.3 分隔符匹配
 */
class StackZ{
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackZ(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char ch){ stackArray[++top] = ch; }
    public char pop(){ return stackArray[top--]; }
    public char peek(){ return stackArray[top]; }
    public boolean isEmpty(){ return top == -1; }
    public boolean isFull(){ return top == maxSize - 1; }
}

class BracketChecker{
    private String input;

    public BracketChecker(String input) { this.input = input; }

    public void check(){
        int stackSize = input.length();
        StackZ theStack = new StackZ(stackSize);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch){
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;

                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()){
                        char pop = theStack.pop();
                        if ( (ch == '}' && pop!='{')||
                             (ch == ']' && pop!='[')||
                             (ch == ')' && pop!='(') ){
                            System.out.println("Error: " + ch +" at " + j);
                        }else {
                            System.out.println("Correct: " + ch +" at " + j);
                        }
                        break;
                    }
                default:
                    break;
            }
        }

        if (!theStack.isEmpty()){
            System.out.println("Error: missing right delimiter");
        }
    }
}

public class BracketsApp {
    public static void main(String[] args) throws IOException {
        String input;
        while (true){
            System.out.print("Enter String containing delimiters: ");
            System.out.flush();
            input = getString();
            if (input.equals(""))
                break;
            if (input.compareToIgnoreCase("over") == 0)
                return;

            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();
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
 * Enter String containing delimiters: a{b(c]d}e
 * Error: ] at 5
 * Correct: } at 7
 * Enter String containing delimiters: {]{
 * Error: ] at 1
 * Error: missing right delimiter
 * Enter String containing delimiters: {[()]}
 * Correct: ) at 3
 * Correct: ] at 4
 * Correct: } at 5
 * Enter String containing delimiters: {}[]()
 * Correct: } at 1
 * Correct: ] at 3
 * Correct: ) at 5
 * Enter String containing delimiters: ){]}
 * Error: ] at 2
 * Enter String containing delimiters: over
 */