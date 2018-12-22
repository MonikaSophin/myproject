package com.thinkinginjava.holding_objects.example.chapter11_11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/12/22 0:18
 * @Version: 1.0
 * @Description:
 * 1.队列是一个典型的FIFO的容器。
 * 2.
 *    offer() 添加元素至队尾
 *    remove() 移除并返回队头元素  队列为空时，抛出异常
 *    poll() 移除并返回队头元素  队列为空时，返回null
 *    peek() 返回队头元素但不删除  队列为空时，返回null
 *    element() 返回队头元素但不删除  队列为空时，抛出异常
 */
public class QueueDemo {
    public static void printQ(Queue queue){
        while(queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++)
            queue.offer(random.nextInt(i + 10));
        printQ(queue);
        Queue<Character> qc = new LinkedList<>();
        for (char c : "Brontosaurus".toCharArray())
            qc.offer(c);
        printQ(qc);
    }
}
/**output:
 * 8 1 1 1 5 14 3 1 0 1
 * B r o n t o s a u r u s
 */