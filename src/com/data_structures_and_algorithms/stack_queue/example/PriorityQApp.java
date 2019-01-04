package com.data_structures_and_algorithms.stack_queue.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/2
 * @description: 清单4.6 一个简单的基于数字优先级队列的java代码。
 */
class PriorityQ {
    private int maxSize;
    private long[] queArray;
    private int nItems;
    //队尾rear总是'0'，队头front总是'nItems-1'

    public PriorityQ(int s){
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        int j;
        if (nItems == 0)
            queArray[nItems++] = item;
        else{
            for (j = nItems - 1; j >=0 ; j--) {
                if (item > queArray[j])
                    queArray[j+1] = queArray[j];
                else
                    break;
            }
            queArray[j+1] = item;
            nItems++;
        }
    }

    public long remove(){ return queArray[--nItems]; }
    public long peekMin(){ return queArray[nItems-1]; }
    public boolean isEmpty(){ return nItems == 0; }
    public boolean isFull(){ return nItems == maxSize; }
}

public class PriorityQApp {
    public static void main(String[] args) {
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        while (!thePQ.isEmpty()){
            long item = thePQ.remove();
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
/**output:
 * 10 20 30 40 50
 */