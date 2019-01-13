package com.thinkinginjava.string.exercise.chapter13_6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/13 12:10
 * @Version: 1.0
 * @Description: page 304
 * 练习13：修改StartEnd.java,让它使用Groups.POEM为输入，必要时修改正则表达式，
 * 使find()、lookingAt()、matches()都有机会匹配成功。
 */
public class Ex13 {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        //(?m)为开头的模式标记。
        Pattern p = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$");
        for (String in : POEM.split("\n")) {
            Matcher m = p.matcher(in);
            while (m.find())
                System.out.println("find() '" + m.group() + "' start = " +
                        m.start() + " end = " + m.end());
            if (m.lookingAt())
                System.out.println("lookingAt() start = " + m.start() +
                        " end = " + m.end());
            if (m.matches())
                System.out.println("matches() start = " + m.start() +
                        " end = " + m.end());
        }
    }
}
/**output:
 * find() 'the slithy toves' start = 18 end = 34
 * find() 'in the wabe.' start = 20 end = 32
 * find() 'were the borogoves,' start = 10 end = 29
 * find() 'mome raths outgrabe.' start = 8 end = 28
 * find() 'Jabberwock, my son,' start = 11 end = 30
 * find() 'claws that catch.' start = 24 end = 41
 * find() 'bird, and shun' start = 18 end = 32
 * find() 'The frumious Bandersnatch.' start = 0 end = 26
 * lookingAt() start = 0 end = 26
 * matches() start = 0 end = 26
 */