package com.thinkinginjava.string.exercise.chapter13_6;

import com.thinkinginjava.util.TextFile;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/13 18:05
 * @Version: 1.0
 * @Description: page 308
 * 练习16：修改JGrep.java类，令其能够接受一个目录或文件为参数（如果传入的是目录，
 * 就搜索目录中的所有文件）。提示：可以用下面的方法获得所有文件的名字列表：
 *  File[] files = new File(".").listFiles();
 */
public class Ex16 {
    public static void main(String[] args) {
        String regex = "\\b[Ssct]\\w+";
        String pathName = "src\\com\\thinkinginjava\\string\\example\\chapter13_6\\ex13_6_8";

        File[] files = new File(pathName).listFiles();
        for (File file : files){
           String fileName = file.getAbsolutePath();
            System.out.println(fileName);

            Pattern p = Pattern.compile(regex);
            int index = 0;
            Matcher m = p.matcher("");

            for (String line : new TextFile(fileName)) {
                m.reset(line);
                while (m.find())
                    System.out.println(index++ + ": " +
                            m.group() + ": " + m.start());
            }
        }
    }
}
/**output(70% match):
 * E:\workspace\idea\myproject\src\com\thinkinginjava\string\example\chapter13_6\ex13_6_8\JGrep.java
 * 0: com: 8
 * 1: thinkinginjava: 12
 * 2: string: 27
 * 3: chapter13_6: 42
 * 4: com: 7
 * 5: thinkinginjava: 11
 * 6: chapter11_9: 50
 * 7: class: 7
 * 8: static: 11
 * 9: String: 28
 * 10: String: 8
 * 11: Ssct: 28
 * 12: String: 8
 * 13: src: 27
 * 14: com: 32
 * 15: thinkinginjava: 37
 * 16: string: 53
 * 17: chapter13_6: 70
 * 18: compile: 28
 * 19: String: 13
 * 20: System: 16
 * 21: start: 45
 * 22: com: 6
 * 23: thinkinginjava: 6
 * 24: string: 6
 * 25: chapter13_6: 6
 * 26: com: 6
 * 27: thinkinginjava: 6
 * 28: chapter11_9: 6
 * 29: class: 6
 * 30: static: 6
 * 31: String: 6
 * 32: String: 7
 * 33: Ssct: 7
 * 34: String: 7
 * 35: src: 7
 * 36: com: 7
 * 37: thinkinginjava: 7
 * 38: string: 7
 * 39: chapter13_6: 7
 * 40: compile: 7
 * 41: String: 7
 * 42: System: 7
 * 43: start: 7
 * E:\workspace\idea\myproject\src\com\thinkinginjava\string\example\chapter13_6\ex13_6_8\package-info.java
 * 0: com: 8
 * 1: thinkinginjava: 12
 * 2: string: 27
 * 3: chapter13_6: 4
 */