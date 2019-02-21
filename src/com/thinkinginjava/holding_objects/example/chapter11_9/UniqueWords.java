package com.thinkinginjava.holding_objects.example.chapter11_9;
import com.thinkinginjava.util.TextFile;
import java.util.*;

public class UniqueWords {
  public static void main(String[] args) {
    Set<String> words = new TreeSet<String>(
      new TextFile("src\\com\\thinkinginjava\\holding_objects\\example\\chapter11_9\\SetOperations.java", "\\W+"));
    System.out.println(words);
  }
}
/** Output:
[A, B, C, Collections, D, E, F, G, H, HashSet, I, J, K, L, M, N, Output, Print, Set, SetOperations, String, X, Y, Z, add, addAll, added, args, class, contains, containsAll, false, from, holding, import, in, java, main, mindview, net, new, print, public, remove, removeAll, removed, set1, set2, split, static, to, true, util, void]
*///:~
