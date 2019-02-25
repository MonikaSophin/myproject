package com.thinkinginjava.containers.example.chapter17_7;

import com.thinkinginjava.util.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author: monika
 * @Date: 2019/2/25 21:23
 * @Version: 1.0
 * @Description:
 */
public class QueueBehavior {
    private static int count = 10;
    static <T> void test(Queue<T> queue, Generator<T> gen) {
        for (int i = 0; i < count; i++)
            queue.offer(gen.next()); // => add()
        while(queue.peek() != null) //查看头部元素，但不移除。=> element()
            System.out.print(queue.remove() + " ");//移除并返回头部元素。=> poll()
        System.out.println();
    }
    static class Gen implements Generator<String> {
        String[] s = ("one two three four five six seven " +
                "eight nine ten").split(" ");
        int i;
        @Override
        public String next() { return s[i++]; }
    }

    public static void main(String[] args) {
        test(new LinkedList<>(), new Gen());
        test(new PriorityQueue<>(), new Gen());
        test(new ArrayBlockingQueue<>(count), new Gen());
        test(new ConcurrentLinkedQueue<>(), new Gen());
        test(new LinkedBlockingQueue<>(), new Gen());
        test(new PriorityBlockingQueue<>(), new Gen());
    }
}
/**output:
 * one two three four five six seven eight nine ten
 * eight five four nine one seven six ten three two
 * one two three four five six seven eight nine ten
 * one two three four five six seven eight nine ten
 * one two three four five six seven eight nine ten
 * eight five four nine one seven six ten three two
 */