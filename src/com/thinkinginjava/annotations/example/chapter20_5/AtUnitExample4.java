package com.thinkinginjava.annotations.example.chapter20_5;

import com.thinkinginjava.util.atunit.Test;
import com.thinkinginjava.util.atunit.TestObjectCreate;
import com.thinkinginjava.util.atunit.TestProperty;
import static com.thinkinginjava.util.Print.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/18
 * @description:
 */
public class AtUnitExample4 {
    static String theory = "All brontosauruses " +
            "are thin at one end, much MUCH thicker in the " +
            "middle, and then thin again at the far end.";
    private String word;
    private Random rand = new Random();
    public AtUnitExample4(String word) { this.word = word; }
    public String getWord() { return word; }
    public String scrambleWord() {
        List<Character> chars = new ArrayList<>();
        for (Character c : word.toCharArray())
            chars.add(c);
        Collections.shuffle(chars, rand);
        StringBuilder result = new StringBuilder();
        for (char ch : chars)
            result.append(ch);
        return result.toString();
    }

    @TestProperty
    static List<String> input = Arrays.asList(theory.split(" "));
    @TestProperty
    static Iterator<String> words = input.iterator();
    @TestObjectCreate
    static AtUnitExample4 create() {
        if (words.hasNext())
            return new AtUnitExample4(words.next());
        else
            return null;
    }
    @Test boolean words() {
        print("'" + getWord() + "'");
        return getWord().equals("are");
    }
    @Test boolean scramble1() {
        // 更改为特定seed以获得可验证的结果:
        rand = new Random(47);
        print("'" + getWord() + "'");
        String scrambled = scrambleWord();
        print(scrambled);
        return scrambled.equals("lAl");
    }
    @Test boolean scramble2() {
        rand = new Random(74);
        print("'" + getWord() + "'");
        String scrambled = scrambleWord();
        print(scrambled);
        return scrambled.equals("tsaeborornussu");
    }

    public static void main(String[] args) {
        print("starting");
        /**
         * 在cmd命令行中操作
         * cd D:\GithubRepository\myproject\out\production\myproject
         * java com.thinkinginjava.util.atunit.AtUnit com\thinkinginjava\annotations\example\chapter20_5\AtUnitExample4
         */
    }
}
/**output:
 * starting
 * com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample4
 *   . words 'All'
 * (failed)
 *   . scramble2 'brontosauruses'
 * tsaeborornussu
 *
 *   . scramble1 'are'
 * rae
 * (failed)
 * (3 tests)
 *
 * >>> 2 FAILURES <<<
 *   com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample4: words
 *   com.thinkinginjava.annotations.example.chapter20_5.AtUnitExample4: scramble1
 */