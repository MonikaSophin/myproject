package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_3;

class VeryImportantException extends Exception {
  public String toString() {
    return "VeryImportantException!";
  }
}

class HoHumException extends Exception {
  public String toString() {
    return "HoHumException！";
  }
}

public class LostMessage {
  public void f() throws VeryImportantException { throw new VeryImportantException(); }
  public void dispose() throws HoHumException { throw new HoHumException(); }

  public static void main(String[] args) {
    try {
      LostMessage lm = new LostMessage();
      try {
        lm.f();
      } finally {//f()的异常丢失了
        lm.dispose();
      }
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}
/**Output:
 * HoHumException！
 */
