package com.thinkinginjava.containers.exercise.chapter17_9;

import com.thinkinginjava.containers.example.chapter17_9.ex17_9_2.SimpleHashMap;
import com.thinkinginjava.util.TextFile;
import java.util.ArrayList;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/28
 * @description: page 495
 * 练习19: 使用SimpleHashMap重复练习13。
 */
public class Ex19 {
    public static void main(String[] args) {
        String fileName = "src\\com\\thinkinginjava\\containers\\exercise\\chapter17_8\\test.txt";
        ArrayList<String> list = new ArrayList<>(new TextFile(fileName, "\\W+"));
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();

        for (String s : list) {
            Integer count = map.get(s);
            if (count == null)
                map.put(s, 1);
            else {
                count++;
                map.put(s, count);
            }
        }

        System.out.println(map);
    }
}
/**output:
 * {c=3, b=3, a=3, test=6, d=3}
 */