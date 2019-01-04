package com.data_structures_and_algorithms.stack_queue.example;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/29
 * @description: 清单4.1 栈的push、pop、peek操作
 */
class StackX {
    private int maxSize;
    private long[] stackArray;
    private int top;//栈顶元素位置

    public StackX(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    //入栈
    public void push(long j) { stackArray[++top] = j; }

    //出栈
    public long pop() { return stackArray[top--]; }

    //查看栈顶元素
    public long peek() { return stackArray[top]; }

    //栈是否为空
    public boolean isEmpty() { return top == -1; }

    //栈是否满了
    public boolean isFull() { return top == maxSize - 1; }
}

public class StackApp {
    public static void main(String[] args) {
        StackX theStack = new StackX(10);

        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while(!theStack.isEmpty()){
            long value = theStack.pop();
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
/**output:
 * 80 60 40 20
 */
