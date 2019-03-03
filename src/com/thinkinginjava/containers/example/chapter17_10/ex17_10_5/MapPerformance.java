package com.thinkinginjava.containers.example.chapter17_10.ex17_10_5;

import com.thinkinginjava.containers.example.chapter17_10.ex17_10_1.Test;
import com.thinkinginjava.containers.example.chapter17_10.ex17_10_1.TestParam;
import com.thinkinginjava.containers.example.chapter17_10.ex17_10_1.Tester;

import java.util.*;

public class MapPerformance {
  static List<Test<Map<Integer,Integer>>> tests = new ArrayList<>();
  static {
    tests.add(new Test<Map<Integer,Integer>>("put") {
      public int test(Map<Integer,Integer> map, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for(int i = 0; i < loops; i++) {
          map.clear();
          for(int j = 0; j < size; j++)
            map.put(j, j);
        }
        return loops * size;
      }
    });
    tests.add(new Test<Map<Integer,Integer>>("get") {
      public int test(Map<Integer,Integer> map, TestParam tp) {
        int loops = tp.loops;
        int span = tp.size * 2;
        for(int i = 0; i < loops; i++)
          for(int j = 0; j < span; j++)
            map.get(j);
        return loops * span;
      }
    });
    tests.add(new Test<Map<Integer,Integer>>("iterate") {
      public int test(Map<Integer,Integer> map, TestParam tp) {
        int loops = tp.loops * 10;
        for(int i = 0; i < loops; i ++) {
          Iterator it = map.entrySet().iterator();
          while(it.hasNext())
            it.next();
        }
        return loops * map.size();
      }
    });
  }
  public static void main(String[] args) {
    if(args.length > 0)
      Tester.defaultParams = TestParam.array(args);
    Tester.run(new TreeMap<>(), tests);
    Tester.run(new HashMap<>(), tests);
    Tester.run(new LinkedHashMap<>(),tests);
    Tester.run(
      new IdentityHashMap<>(), tests);
    Tester.run(new WeakHashMap<>(), tests);
    Tester.run(new Hashtable<>(), tests);
  }
}
/**output:
 * ---------- TreeMap ----------
 *  size     put     get iterate
 *    10     172      70      15
 *   100      36      18       3
 *  1000      47      36       4
 * 10000      62      49       6
 * ---------- HashMap ----------
 *  size     put     get iterate
 *    10      73      43      16
 *   100       7       2       4
 *  1000      18       9       4
 * 10000      10       4       5
 * ------- LinkedHashMap -------
 *  size     put     get iterate
 *    10      89      23       9
 *   100      16       6       4
 *  1000      25       7       4
 * 10000      18       9       4
 * ------ IdentityHashMap ------
 *  size     put     get iterate
 *    10      64      20      15
 *   100      15      15       9
 *  1000      45      41      11
 * 10000      50      51      14
 * -------- WeakHashMap --------
 *  size     put     get iterate
 *    10      77      22      23
 *   100      52      15      16
 *  1000      27       7       9
 * 10000      16       8      69
 * --------- Hashtable ---------
 *  size     put     get iterate
 *    10      45      18      11
 *   100      21      14      10
 *  1000      30      20       6
 * 10000      28      19       6
 */