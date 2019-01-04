package com.data_structures_and_algorithms.stack_queue.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/3
 * @description: 清单4.8 计算后缀表达式并给出结果
 */
class PostfixStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public PostfixStack(int size){
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j){ stackArray[++top] = j; }
    public int pop(){ return stackArray[top--]; }
    public int peek(){ return stackArray[top]; }
    public boolean isEmpty(){ return top == -1; }
    public boolean isFull(){ return top == maxSize -1; }
    public int size(){ return top + 1; }
    public int peekN(int n){ return stackArray[n]; }

    public void displayStack(String s){
        System.out.print(String.format("%s Stack (bottom-->top): ", s));
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j) + " ");
        }
        System.out.println();
    }
}

class ParsePost{
    private PostfixStack theStack;
    private String input;

    public ParsePost(String s){ input = s; }

    public int doParse(){
        theStack = new PostfixStack(20);
        char ch;
        int j;
        int num1, num2, interAns;

        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            theStack.displayStack(ch +" ");
            if (ch >= '0' && ch <='9')
                theStack.push((int)(ch - '0'));
            else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch){
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }
}

public class PostfixApp {
    public static void main(String[] args) throws IOException {
        String input;
        int output;

        while (true){
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString();
            if (input.equals(""))
                break;

            ParsePost parsePost = new ParsePost(input);
            output = parsePost.doParse();
            System.out.println("Evaluates to " + output);
        }
    }
    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
/**output:
 * Enter postfix: 345+*612+/-
 * 3  Stack (bottom-->top):
 * 4  Stack (bottom-->top): 3
 * 5  Stack (bottom-->top): 3 4
 * +  Stack (bottom-->top): 3 4 5
 * *  Stack (bottom-->top): 3 9
 * 6  Stack (bottom-->top): 27
 * 1  Stack (bottom-->top): 27 6
 * 2  Stack (bottom-->top): 27 6 1
 * +  Stack (bottom-->top): 27 6 1 2
 * /  Stack (bottom-->top): 27 6 3
 * -  Stack (bottom-->top): 27 2
 * Evaluates to 25
 * Enter postfix: 234+*
 * 2  Stack (bottom-->top):
 * 3  Stack (bottom-->top): 2
 * 4  Stack (bottom-->top): 2 3
 * +  Stack (bottom-->top): 2 3 4
 * *  Stack (bottom-->top): 2 7
 * Evaluates to 14
 * Enter postfix: 234-*
 * 2  Stack (bottom-->top):
 * 3  Stack (bottom-->top): 2
 * 4  Stack (bottom-->top): 2 3
 * -  Stack (bottom-->top): 2 3 4
 * *  Stack (bottom-->top): 2 -1
 * Evaluates to -2
 * Enter postfix: 23+1-
 * 2  Stack (bottom-->top):
 * 3  Stack (bottom-->top): 2
 * +  Stack (bottom-->top): 2 3
 * 1  Stack (bottom-->top): 5
 * -  Stack (bottom-->top): 5 1
 * Evaluates to 4
 * Enter postfix:
 */