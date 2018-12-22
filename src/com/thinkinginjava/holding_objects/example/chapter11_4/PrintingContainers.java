package com.thinkinginjava.holding_objects.example.chapter11_4;
import java.util.*;

/**
 * 1.Collection在每个槽中只能保存一个元素。此类容器的一“端”插入对象，并从另外一“端”
 * 一组元素：Set,元素不能重复：Queue.只允许在容器的一“端”插入对象，并从另外一“端”移
 * 除对象（对于本例来说，这只是另外一种观察序列的方式，因此并没有展示它）。Map在每个槽
 * 内保存了两个对象，即键和与之相关联的值。
 *
 * 2.HashMap：与HashSet一样，HashMap也提供了最快的查找技术，也没有按照任何明显的顺序
 * 来保存其元素。TreeMap按照比较结果的升序保存键，而LinkedHashMap则按照插入顺序保存键，
 * 同时还保留了HashMap的查询速度。
 */
public class PrintingContainers {
  static Collection fill(Collection<String> collection) {
    collection.add("rat");
    collection.add("cat");
    collection.add("dog");
    collection.add("dog");
    return collection;
  }
  static Map fill(Map<String,String> map) {
    map.put("rat", "Fuzzy");
    map.put("cat", "Rags");
    map.put("dog", "Bosco");
    map.put("dog", "Spot");
    return map;
  }	
  public static void main(String[] args) {
    System.out.println(fill(new ArrayList<String>()));
    System.out.println(fill(new LinkedList<String>()));
    System.out.println(fill(new HashSet<String>()));
    System.out.println(fill(new TreeSet<String>()));
    System.out.println(fill(new LinkedHashSet<String>()));
    System.out.println(fill(new HashMap<String,String>()));
    System.out.println(fill(new TreeMap<String,String>()));
    System.out.println(fill(new LinkedHashMap<String,String>()));
  }
}
/** Output:
[rat, cat, dog, dog]
[rat, cat, dog, dog]
[dog, cat, rat]
[cat, dog, rat]
[rat, cat, dog]
{dog=Spot, cat=Rags, rat=Fuzzy}
{cat=Rags, dog=Spot, rat=Fuzzy}
{rat=Fuzzy, cat=Rags, dog=Spot}
*/
