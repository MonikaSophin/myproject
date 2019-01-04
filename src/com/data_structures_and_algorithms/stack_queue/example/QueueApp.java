package com.data_structures_and_algorithms.stack_queue.example;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/29
 * @description: 清单4.4 队列(环绕式处理队列)
 * 1.若添加元素至队尾，到达了最大位置，但是队列没满，则将队尾标识重置为-1。
 * 2.若移除队头元素到达了最大位置，则将队头标识重置为0
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
    public void insert(long j){
         if (rear == maxSize -1)//若队尾到(maxSize-1)位置，但是队列没满，则将队尾标识重置为-1
             rear = -1;
         queueArray[++rear] = j;//将队尾标识+1后，赋值
         nItems++;
    }

    //移除队头元素
    public long remove(){
        long temp = queueArray[front++];
        if (front == maxSize)//若队头到(maxSize)位置，则将队头标识重置为0
            front = 0;
        nItems--;
        return temp;//返回当前队头元素，将队头标识+1
    }

    //查看队头元素
    public long peekFront(){ return queueArray[front]; }

    //队列是否为空
    public boolean isEmpty(){ return nItems == 0; }

    //队列是否为满
    public boolean isFull(){ return nItems == maxSize; }

    //当前队列中元素个数
    public int size(){ return nItems; }

    public int getFront() { return front; }
    public int getRear() { return rear; }
}

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);

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

        System.out.print("队列元素有: ");
        while (!theQueue.isEmpty()){
            long n = theQueue.remove();
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.println("队头元素下标: " + theQueue.getFront());
        System.out.println("队尾元素下标: " + theQueue.getRear());
    }
}
/**output:
 * 队列元素有: 40 50 60 70 80
 * 队头元素下标: 3
 * 队尾元素下标: 2
 */