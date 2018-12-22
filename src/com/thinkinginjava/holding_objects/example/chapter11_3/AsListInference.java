package com.thinkinginjava.holding_objects.example.chapter11_3;
import java.util.*;


class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInference {
  public static void main(String[] args) {
    List<Snow> snow1 = Arrays.asList(
      new Crusty(), new Slush(), new Powder());

    /**
     * 1.当试图创建snow2时，Arrays.asList()中只有Power类型，因此它会创建List<Power>
     * 而不是List<Snow>,尽管Collections.addAll()工作的很好，因此它从第一个参数中了解
     * 到了目标类型是什么。
     */
     List<Snow> snow2 = Arrays.asList(
      new Light(), new Heavy());//Snow是Power的基类

    // Collections.addAll() doesn't get confused:
    List<Snow> snow3 = new ArrayList<Snow>();
    Collections.addAll(snow3, new Light(), new Heavy());

    /**
     * 2.可以在Arrays.asList()中间插入一条“线索”，以告诉编译器对于由
     * Arrays.asList()产生的List类型，实际的目标类型应该是什么。这成为
     * 显式的参数说明。
     */
    // Give a hint using an
    // explicit type argument specification:
    List snow4 = Arrays.<Snow>asList(
       new Light(), new Heavy());
  }
} ///:~
