package com.thinkinginjava.containers.example.chapter17_10.ex17_10_2;

import com.thinkinginjava.containers.example.chapter17_10.ex17_10_1.Test;
import com.thinkinginjava.containers.example.chapter17_10.ex17_10_1.TestParam;
import com.thinkinginjava.containers.example.chapter17_10.ex17_10_1.Tester;
import com.thinkinginjava.util.CountingGenerator;
import com.thinkinginjava.util.CountingIntegerList;
import com.thinkinginjava.util.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

public class ListPerformance {
  static Random rand = new Random();
  static int reps = 1000;
  static List<Test<List<Integer>>> tests = new ArrayList<>();
  static List<Test<LinkedList<Integer>>> qTests = new ArrayList<>();
  static {
    tests.add( new Test<List<Integer>>("add") {
      public int test(List<Integer> list, TestParam tp) {
        int loops = tp.loops;
        int listSize = tp.size;
        for(int i = 0; i < loops; i++) {
          list.clear();
          for(int j = 0; j < listSize; j++)
            list.add(j);
        }
        return loops * listSize;
      }
    });
    tests.add(new Test<List<Integer>>("get") {
      public int test(List<Integer> list, TestParam tp) {
        int loops = tp.loops * reps;
        int listSize = list.size();
        for(int i = 0; i < loops; i++)
          list.get(rand.nextInt(listSize));
        return loops;
      }
    });
    tests.add(new Test<List<Integer>>("set") {
      public int test(List<Integer> list, TestParam tp) {
        int loops = tp.loops * reps;
        int listSize = list.size();
        for(int i = 0; i < loops; i++)
          list.set(rand.nextInt(listSize), 47);
        return loops;
      }
    });
    tests.add(new Test<List<Integer>>("iteradd") {
      public int test(List<Integer> list, TestParam tp) {
        final int LOOPS = 1000000;
        int half = list.size() / 2;
        ListIterator<Integer> it = list.listIterator(half);
        for(int i = 0; i < LOOPS; i++)
          it.add(47);
        return LOOPS;
      }
    });
    tests.add(new Test<List<Integer>>("insert") {
      public int test(List<Integer> list, TestParam tp) {
        int loops = tp.loops;
        for(int i = 0; i < loops; i++)
          list.add(5, 47); // Minimize random-access cost
        return loops;
      }
    });
    tests.add(new Test<List<Integer>>("remove") {
      public int test(List<Integer> list, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for(int i = 0; i < loops; i++) {
          list.clear();
          list.addAll(new CountingIntegerList(size));
          while(list.size() > 5)
            list.remove(5); // Minimize random-access cost
        }
        return loops * size;
      }
    });
    // Tests for queue behavior:
    qTests.add(new Test<LinkedList<Integer>>("addFirst") {
      public int test(LinkedList<Integer> list, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for(int i = 0; i < loops; i++) {
          list.clear();
          for(int j = 0; j < size; j++)
            list.addFirst(47);
        }
        return loops * size;
      }
    });
    qTests.add(new Test<LinkedList<Integer>>("addLast") {
      public int test(LinkedList<Integer> list, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for(int i = 0; i < loops; i++) {
          list.clear();
          for(int j = 0; j < size; j++)
            list.addLast(47);
        }
        return loops * size;
      }
    });
    qTests.add(new Test<LinkedList<Integer>>("rmFirst") {
      public int test(LinkedList<Integer> list, TestParam tp) {
          int loops = tp.loops;
          int size = tp.size;
          for(int i = 0; i < loops; i++) {
            list.clear();
            list.addAll(new CountingIntegerList(size));
            while(list.size() > 0)
              list.removeFirst();
          }
          return loops * size;
        }
      });
    qTests.add(new Test<LinkedList<Integer>>("rmLast") {
      public int test(LinkedList<Integer> list, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for(int i = 0; i < loops; i++) {
          list.clear();
          list.addAll(new CountingIntegerList(size));
          while(list.size() > 0)
            list.removeLast();
        }
        return loops * size;
      }
    });
  }
  static class ListTester extends Tester<List<Integer>> {
    public ListTester(List<Integer> container,
        List<Test<List<Integer>>> tests) {
      super(container, tests);
    }
    // 在每次测试前填充到合适的尺寸:
    @Override
    protected List<Integer> initialize(int size){
      container.clear();
      container.addAll(new CountingIntegerList(size));
      return container;
    }
    // 方便的方法:
    public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
      new ListTester(list, tests).timedTest();
    }
  }
  public static void main(String[] args) {
    if(args.length > 0)
      Tester.defaultParams = TestParam.array(args);
    // 只能在阵列上进行这两个测试:
    Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null, tests.subList(1, 3)){
        // 这将在每次测试之前调用。它生成一个不可调整大小的数组支持列表:
        @Override
        protected List<Integer> initialize(int size) {
          Integer[] ia = Generated.array(Integer.class, new CountingGenerator.Integer(), size);
          return Arrays.asList(ia);
        }
      };
    arrayTest.setHeadline("Array as List");
    arrayTest.timedTest();
    Tester.defaultParams= TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
    if(args.length > 0)
      Tester.defaultParams = TestParam.array(args);
    ListTester.run(new ArrayList<>(), tests);
    ListTester.run(new LinkedList<>(), tests);
    ListTester.run(new Vector<>(), tests);
    Tester.fieldWidth = 12;
    Tester<LinkedList<Integer>> qTest =
      new Tester<>(new LinkedList<>(), qTests);
    qTest.setHeadline("Queue tests");
    qTest.timedTest();
  }
}
/**output:
 * --- Array as List ---
 *  size     get     set
 *    10      11      13
 *   100      10      12
 *  1000      10      14
 * 10000      13      19
 * --------------------- ArrayList ---------------------
 *  size     add     get     set iteradd  insert  remove
 *    10      62      14      18      36     474     192
 *   100      11      13      13      20     501      27
 *  1000      18      14      11      98     277     102
 * 10000       8      14      11     843    1777     917
 * --------------------- LinkedList ---------------------
 *  size     add     get     set iteradd  insert  remove
 *    10      69      23      24      26     147      55
 *   100       7      33      34      10      78      24
 *  1000      10     273     276      59      61      14
 * 10000      12    3088    3027       5      82      15
 * ----------------------- Vector -----------------------
 *  size     add     get     set iteradd  insert  remove
 *    10      67      12      15      20     473      71
 *   100       8      12      15      23     466      21
 *  1000       8      12      16      99     282     107
 * 10000       9      11      13     844    1805     915
 * -------------------- Queue tests --------------------
 *  size    addFirst     addLast     rmFirst      rmLast
 *    10          54          48          63          63
 *   100          12          13          12          13
 *  1000          11          13          18          11
 * 10000           7           7          11          10
 */
