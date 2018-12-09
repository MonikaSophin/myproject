package com.thinkinginjava.inner_classes.example.chapter10_10;

/**
 * 1.这个例子说明，当继承了某个外围类的时候，内部类并没有发生什么特别神奇的变化。
 * 这两个内部类Yolk是完全独立的两个实体，各自在自己的命名空间内。当然，明确地继承
 * 某个内部类也是可以的，如BigEgg2.java所示。
 */
class Egg {
  private Yolk y;
  protected class Yolk {
    public Yolk() { System.out.println("Egg.Yolk()"); }
  }
  public Egg() {
    System.out.println("New Egg()");
    y = new Yolk();
  }
}	

public class BigEgg extends Egg {
  public class Yolk {
    public Yolk() { System.out.println("BigEgg.Yolk()"); }
  }
  public static void main(String[] args) {
    new BigEgg();
  }
}
/** Output:
New Egg()
Egg.Yolk()
*///:~
