package com.thinkinginjava.string.exercise.chapter13_6;

import com.thinkinginjava.holding_objects.example.chapter11_9.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/13 18:02
 * @Version: 1.0
 * @Description: page 308
 * 练习15：修改JGrep.java类，令其能够接受模式标志参数（例如
 * Pattern.CASE_INSENSITIVE，Pattern.MULTILINE）。
 */
public class Ex15 {
    public static void main(String[] args) {
        String regex = "\\b[Ssct]\\w+";
        String fileName = "src\\com\\thinkinginjava\\string\\exercise\\chapter13_6\\Ex15.java";

        Pattern p = Pattern.compile(regex,
                Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
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
 * 3: chapter13_6: 43
 * 4: com: 7
 * 5: thinkinginjava: 11
 * 6: chapter11_9: 50
 * 7: TextFile: 62
 * 8: CASE_INSENSITIVE: 11
 * 9: class: 7
 * 10: static: 11
 * 11: String: 28
 * 12: String: 8
 * 13: sct: 28
 * 14: String: 8
 * 15: src: 27
 * 16: com: 32
 * 17: thinkinginjava: 37
 * 18: string: 53
 * 19: chapter13_6: 71
 * 20: compile: 28
 * 21: CASE_INSENSITIVE: 24
 * 22: String: 13
 * 23: TextFile: 31
 * 24: System: 16
 * 25: start: 45
 */