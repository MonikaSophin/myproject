package com.thinkinginjava.generics.example.chapter15_11.ex15_11_1;

import com.thinkinginjava.util.Generator;
import com.thinkinginjava.util.RandomGenerator;

class FArray {
  public static <T> T[] fill(T[] a, Generator<T> gen) {
    for(int i = 0; i < a.length; i++)
      a[i] = gen.next();
    return a;
  }
}	

public class PrimitiveGenericTest {
  public static void main(String[] args) {
    String[] strings = FArray.fill(
      new String[7], new RandomGenerator.String(10));
    for(String s : strings)
      System.out.println(s);
    Integer[] integers = FArray.fill(
      new Integer[7], new RandomGenerator.Integer());
    for(int i: integers)
      System.out.println(i);
    // 自动包装机制不会在存在这里（自动包装机制不能应用于数组）。这不会编译:
    // int[] b = FArray.fill(new int[7], new RandomGenerator.Integer());
  }
}
/**Output:
 * YNzbrnyGcF
 * OWZnTcQrGs
 * eGZMmJMRoE
 * suEcUOneOE
 * dLsmwHLGEa
 * hKcxrEqUCB
 * bkInaMesbt
 * 7052
 * 6665
 * 2654
 * 3909
 * 5202
 * 2209
 * 5458
 */
