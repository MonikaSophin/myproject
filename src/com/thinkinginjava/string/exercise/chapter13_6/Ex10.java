package com.thinkinginjava.string.exercise.chapter13_6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/12 19:15
 * @Version: 1.0
 * @Description: page 301
 * 练习10：对字符串Java now has regular expressions验证下列正则表达式是否能够发现一个匹配：
 * ^Java
 * \Berg.*
 * n.w\s+h(a|i)s
 * S?
 * S+
 * s{4}
 * s{1}.
 * s{0,3}
 */
public class Ex10 {
    public static void main(String[] args) {
        String string = "Java now has regular expressions";
        String[] regex =
                {"^Java",
                 "\\Berg.*",
                 "n.w\\s+h(a|i)s",
                 "S?",
                 "S*",
                 "S+",
                 "s{4}",
                 "s{1}",
                 "s{0,3}"};
        for (String reg : regex) {
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(string);
            System.out.println("regex: \"" + reg + "\"");
            while(m.find()){
                System.out.println("match: \"" + m.group() + "\" at positions " +
                        m.start() + "-" + (m.end() - 1));
            }
        }
    }
}
/**output:
 * regex: "^Java"
 * match: "Java" at positions 0-3
 * regex: "\Berg.*"
 * regex: "n.w\s+h(a|i)s"
 * match: "now has" at positions 5-11
 * regex: "S?"
 * match: "" at positions 0--1
 * match: "" at positions 1-0
 * match: "" at positions 2-1
 * match: "" at positions 3-2
 * match: "" at positions 4-3
 * match: "" at positions 5-4
 * match: "" at positions 6-5
 * match: "" at positions 7-6
 * match: "" at positions 8-7
 * match: "" at positions 9-8
 * match: "" at positions 10-9
 * match: "" at positions 11-10
 * match: "" at positions 12-11
 * match: "" at positions 13-12
 * match: "" at positions 14-13
 * match: "" at positions 15-14
 * match: "" at positions 16-15
 * match: "" at positions 17-16
 * match: "" at positions 18-17
 * match: "" at positions 19-18
 * match: "" at positions 20-19
 * match: "" at positions 21-20
 * match: "" at positions 22-21
 * match: "" at positions 23-22
 * match: "" at positions 24-23
 * match: "" at positions 25-24
 * match: "" at positions 26-25
 * match: "" at positions 27-26
 * match: "" at positions 28-27
 * match: "" at positions 29-28
 * match: "" at positions 30-29
 * match: "" at positions 31-30
 * match: "" at positions 32-31
 * regex: "S*"
 * match: "" at positions 0--1
 * match: "" at positions 1-0
 * match: "" at positions 2-1
 * match: "" at positions 3-2
 * match: "" at positions 4-3
 * match: "" at positions 5-4
 * match: "" at positions 6-5
 * match: "" at positions 7-6
 * match: "" at positions 8-7
 * match: "" at positions 9-8
 * match: "" at positions 10-9
 * match: "" at positions 11-10
 * match: "" at positions 12-11
 * match: "" at positions 13-12
 * match: "" at positions 14-13
 * match: "" at positions 15-14
 * match: "" at positions 16-15
 * match: "" at positions 17-16
 * match: "" at positions 18-17
 * match: "" at positions 19-18
 * match: "" at positions 20-19
 * match: "" at positions 21-20
 * match: "" at positions 22-21
 * match: "" at positions 23-22
 * match: "" at positions 24-23
 * match: "" at positions 25-24
 * match: "" at positions 26-25
 * match: "" at positions 27-26
 * match: "" at positions 28-27
 * match: "" at positions 29-28
 * match: "" at positions 30-29
 * match: "" at positions 31-30
 * match: "" at positions 32-31
 * regex: "S+"
 * regex: "s{4}"
 * regex: "s{1}"
 * match: "s" at positions 11-11
 * match: "s" at positions 26-26
 * match: "s" at positions 27-27
 * match: "s" at positions 31-31
 * regex: "s{0,3}"
 * match: "" at positions 0--1
 * match: "" at positions 1-0
 * match: "" at positions 2-1
 * match: "" at positions 3-2
 * match: "" at positions 4-3
 * match: "" at positions 5-4
 * match: "" at positions 6-5
 * match: "" at positions 7-6
 * match: "" at positions 8-7
 * match: "" at positions 9-8
 * match: "" at positions 10-9
 * match: "s" at positions 11-11
 * match: "" at positions 12-11
 * match: "" at positions 13-12
 * match: "" at positions 14-13
 * match: "" at positions 15-14
 * match: "" at positions 16-15
 * match: "" at positions 17-16
 * match: "" at positions 18-17
 * match: "" at positions 19-18
 * match: "" at positions 20-19
 * match: "" at positions 21-20
 * match: "" at positions 22-21
 * match: "" at positions 23-22
 * match: "" at positions 24-23
 * match: "" at positions 25-24
 * match: "ss" at positions 26-27
 * match: "" at positions 28-27
 * match: "" at positions 29-28
 * match: "" at positions 30-29
 * match: "s" at positions 31-31
 * match: "" at positions 32-31
 */