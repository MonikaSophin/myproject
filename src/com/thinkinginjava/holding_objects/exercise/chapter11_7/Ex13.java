package com.thinkinginjava.holding_objects.exercise.chapter11_7;

import com.thinkinginjava.inner_classes.example.chapter10_8.ex10_8_2.Event;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @Author: monika
 * @Date: 2018/12/15 16:23
 * @Version: 1.0
 * @Description: page 229
 * 练习13：在innerclasses/GreenhouseController.java示例中，Controller类使用的是
 * ArrayList,修改代码，用LinkedList替换之，并使用Iterator来循环遍历事件集。
 */
public class Ex13 {
    private LinkedList<Event> eventList = new LinkedList<Event>();
    public void addEvent(Event c) { eventList.add(c); }
    public void run() {
        LinkedList<Event> eventListCopy =
                new LinkedList<Event>(eventList);
        ListIterator<Event> it
                = eventListCopy.listIterator();
        while(it.hasNext()) {
            it.next().action();
            it.previous();
            System.out.println(it.next());
        }
    }
}
