package com.thinkinginjava.string.example.chapter13_6.ex13_6_8;

import com.thinkinginjava.util.TextFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/13 17:54
 * @Version: 1.0
 * @Description:
 */
public class JGrep {
    public static void main(String[] args) {
        String regex = "\\b[Ssct]\\w+";
        String fileName = "src\\com\\thinkinginjava\\string\\example\\chapter13_6\\ex13_6_8\\JGrep.java";

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
/**output(70% match):
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
 */