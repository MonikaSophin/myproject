package com.thinkinginjava.generics.exercise.chapter15_11;

import java.util.ArrayList;

/**
 * @Author: monika
 * @Date: 2019/2/16 19:40
 * @Version: 1.0
 * @Description: page 403
 * 练习33：使用ArrayList修复GenericCast.java。
 */
class FixedSizeStack<T> {
    private int index = -1;
    private ArrayList<T> storage;
    public FixedSizeStack() {
        storage = new ArrayList<>();
    }
    public void push(T item) {
        storage.add(item);
        index++;
    }
    @SuppressWarnings("unchecked")
    public T pop() {
        T t = storage.get(index);
        index--;
        return t;
    }
}

class GenericCast {
    public static void main(String[] args) {
        FixedSizeStack<String> strings =
                new FixedSizeStack<>();
        for(String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
        for(int i = 0; i < 10; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}

public class Ex33 {
    public static void main(String[] args) {
        GenericCast.main(args);
    }
}
/** Output:
 *J I H G F E D C B A
 */

