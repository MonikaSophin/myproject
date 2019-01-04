package com.data_structures_and_algorithms.stack_queue.exercise;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/3
 * @description: page 129
 * 练习4.1：为queue.java程序（清单4.4）的Queue类中的写一个方法，显示队列的内容。注意这并不
 * 是要简单的显示出数组的内容。它要求按数据项插入的队列的顺序，从第一个插入的数据项到最后一个
 * 插入的数据项显示出来，不要输出因为在数组末端回绕而折成两半的样子。注意无论front和rear在什么
 * 位置上，都要正确显示一个数据项和没有数据项的情况。
 */
class Queue {
    private int maxSize;
    private long[] queueArray;
    private int front;//队头标识（下标）
    private int rear;//队尾标识（下标）
    private int nItems;//实际数组元素个数

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new long[maxSize];
        front = 0;//移除队头元素后，该下标+1
        rear = -1;//插入元素到队尾后，该下标+1
        nItems = 0;//插入元素+1，删除元素-1
    }

    //插入元素置队尾
    public void insert(long j) {
        if (rear == maxSize - 1)//若队尾到(maxSize-1)位置，但是队列没满，则将队尾标识重置为-1
            rear = -1;
        queueArray[++rear] = j;//将队尾标识+1后，赋值
        nItems++;
    }

    //移除队头元素
    public long remove() {
        long temp = queueArray[front++];
        if (front == maxSize)//若队头到(maxSize)位置，则将队头标识重置为0
            front = 0;
        nItems--;
        return temp;//返回当前队头元素，将队头标识+1
    }

    //查看队头元素
    public long peekFront() {
        return queueArray[front];
    }

    //队列是否为空
    public boolean isEmpty() {
        return nItems == 0;
    }

    //队列是否为满
    public boolean isFull() {
        return nItems == maxSize;
    }

    //当前队列中元素个数
    public int size() {
        return nItems;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    //显示队列中的元素按照插入的先后顺序
    public void displayQueue() {
        // rear> front  正常填充至队列
        if (rear > front) {
            for (int i = front; i <= rear; i++)
                System.out.print(queueArray[i] + " ");
        } else if (rear < front){// rear < front 数组回绕
            for (int i = front; i <= maxSize - 1; i++)
                System.out.print(queueArray[i] + " ");
            for (int i = 0; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
        }
    }
}

public class Ex4_1 {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.displayQueue();
        System.out.println();

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        theQueue.displayQueue();
        System.out.println();

        System.out.println("队头元素下标: " + theQueue.getFront());
        System.out.println("队尾元素下标: " + theQueue.getRear());
    }
}
/**output:
 * 10 20 30 40
 * 40 50 60 70 80
 * 队头元素下标: 3
 * 队尾元素下标: 2
 */
