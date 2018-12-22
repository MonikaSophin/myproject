package com.thinkinginjava.holding_objects.exercise.chapter11_4;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/12 22:33
 * @Version: 1.0
 * @Description: page 223
 * 练习04:创建一个生成器类，它可以在每次调用其next()方法时，产生你由你最喜欢的电
 * 影（你可以使用Snow White或Star Wars）的字符构成的名字（作为String对象）。在
 * 字符列表中的电影名用完之后，循环到这个字符列表的开始处。使用这个生成器来填充数据，
 * ArrayList、LinkedList、HashSet、LinkedHashSet和TreeSet,然后打印每一个容
 * 器。
 */
class CreaterContainers{
    private String[] movies;
    private int key = 0;
    private int size;
    public CreaterContainers(int size) {
        this.size = size;
        movies = new String[size];
    }

    public String next(){
        switch(key) {
            default:
            case 0 : key++; return "Snow";
            case 1 : key++; return "Bashful";
            case 2 : key++; return "Doc";
            case 3 : key++; return "Dopey";
            case 4 : key++; return "Grumpy";
            case 5 : key++; return "Happy";
            case 6 : key++; return "Sleepy";
            case 7 : key = 0; return "Sneezy";
        }
    }

    public String[] fillArray(){
        for (int i = 0; i < size; i++)
            movies[i] = next();
        return movies;
    }

    public void fill(Collection collection){
        collection.addAll(Arrays.asList(movies));
        System.out.println(collection.toString());
    }
}

public class Ex04 {
    public static void main(String[] args) {
        CreaterContainers containers = new CreaterContainers(10);
        String[] strings = containers.fillArray();
        for (String s:strings){
            System.out.print(s + " ");
        }
        System.out.println();
        containers.fill(new ArrayList());
        containers.fill(new LinkedList());
        containers.fill(new HashSet());
        containers.fill(new LinkedHashSet());
        containers.fill(new TreeSet());
    }
}
/**输出：
 * Snow Bashful Doc Dopey Grumpy Happy Sleepy Sneezy Snow Bashful
 * [Snow, Bashful, Doc, Dopey, Grumpy, Happy, Sleepy, Sneezy, Snow, Bashful]
 * [Snow, Bashful, Doc, Dopey, Grumpy, Happy, Sleepy, Sneezy, Snow, Bashful]
 * [Sleepy, Snow, Happy, Sneezy, Doc, Grumpy, Dopey, Bashful]
 * [Snow, Bashful, Doc, Dopey, Grumpy, Happy, Sleepy, Sneezy]
 * [Bashful, Doc, Dopey, Grumpy, Happy, Sleepy, Sneezy, Snow]
 */