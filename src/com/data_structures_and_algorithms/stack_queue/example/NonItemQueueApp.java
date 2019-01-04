package com.data_structures_and_algorithms.stack_queue.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/2
 * @description: 清单4.5 没有nItem属性的Queue类
 */
class NonItemQueue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public NonItemQueue(int s) {
        this.maxSize = s + 1;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(long j) {
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = j;
    }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        return temp;
    }

    public long peek() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return ((rear + 1 == front) || (front + maxSize - 1 == rear));
    }

    public boolean isFull() {
        return ((rear + 2 == front) || (front + maxSize - 2 == rear));
    }

    public int size() {
        if (rear >= front)
            return rear - front + 1;
        else
            return (maxSize + front) + (rear + 1);
    }

    public int getFront() { return front; }
    public int getRear() { return rear; }
}

public class NonItemQueueApp {
    public static void main(String[] args) {
        NonItemQueue theQueue = new NonItemQueue(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        System.out.println("isFull(): " + theQueue.isFull());

        System.out.print("队列元素有: ");
        while (!theQueue.isEmpty()) {
            long n = theQueue.remove();
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.println("isFull(): " + theQueue.isFull());

        System.out.println("队头元素下标: " + theQueue.getFront());
        System.out.println("队尾元素下标: " + theQueue.getRear());
    }
}
/**output:
 * isFull(): true
 * 队列元素有: 40 50 60 70 80
 * isFull(): false
 * 队头元素下标: 2
 * 队尾元素下标: 1
 */