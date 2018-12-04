package com.thinkinginjava.inner_classes.example.chapter10_3;

/**
 *  1.如果你需要生成对外部类对象的引用，可以使用外部类的名字后面紧跟圆点和this（.this）。
 *  这样产生的引用自动地具有正确的类型，这一点在编译期就被知晓并受到检查，因此没有任何运行时
 *  开销。
 */
public class DotThis {
  void f() { System.out.println("DotThis.f()"); }
  public class Inner {
    public DotThis outer() {
      return DotThis.this;//该this指向外部类DoThis
      // A plain "this" would be Inner's "this"
    }
    public Inner inner1() {
      return this;//该this指向是内部类Inner
    }
  }
  public Inner inner() { return new Inner(); }
  public static void main(String[] args) {
    DotThis dt = new DotThis();
    Inner dti = dt.inner();
    // 若在其他位置(不在本类中)创建内部类对象，则使用下面的方式。
    // DotThis.Inner dti = dt.inner();
    dti.outer().f();
  }
}
/** Output:
DotThis.f()
*///:~
