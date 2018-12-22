package com.thinkinginjava.holding_objects.exercise.chapter11_11;

import java.util.PriorityQueue;

/**
 * @Author: monika
 * @Date: 2018/12/22 1:05
 * @Version: 1.0
 * @Description: page 238
 * 练习28：创建一个继承自Object的简单类，它不包含任何成员，展示你不能将这个类的
 * 多个示例成功地添加到一个PriorityQueue中。这个问题将在第17章中详细解释。
 */
class A{}//A没有实现Comparable比较器接口。所以不能添加多个A对象至优先级队列。

public class Ex29 {
    public static void main(String[] args) {
        PriorityQueue<Object> queue = new PriorityQueue<>();
        queue.offer(new A());
       //! queue.offer(new A());
       //! queue.offer(new A());
        // case-- java.lang.ClassCastException: A cannot be cast to java.lang.Comparable

        while (queue.peek() != null)
            System.out.println(queue.poll());
    }
}
/**output:
 * com.thinkinginjava.holding_objects.exercise.chapter11_11.A@4554617c
 */