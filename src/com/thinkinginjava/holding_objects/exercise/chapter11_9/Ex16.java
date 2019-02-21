package com.thinkinginjava.holding_objects.exercise.chapter11_9;

import com.thinkinginjava.util.TextFile;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: monika
 * @Date: 2018/12/16 12:05
 * @Version: 1.0
 * @Description: page 233
 * 练习15：创建一个元音字母Set。对UniqueWords.java操作，计数并显示在每一个输入
 * 单词中的元音字母数量，并显示输入文件中的所有元音字母的数量总和。
 */
public class Ex16 {
    static void vowelCounter(Set<String> st) {
        Set<Character> vowels = new TreeSet<Character>();
        Collections.addAll(vowels,
                'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        int allVowels = 0;
        for(String s : st) {
            int count = 0;
            for(Character v : s.toCharArray()) {
                if(vowels.contains(v)) {
                    count++;
                    allVowels++;
                }
            }
            System.out.print(s + ": " + count + ", ");
        }
        System.out.println();
        System.out.print("Total vowels: " + allVowels);
    }
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(
                new TextFile("src\\com\\thinkinginjava\\holding_objects\\example\\chapter11_9\\SetOperations.java", "\\W+"));
        System.out.println(words);
        System.out.println();
        vowelCounter(words);
    }
}
/**输出：
 * [A, B, C, Collections, D, E, F, G, H, HashSet, I, J, K, L, M, N, Output, Set, SetOperations, String, System, X, Y, Z, add, addAll, added, args, chapter11_9, class, com, contains, containsAll, example, false, from, holding_objects, import, in, java, main, new, out, package, println, public, remove, removeAll, removed, set1, set2, split, static, thinkinginjava, to, true, util, void]
 *
 * A: 1, B: 0, C: 0, Collections: 4, D: 0, E: 1, F: 0, G: 0, H: 0, HashSet: 2, I: 1, J: 0, K: 0, L: 0, M: 0, N: 0, Output: 3, Set: 1, SetOperations: 6, String: 1, System: 1, X: 0, Y: 0, Z: 0, add: 1, addAll: 2, added: 2, args: 1, chapter11_9: 2, class: 1, com: 1, contains: 3, containsAll: 4, example: 3, false: 2, from: 1, holding_objects: 4, import: 2, in: 1, java: 2, main: 2, new: 1, out: 2, package: 3, println: 1, public: 2, remove: 3, removeAll: 4, removed: 3, set1: 1, set2: 1, split: 1, static: 2, thinkinginjava: 5, to: 1, true: 2, util: 2, void: 2,
 * Total vowels: 91
 */