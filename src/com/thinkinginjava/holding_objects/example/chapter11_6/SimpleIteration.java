package com.thinkinginjava.holding_objects.example.chapter11_6;

import com.thinkinginjava.util.pets.Pet;
import com.thinkinginjava.util.pets.Pets;
import java.util.Iterator;
import java.util.List;

/**
 * 1.迭代器模式。迭代器是一个对象，它的工作是遍历并选择序列中的对象。
 * 2.java的Iterator只能单向（正向）移动，
 *   1）使用方法iterator()要求容器返回一个Iterator。Iterator将准备好返回序列的第一个元素。
 *   2）使用next()获得序列中的下一个元素。
 *   3）使用hasNext()检查序列中是否还有元素。
 *   4）使用remove()将迭代器新进返回的元素删除。
 *   5）Iterator还可以移除有next()产生的最后一个元素，这意味着在调用remove()之前必须先调用next()。
 */
public class SimpleIteration {
  public static void main(String[] args) {
    List<Pet> pets = Pets.arrayList(12);
    Iterator<Pet> it = pets.iterator();
    while(it.hasNext()) {
      Pet p = it.next();
      System.out.print(p.id() + ":" + p + " ");
    }
    System.out.println();
    // A simpler approach, when possible:
    for(Pet p : pets)
      System.out.print(p.id() + ":" + p + " ");
    System.out.println();	
    // An Iterator can also remove elements:
    it = pets.iterator();
    for(int i = 0; i < 6; i++) {
      it.next();
      it.remove();
    }
    System.out.println(pets);
  }
}
/** Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 8:Cymric 9:Rat 10:EgyptianMau 11:Hamster
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 8:Cymric 9:Rat 10:EgyptianMau 11:Hamster
[Pug, Manx, Cymric, Rat, EgyptianMau, Hamster]
*///:~
