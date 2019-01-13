package com.thinkinginjava.string.example.chapter13_6.ex13_6_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/12 18:51
 * @Version: 1.0
 * @Description:
 */
public class TestRegularExpression {
    private static String input() throws IOException {
        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws IOException {
        String string = "abcabcabcdefabc";
        System.out.println("String: \"" + string + "\"");

        while(true){
            System.out.print("input: ");
            String input = input();
            if (input.length() < 2 || input.equalsIgnoreCase("over"))
                return;

            System.out.println("Regular_Expression: \"" + input + "\"");
            Pattern p = Pattern.compile(input);
            Matcher m = p.matcher(string);
            while(m.find()){
                System.out.println("Match: \"" + m.group() + "\" at positions " +
                        m.start() + "-" + (m.end() - 1));
            }
        }
    }
}
/**output:
 * String: "abcabcabcdefabc"
 * input: abcabcabcdefabc
 * Regular_Expression: "abcabcabcdefabc"
 * Match: "abcabcabcdefabc" at positions 0-14
 * input: abc+
 * Regular_Expression: "abc+"
 * Match: "abc" at positions 0-2
 * Match: "abc" at positions 3-5
 * Match: "abc" at positions 6-8
 * Match: "abc" at positions 12-14
 * input: (abc)+
 * Regular_Expression: "(abc)+"
 * Match: "abcabcabc" at positions 0-8
 * Match: "abc" at positions 12-14
 * input: (abc){2,}
 * Regular_Expression: "(abc){2,}"
 * Match: "abcabcabc" at positions 0-8
 * input: over
 *
 */