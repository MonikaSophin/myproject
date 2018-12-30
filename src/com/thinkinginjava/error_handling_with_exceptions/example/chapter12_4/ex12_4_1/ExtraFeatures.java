package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1;

class MyException2 extends Exception {
  private int x;
  public MyException2() {}
  public MyException2(String msg) { super(msg); }
  public MyException2(String msg, int x) {
    super(msg);
    this.x = x;
  }
  public int val() { return x; }
  public String getMessage() {
    return "Detail Message: "+ x + " "+ super.getMessage();
  }
}

public class ExtraFeatures {
  public static void f() throws MyException2 {
    System.out.println("Throwing MyException2 from f()");
    throw new MyException2();
  }
  public static void g() throws MyException2 {
    System.out.println("Throwing MyException2 from g()");
    throw new MyException2("Originated in g()");
  }
  public static void h() throws MyException2 {
    System.out.println("Throwing MyException2 from h()");
    throw new MyException2("Originated in h()", 47);
  }

  public static void main(String[] args) {
    try {
      f();
    } catch(MyException2 e) {
      e.printStackTrace(System.out);
    }
    try {
      g();
    } catch(MyException2 e) {
      e.printStackTrace(System.out);
    }
    try {
      h();
    } catch(MyException2 e) {
      e.printStackTrace(System.out);
      System.out.println("e.val() = " + e.val());
    }
  }
}
/** Output:
 * Throwing MyException2 from f()
 * com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.MyException2: Detail Message: 0 null
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.ExtraFeatures.f(ExtraFeatures.java:20)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.ExtraFeatures.main(ExtraFeatures.java:33)
 * Throwing MyException2 from g()
 * com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.MyException2: Detail Message: 0 Originated in g()
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.ExtraFeatures.g(ExtraFeatures.java:24)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.ExtraFeatures.main(ExtraFeatures.java:38)
 * Throwing MyException2 from h()
 * com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.MyException2: Detail Message: 47 Originated in h()
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.ExtraFeatures.h(ExtraFeatures.java:28)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.ExtraFeatures.main(ExtraFeatures.java:43)
 * e.val() = 47
 */

