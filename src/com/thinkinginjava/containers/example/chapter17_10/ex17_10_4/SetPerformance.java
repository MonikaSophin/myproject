package com.thinkinginjava.containers.example.chapter17_10.ex17_10_4;

import com.thinkinginjava.containers.example.chapter17_10.ex17_10_1.Test;
import com.thinkinginjava.containers.example.chapter17_10.ex17_10_1.TestParam;
import com.thinkinginjava.containers.example.chapter17_10.ex17_10_1.Tester;

import java.util.*;

public class SetPerformance {
  static List<Test<Set<Integer>>> tests = new ArrayList<>();
  static {
    tests.add(new Test<Set<Integer>>("add") {
      public int test(Set<Integer> set, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for(int i = 0; i < loops; i++) {
          set.clear();
          for(int j = 0; j < size; j++)
            set.add(j);
        }
        return loops * size;
      }
    });
    tests.add(new Test<Set<Integer>>("contains") {
      public int test(Set<Integer> set, TestParam tp) {
        int loops = tp.loops;
        int span = tp.size * 2;
        for(int i = 0; i < loops; i++)
          for(int j = 0; j < span; j++)
            set.contains(j);
        return loops * span;
      }
    });
    tests.add(new Test<Set<Integer>>("iterate") {
      public int test(Set<Integer> set, TestParam tp) {
        int loops = tp.loops * 10;
        for(int i = 0; i < loops; i++) {
          Iterator<Integer> it = set.iterator();
          while(it.hasNext())
            it.next();
        }
        return loops * set.size();
      }
    });
  }
  public static void main(String[] args) {
    if(args.length > 0)
      Tester.defaultParams = TestParam.array(args);
    Tester.fieldWidth = 10;
    Tester.run(new TreeSet<>(), tests);
    Tester.run(new HashSet<>(), tests);
    Tester.run(new LinkedHashSet<>(), tests);
  }
}
/**output:
 * ------------- TreeSet -------------
 *  size       add  contains   iterate
 *    10       202        92        31
 *   100        43        17         4
 *  1000        44        37         4
 * 10000        54        51         4
 * ------------- HashSet -------------
 *  size       add  contains   iterate
 *    10        68        67        33
 *   100        11         2         4
 *  1000        11         3         4
 * 10000        12         4         4
 * ---------- LinkedHashSet ----------
 *  size       add  contains   iterate
 *    10        93        24        10
 *   100        17         6         5
 *  1000        28        10         4
 * 10000        18         7         4
 */