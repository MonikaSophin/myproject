package com.thinkinginjava.containers.example.chapter17_7.ex17_7_1;

import java.util.PriorityQueue;

/**
 * @Author: monika
 * @Date: 2019/2/25 21:31
 * @Version: 1.0
 * @Description:
 */
public class ToDoList  extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem> {
        private String item;
        private char primary; //主要的
        private int secondary; //次要的
        public ToDoItem(String item, char primary, int secondary) {
            this.item = item;
            this.primary = primary;
            this.secondary = secondary;
        }
        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary)
                return +1;
            if (primary == o.primary)
                if (secondary > o.secondary)
                    return +1;
                else if (secondary == o.secondary)
                    return 0;
            return -1;
        }
        @Override
        public String toString() {
            return String.format("%s%s: %s",
                    Character.toString(primary), secondary, item);
        }
    }

    public boolean add(String item, char primary, int secondary) {
        return super.add(new ToDoItem(item, primary, secondary));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash", 'C', 4);
        toDoList.add("Feed dog", 'A', 2);
        toDoList.add("Feed bird", 'B', 7);
        toDoList.add("Mow lawn", 'C', 3);
        toDoList.add("Water lawn", 'A', 1);
        toDoList.add("Feed cat", 'B', 1);
        while(!toDoList.isEmpty())
            System.out.println(toDoList.remove());
    }
}
/**output:
 * A1: Water lawn
 * A2: Feed dog
 * B1: Feed cat
 * B7: Feed bird
 * C3: Mow lawn
 * C4: Empty trash
 */