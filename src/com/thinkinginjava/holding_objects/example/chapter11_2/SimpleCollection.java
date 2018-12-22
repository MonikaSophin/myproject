package com.thinkinginjava.holding_objects.example.chapter11_2;
import java.util.*;

/**
 * java容器类类库的用途是“保存对象“，并将其划分为两个不同的概念。
 * 1）Collection。一个独立元素的序列，这些元素都服从一条或多条规则。例如：List必须按照插入
 * 的顺序保存元素，Set不能有重复元素，Queue按照排队规则来确定对象产生的顺序（通常与它们被插
 * 入的顺序相同）。
 *
 * 2）Map。一组成对的“键值对”对象，允许你使用键来查找值。ArrayList允许你使用数字来查找值，
 * 因此从某种意义上讲，它将数字与对象关联在了一起。映射表Map允许我们使用另一个对象来查找某个
 * 对象，它也被称为“关联数组”或是“字典”。
 */
public class SimpleCollection {
  public static void main(String[] args) {
    Collection<Integer> c = new ArrayList<Integer>();
    for(int i = 0; i < 10; i++)
      c.add(i); // Autoboxing
    for(Integer i : c)
      System.out.print(i + ", ");
  }
}
/** Output:
0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
*///:~
