package com.thinkinginjava.containers.exercise.chapter17_9;

import com.thinkinginjava.containers.example.chapter17_9.ex17_9_1.SlowMap;
import com.thinkinginjava.util.TextFile;
import java.util.ArrayList;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description: page 493
 * 练习15：使用SlowMap重复练习13。
 */
public class Ex15 {
    public static void main(String[] args) {
        String fileName = "src\\com\\thinkinginjava\\containers\\exercise\\chapter17_8\\test.txt";
        ArrayList<String> list = new ArrayList<>(new TextFile(fileName, "\\W+"));
        SlowMap<String, Integer> map = new SlowMap<>();

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
 * {c=3, b=3, test=6, a=3, d=3}
 */