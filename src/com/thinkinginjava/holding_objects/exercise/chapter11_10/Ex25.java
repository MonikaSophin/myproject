package com.thinkinginjava.holding_objects.exercise.chapter11_10;

import com.thinkinginjava.holding_objects.example.chapter11_9.TextFile;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/20 22:55
 * @Version: 1.0
 * @Description: 怕个236
 * 练习25：创建一个Map<String,ArrayList<Integer>>,使用TextFile来打开一个
 * 文本文件，并一次读入一个单词（使用“\\W+”作为TextFile构造器的第二个参数）。在
 * 读入单词时对它们进行计数，并且对于文件中的每一个单词，都在ArrayList<Integer>
 * 中记录下与这个词相关联的单词计数。实际上，它记录的是该单词在文件中被发现的位置。
 */
public class Ex25 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> m =
                new LinkedHashMap<>();
        List<String> words = new LinkedList<>();
        words.addAll(new TextFile("src\\com\\thinkinginjava\\holding_objects\\example\\chapter11_9\\SetOperations.java", "\\W+"));
        System.out.println("Words in file: " + words);
        Iterator itWords = words.iterator();
        int count = 0;
        while(itWords.hasNext()) {
            String s = (String)itWords.next();
            count++;
            if(!m.keySet().contains(s)) {
                ArrayList<Integer> ai =
                        new ArrayList<>();
                ai.add(0, count);
                m.put(s, ai);
            }
            else {
                m.get(s).add(count);
                m.put(s, m.get(s));
            }
        }
        System.out.println("Map of word locations: " + m);
    }
}
/**output:
 * Words in file: [package, com, thinkinginjava, holding_objects, example, chapter11_9, import, java, util, public, class, SetOperations, public, static, void, main, String, args, Set, String, set1, new, HashSet, String, Collections, addAll, set1, A, B, C, D, E, F, G, H, I, J, K, L, split, set1, add, M, System, out, println, H, set1, contains, H, System, out, println, N, set1, contains, N, Set, String, set2, new, HashSet, String, Collections, addAll, set2, H, I, J, K, L, split, System, out, println, set2, in, set1, set1, containsAll, set2, set1, remove, H, System, out, println, set1, set1, System, out, println, set2, in, set1, set1, containsAll, set2, set1, removeAll, set2, System, out, println, set2, removed, from, set1, set1, Collections, addAll, set1, X, Y, Z, split, System, out, println, X, Y, Z, added, to, set1, set1, Output, H, true, N, false, set2, in, set1, true, set1, D, K, C, B, L, G, I, M, A, F, J, E, set2, in, set1, false, set2, removed, from, set1, D, C, B, G, M, A, F, E, X, Y, Z, added, to, set1, Z, D, C, B, G, M, A, F, Y, X, E]
 * Map of word locations: {package=[1], com=[2], thinkinginjava=[3], holding_objects=[4], example=[5], chapter11_9=[6], import=[7], java=[8], util=[9], public=[10, 13], class=[11], SetOperations=[12], static=[14], void=[15], main=[16], String=[17, 20, 24, 59, 63], args=[18], Set=[19, 58], set1=[21, 27, 41, 48, 55, 78, 79, 82, 88, 89, 95, 96, 99, 108, 109, 112, 125, 126, 134, 136, 151, 156, 170], new=[22, 61], HashSet=[23, 62], Collections=[25, 64, 110], addAll=[26, 65, 111], A=[28, 145, 162, 177], B=[29, 140, 159, 174], C=[30, 139, 158, 173], D=[31, 137, 157, 172], E=[32, 148, 164, 181], F=[33, 146, 163, 178], G=[34, 142, 160, 175], H=[35, 47, 50, 67, 84, 128], I=[36, 68, 143], J=[37, 69, 147], K=[38, 70, 138], L=[39, 71, 141], split=[40, 72, 116], add=[42], M=[43, 144, 161, 176], System=[44, 51, 73, 85, 90, 102, 117], out=[45, 52, 74, 86, 91, 103, 118], println=[46, 53, 75, 87, 92, 104, 119], contains=[49, 56], N=[54, 57, 130], set2=[60, 66, 76, 81, 93, 98, 101, 105, 132, 149, 153], in=[77, 94, 133, 150], containsAll=[80, 97], remove=[83], removeAll=[100], removed=[106, 154], from=[107, 155], X=[113, 120, 165, 180], Y=[114, 121, 166, 179], Z=[115, 122, 167, 171], added=[123, 168], to=[124, 169], Output=[127], true=[129, 135], false=[131, 152]}
 */