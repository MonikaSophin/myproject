package com.thinkinginjava.holding_objects.exercise.chapter11_11;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/12/22 0:59
 * @Version: 1.0
 * @Description: page 238
 * 练习28：用由java.util.Random创建的Double值填充一个PriorityQueue（用offer()方法），
 * 然后使用poll()移除并显示它们。
 */
public class Ex28 {
    public static void main(String[] args) {
        Random random = new Random(47);
        PriorityQueue<Double> queue = new PriorityQueue<>();
        for (int i = 0; i < 5; i++)
           queue.offer(random.nextDouble());

        System.out.println("queue isEmpty: " + queue.isEmpty());
        while (queue.peek() != null)
            System.out.print(queue.poll() + " ");
        System.out.println();
        System.out.println("queue isEmpty: " + queue.isEmpty());
    }
}
/**output:
 * queue isEmpty: false
 * 0.16020656493302599 0.18847866977771732 0.5166020801268457 0.5309454508634242 0.7271157860730044
 * queue isEmpty: true
 */