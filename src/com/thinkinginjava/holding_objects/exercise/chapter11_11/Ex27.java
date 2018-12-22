package com.thinkinginjava.holding_objects.exercise.chapter11_11;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: monika
 * @Date: 2018/12/22 0:28
 * @Version: 1.0
 * @Description: page 237
 * 练习27：写一个称为Command的类，它包含一个String域和一个显示该String的
 * operation()方法。写第二个类，它具有一个使用Command对象来填充一个Queue
 * 并返回这个对象的方法。将填充后的Queue传递给第三个类的一个方法，该方法消耗
 * 掉Queue中的对象，并调用它们的operation()方法。
 */
class Command {
    String string;
    public Command(String string) { this.string = string; }
    void operation() { System.out.print(string + " "); }
}

class CommandQueue {
    private Queue<Command> queue = new LinkedList();
    private void infill(List<Command> list) {
        for (Command command : list)
            queue.offer(command);
    }
    Queue<Command> getQueue(List<Command> list) {
        infill(list);
        return queue;
    }
}

public class Ex27 {
    static void printQ(Queue<Command> queue) {
        while (queue.peek() != null) {
            Command command = queue.poll();
            command.operation();
        }
        System.out.println();
        System.out.println("queue isEmpty: " + queue.isEmpty());
    }

    public static void main(String[] args) {
        List<Command> list = new LinkedList<>();
        Collections.addAll(list,
                new Command("A"),
                new Command("B"),
                new Command("C"),
                new Command("D"),
                new Command("E"));
        CommandQueue commandQueue = new CommandQueue();
        Queue<Command> queue = commandQueue.getQueue(list);
        printQ(queue);
    }
}
/**output：
 * A B C D E
 * queue isEmpty: true
 */