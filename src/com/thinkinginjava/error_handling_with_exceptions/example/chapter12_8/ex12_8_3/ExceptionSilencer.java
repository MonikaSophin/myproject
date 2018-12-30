package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_3;

public class ExceptionSilencer {
  public static void main(String[] args) {
    try {
      throw new RuntimeException();
    } finally {
      //在finally块中使用'return'将使任何抛出的异常不能输出。
      return;
    }
  }
}
/**
 * 结论：如果运行这个程序，就会看到即使抛出了RuntimeException，它也不会产生任何输出。
 */
