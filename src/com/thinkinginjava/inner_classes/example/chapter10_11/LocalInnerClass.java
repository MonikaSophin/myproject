package com.thinkinginjava.inner_classes.example.chapter10_11;

/**
 * 1.除了可以在外围类的内部中创建内部类，也可以在代码块里创建内部类。
 * 其典型的方式是在一个方法体的里面创建。
 *
 * 2.局部内部类不能有访问权限修饰符，因为它不是外围类的一部分，
 * 但是它可以访问当前代码块内的常量，以及此外围类的所有成员。
 *
 * 3..为什么使用局部类而不是匿名内部类呢？
 * 其一，我们需要一个已命名的构造器，或者需要重载构造器，而匿名内部类只能用于实例初始化。
 * 其二，有时需要不止一个该内部类的对象。
 */
interface Counter {
  int next();
}	

public class LocalInnerClass {
  private int count = 0;
  Counter getCounter(final String name) {
    // 局部内部类
    class LocalCounter implements Counter {
      public LocalCounter() {
        // 局部内部类可以有一个构造函数
        System.out.println("LocalCounter()");
      }
      public int next() {
        System.out.println(name); // 访问本地final
        return count++;
      }
    }
    return new LocalCounter();
  }	
  // 匿名内部类
  Counter getCounter2(final String name) {
    return new Counter() {
      // 匿名内部类不能有一个 有命名的构造函数，只能有一个实例初始化程序
      {
        System.out.println("Counter()");
      }
      public int next() {
        System.out.println(name); // 访问本地final
        return count++;
      }
    };
  }	
  public static void main(String[] args) {
    LocalInnerClass lic = new LocalInnerClass();
    Counter
      c1 = lic.getCounter("Local inner "),
      c2 = lic.getCounter2("Anonymous inner ");
    for(int i = 0; i < 5; i++)
      System.out.println(c1.next());
    for(int i = 0; i < 5; i++)
      System.out.println(c2.next());
  }
}
/** Output:
LocalCounter()
Counter()
Local inner 0
Local inner 1
Local inner 2
Local inner 3
Local inner 4
Anonymous inner 5
Anonymous inner 6
Anonymous inner 7
Anonymous inner 8
Anonymous inner 9
*///:~
