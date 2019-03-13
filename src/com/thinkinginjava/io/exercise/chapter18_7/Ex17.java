package com.thinkinginjava.io.exercise.chapter18_7;

import com.thinkinginjava.util.TextFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description: page 547
 * 练习17：用{@link TextFile}和Map<Character,Integer>创建一个程序，它可以对在一个文件中
 * 所有不同的字符出现的次数进行计数（因此如果在文件中字母a出现了12次，那么在Map中与包含a的
 * Character相关联的Integer就包含12）。
 */
public class Ex17 {
    public static void main(String[] args) {
        String path = "src\\com\\thinkinginjava\\io\\exercise\\chapter18_7\\file\\Ex17.txt";
        String strings = TextFile.read(path).trim();
        char[] chars = new char[strings.length()];
        strings.getChars(0, strings.length(),chars, 0);

        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (c == '\n')
                continue;
            Integer count = map.get(c);
            if (count==null)
                map.put(c, 1);
            else {
                count++;
                map.put(c,count);
            }
        }

        System.out.println(map);
    }
}
/**output:
 * {\=6, a=14, b=6, c=16, d=8, e=11, f=20, g=13, '=9, h=8, i=9, j=10, *=16, k=20, l=9, m=9, n=10, q=21, r=8, t=9, u=8, w=7, x=16, y=8, z=9, ?=10}
 */