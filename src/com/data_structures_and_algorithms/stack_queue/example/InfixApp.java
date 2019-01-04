package com.data_structures_and_algorithms.stack_queue.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/2
 * @description: 清单4.7 将中缀表达式转换为后缀表达式
 * 中缀表达式   后缀表达式
 * A+B-C        AB+C-
 * (A+B)*(C-D)  AB+CD-*
 * A*(B-C)      ABC-*
 * ...
 */
class InfixStack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public InfixStack(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j){ stackArray[++top] = j; }
    public char pop(){ return stackArray[top--]; }
    public char peek(){ return stackArray[top]; }
    public boolean isEmpty(){ return top == -1; }
    public int size(){ return top + 1; }
    public char peekN(int n){ return stackArray[n]; }

    public void displayStack(String s){
        System.out.print(String.format("%s Stack (bottom-->top): ", s));
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j) + " ");
        }
        System.out.println();
    }
}

class InToPost{
    private InfixStack theStack;
    private String input;
    private String output = "";
    public InToPost(String in){
        input = in;
        int stackSize = input.length();
        theStack = new InfixStack(stackSize);
    }

    public String doTrans(){
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.displayStack("For " + ch + " ");
            switch (ch){
                case '+':
                case '-':
                    gotOper(ch,1);
                    break;
                case '*':
                case '/':
                    gotOper(ch,2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!theStack.isEmpty()){
            theStack.displayStack("While ");
            output = output + theStack.pop();
        }
        theStack.displayStack("End   ");
        return output;
    }

    public void gotOper(char opThis, int prec1){
        while (!theStack.isEmpty()){
            char opTop = theStack.pop();
            if (opTop == '('){
                theStack.push(opTop);
                break;
            }else {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1){
                    theStack.push(opTop);
                    break;
                }else
                    output = output + opTop;
            }
        }
        theStack.push(opThis);
    }

    public void gotParen(char ch){
        while (!theStack.isEmpty()){
            char chx = theStack.pop();
            if (chx == '(')
                break;
            else
                output = output + chx;
        }
    }

}

public class InfixApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true){
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();
            if (input.equals(""))
                break;

            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans();
            System.out.println("Postfix is " + output + "\n");
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
 * Enter infix: (A+B)*(C-D)
 * For (  Stack (bottom-->top):
 * For A  Stack (bottom-->top): (
 * For +  Stack (bottom-->top): (
 * For B  Stack (bottom-->top): ( +
 * For )  Stack (bottom-->top): ( +
 * For *  Stack (bottom-->top):
 * For (  Stack (bottom-->top): *
 * For C  Stack (bottom-->top): * (
 * For -  Stack (bottom-->top): * (
 * For D  Stack (bottom-->top): * ( -
 * For )  Stack (bottom-->top): * ( -
 * While  Stack (bottom-->top): *
 * End    Stack (bottom-->top):
 * Postfix is AB+CD-*
 *
 * Enter infix: A+B-C
 * For A  Stack (bottom-->top):
 * For +  Stack (bottom-->top):
 * For B  Stack (bottom-->top): +
 * For -  Stack (bottom-->top): +
 * For C  Stack (bottom-->top): -
 * While  Stack (bottom-->top): -
 * End    Stack (bottom-->top):
 * Postfix is AB+C-
 *
 * Enter infix: A*(B-C)
 * For A  Stack (bottom-->top):
 * For *  Stack (bottom-->top):
 * For (  Stack (bottom-->top): *
 * For B  Stack (bottom-->top): * (
 * For -  Stack (bottom-->top): * (
 * For C  Stack (bottom-->top): * ( -
 * For )  Stack (bottom-->top): * ( -
 * While  Stack (bottom-->top): *
 * End    Stack (bottom-->top):
 * Postfix is ABC-*
 *
 * Enter infix: A/B+C*D
 * For A  Stack (bottom-->top):
 * For /  Stack (bottom-->top):
 * For B  Stack (bottom-->top): /
 * For +  Stack (bottom-->top): /
 * For C  Stack (bottom-->top): +
 * For *  Stack (bottom-->top): +
 * For D  Stack (bottom-->top): + *
 * While  Stack (bottom-->top): + *
 * While  Stack (bottom-->top): +
 * End    Stack (bottom-->top):
 * Postfix is AB/CD*+
 *
 * Enter infix: A*(B+C)-D/(E+F)
 * For A  Stack (bottom-->top):
 * For *  Stack (bottom-->top):
 * For (  Stack (bottom-->top): *
 * For B  Stack (bottom-->top): * (
 * For +  Stack (bottom-->top): * (
 * For C  Stack (bottom-->top): * ( +
 * For )  Stack (bottom-->top): * ( +
 * For -  Stack (bottom-->top): *
 * For D  Stack (bottom-->top): -
 * For /  Stack (bottom-->top): -
 * For (  Stack (bottom-->top): - /
 * For E  Stack (bottom-->top): - / (
 * For +  Stack (bottom-->top): - / (
 * For F  Stack (bottom-->top): - / ( +
 * For )  Stack (bottom-->top): - / ( +
 * While  Stack (bottom-->top): - /
 * While  Stack (bottom-->top): -
 * End    Stack (bottom-->top):
 * Postfix is ABC+*DEF+/-
 */