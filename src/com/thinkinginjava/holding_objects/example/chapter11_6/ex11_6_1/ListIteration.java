package com.thinkinginjava.holding_objects.example.chapter11_6.ex11_6_1;

import com.thinkinginjava.util.pets.*;
import java.util.*;

/**
 * 1.ListIterator是一个更加强大的Iterator的子类型，它只能用于各种List类的访问。尽管
 * Iterator只能向前移动，但是ListIterator可以双向移动。它还可以产生相对于迭代器在列表
 * 中指向的当前位置的前一个和后一个元素的索引，并且可以使用Set()方法替换它访问过的最后一
 * 个元素。
 *
 * 2.可以通过listIterator(index)方法创建一个开始就指向列表索引为index的元素处的ListIterator。
 */
public class ListIteration {
  public static void main(String[] args) {
    List<Pet> pets = Pets.arrayList(8);
    ListIterator<Pet> it = pets.listIterator();
    while(it.hasNext())
      //例如：当前光标的位置在下标为1的位置，那么
      // nextIndex就是当前光标的位置，previousIndex就是当前光标位置-1.
      System.out.print(it.next() + ", " + it.nextIndex() +
        ", " + it.previousIndex() + "; ");
    System.out.println();
    // Backwards:
    while(it.hasPrevious())
      System.out.print(it.previous().id() + " ");
    System.out.println();
    System.out.println(pets);	
    it = pets.listIterator(3);
    while(it.hasNext()) {
      it.next();
      it.set(Pets.randomPet());
    }
    System.out.println(pets);
  }
}
/** Output:
Rat, 1, 0; Manx, 2, 1; Cymric, 3, 2; Mutt, 4, 3; Pug, 5, 4; Cymric, 6, 5; Pug, 7, 6; Manx, 8, 7;
7 6 5 4 3 2 1 0
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
[Rat, Manx, Cymric, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau]
*///:~
