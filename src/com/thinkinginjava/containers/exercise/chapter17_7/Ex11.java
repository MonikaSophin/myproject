package com.thinkinginjava.containers.exercise.chapter17_7;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @Author: monika
 * @Date: 2019/2/25 21:42
 * @Version: 1.0
 * @Description: page 482
 * 练习11：创建一个类，它包含一个Integer,其值通过使用java.util.Random被初始化为0
 * 到100之间的某个值。使用这个Integer域来实现Comparable。用这个类的对象来填充
 * PriorityQueue，然后使用poll()抽取这些值以展示该队列间按照我们预期的顺序产生这些值。
 */
class A implements Comparable<A>{
    Integer i;
    private Random r = new Random();
    public A() { this.i = r.nextInt(100); }

    @Override
    public int compareTo(A a) {
        return this.i < a.i ? -1 : (this.i == a.i ? 0 : 1);
    }

    @Override
    public String toString() {
        return "A{" + "i=" + i + '}';
    }
}

public class Ex11 {
    public static void main(String[] args) {
        Queue<A> queue = new PriorityQueue<>();
        queue.add(new A());
        queue.add(new A());
        queue.add(new A());
        queue.add(new A());
        queue.add(new A());
        System.out.println(queue);

        while(queue.peek() != null) {
            System.out.print(queue.poll() + " ");
        }
    }
}
/**output:
 * [A{i=27}, A{i=54}, A{i=96}, A{i=72}, A{i=94}]
 * A{i=27} A{i=54} A{i=72} A{i=94} A{i=96}
 */