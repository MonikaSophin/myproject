package com.thinkinginjava.holding_objects.exercise.chapter11_10;

import com.thinkinginjava.util.TextFile;
import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/20 21:48
 * @Version: 1.0
 * @Description: page 236
 * 练习22：修改前一个练习，使其用一个包含有一个String域和一个计数域的类来存储每
 * 一个不同的单词，并使用一个由这些对象构成的Set来维护单词列表。
 */
class WordsCount {
    static int totalWords = 0;
    String s;
    int count;

    WordsCount(String s, int count) {
        this.s = s;
        this.count = count;
        totalWords++;
    }

    public String toString() {
        return s + ": " + count;
    }
}

public class Ex22 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(
                new TextFile("src\\com\\thinkinginjava\\holding_objects\\example\\chapter11_9\\SetOperations.java", "\\W+"));
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Words to count, sorted: " + words);

        Set<WordsCount> wordObjects = new HashSet();

        for (String word : words) {
            int count = 0;
            for (String s : words) {
                if (word.equals(s)) count++;
            }
//            for (int i = 0; i < words.size(); i++) {
//                if (word.equals(words.get(i))) count++;
//            }
            WordsCount w = new WordsCount(word, count);
            wordObjects.add(w);
        }

        System.out.println("Word count: " + wordObjects);
        System.out.println("Total words: " + WordsCount.totalWords);
    }
}
/**output:
 * Words to count, sorted: [A, A, A, A, add, addAll, addAll, addAll, added, added, args, B, B, B, B, C, C, C, C, chapter11_9, class, Collections, Collections, Collections, com, contains, contains, containsAll, containsAll, D, D, D, D, E, E, E, E, example, F, F, F, F, false, false, from, from, G, G, G, G, H, H, H, H, H, H, HashSet, HashSet, holding_objects, I, I, I, import, in, in, in, in, J, J, J, java, K, K, K, L, L, L, M, M, M, M, main, N, N, N, new, new, out, out, out, out, out, out, out, Output, package, println, println, println, println, println, println, println, public, public, remove, removeAll, removed, removed, Set, Set, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set1, set2, set2, set2, set2, set2, set2, set2, set2, set2, set2, set2, SetOperations, split, split, split, static, String, String, String, String, String, System, System, System, System, System, System, System, thinkinginjava, to, to, true, true, util, void, X, X, X, X, Y, Y, Y, Y, Z, Z, Z, Z]
 * Word count: [contains: 2, B: 4, C: 4, B: 4, example: 1, F: 4, set1: 23, set2: 11, D: 4, static: 1, set1: 23, set2: 11, System: 7, String: 5, out: 7, D: 4, set1: 23, set1: 23, split: 3, Y: 4, println: 7, System: 7, set2: 11, H: 6, set1: 23, split: 3, true: 2, E: 4, Collections: 3, out: 7, A: 4, B: 4, F: 4, I: 3, set1: 23, M: 4, main: 1, set2: 11, Y: 4, A: 4, set1: 23, B: 4, C: 4, set1: 23, F: 4, N: 3, containsAll: 2, out: 7, set1: 23, set1: 23, set1: 23, X: 4, M: 4, false: 2, println: 7, SetOperations: 1, D: 4, addAll: 3, I: 3, added: 2, String: 5, import: 1, D: 4, C: 4, HashSet: 2, package: 1, System: 7, K: 3, public: 2, println: 7, void: 1, J: 3, in: 4, Z: 4, HashSet: 2, removed: 2, Y: 4, J: 3, addAll: 3, println: 7, from: 2, set1: 23, H: 6, G: 4, class: 1, out: 7, true: 2, E: 4, String: 5, System: 7, set1: 23, split: 3, set1: 23, L: 3, F: 4, set1: 23, set1: 23, in: 4, String: 5, System: 7, set2: 11, X: 4, Y: 4, holding_objects: 1, new: 2, J: 3, set1: 23, new: 2, H: 6, K: 3, set2: 11, Output: 1, G: 4, Collections: 3, in: 4, com: 1, System: 7, L: 3, set1: 23, set2: 11, Set: 2, set2: 11, println: 7, H: 6, H: 6, removed: 2, I: 3, Z: 4, M: 4, Collections: 3, added: 2, java: 1, contains: 2, A: 4, from: 2, N: 3, set1: 23, set1: 23, K: 3, String: 5, public: 2, set1: 23, G: 4, args: 1, C: 4, println: 7, remove: 1, G: 4, Z: 4, M: 4, to: 2, set2: 11, L: 3, Set: 2, X: 4, println: 7, A: 4, chapter11_9: 1, System: 7, set2: 11, N: 3, out: 7, thinkinginjava: 1, out: 7, set1: 23, X: 4, add: 1, set1: 23, in: 4, to: 2, util: 1, E: 4, false: 2, removeAll: 1, addAll: 3, E: 4, H: 6, Z: 4, out: 7, set2: 11, containsAll: 2]
 * Total words: 181
 */