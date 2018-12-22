package com.thinkinginjava.holding_objects.exercise.chapter11_10;

import com.thinkinginjava.holding_objects.example.chapter11_9.TextFile;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/19 23:26
 * @Version: 1.0
 * @Description: page 236
 * 练习21：通过使用Map<String,Integer>，遵循UniqueWords.java的形式来创建一个程序，
 * 它可以对一个文件中出现的单词计数。使用带有第二参数String.CASE_INSENSITIVE_ORDER的
 * Collections.sort()方法对结果进行排序（将产生字母序），然后显示结果。
 */
public class Ex21 {
    static void wordsCounter(List<String> list) {
        Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);
        System.out.println();

        Map<String, Integer> map = new LinkedHashMap<>();
        int allCount = 0;
        for (String s : list) {
            Integer count = map.get(s);
            map.put(s, count == null ? count = 1 : ++count);
            allCount++;
        }
        System.out.println(map);
        System.out.print("Total words: " + allCount);
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(
                new TextFile("src\\com\\thinkinginjava\\holding_objects\\example\\chapter11_9\\SetOperations.java", "\\W+"));
        wordsCounter(words);
    }
}
