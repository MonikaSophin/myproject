package com.thinkinginjava.containers.exercise.chapter17_8;

import com.thinkinginjava.containers.example.chapter17_8.AssociativeArray;
import com.thinkinginjava.util.TextFile;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description: page 484
 * 练习13：使用AssociativeArray.java来创建一个单词出现次数的计数器，用String映射到
 * Integer。使用com.thinkinginjava.util.TextFile工具来打开一个文本文件，并使用空格
 * 和标点符号将该文件断开为单词，然后计数该文件中各个单词出现的次数。
 */
public class Ex13 {
    public static void main(String[] args) {
        String fileName = "src\\com\\thinkinginjava\\containers\\exercise\\chapter17_8\\test.txt";
        TreeSet<String> words = new TreeSet<>(new TextFile(fileName, "\\W+"));
        AssociativeArray<String, Integer> map = new AssociativeArray<>(words.size());

        ArrayList<String> list = new ArrayList<>(new TextFile(fileName, "\\W+"));
        for (String s : words) {
            int count = 0;
            for (String t : list) {
                if (s.equals(t))
                    count++;
            }
            map.put(s, count);
        }
        System.out.println(map);

    }
}
/**output:
 * a : 3
 * b : 3
 * c : 3
 * d : 3
 * test : 6
 */