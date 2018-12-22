package com.thinkinginjava.holding_objects.example.chapter11_1;
import java.util.*;

class Apple {
  private static long counter;
  private final long id = counter++;
  public long id() { return id; }
}

class Orange {}	

public class ApplesAndOrangesWithoutGenerics {
  /**
   * 1.这里的@SuppressWarnings注解及其参数表示只有有关“不受检查的异常”的警告信息应该被抑制。
   */
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    ArrayList apples = new ArrayList();
    for(int i = 0; i < 3; i++)
      apples.add(new Apple());
    // Not prevented from adding an Orange to apples:
    apples.add(new Orange());
    for(int i = 0; i < apples.size(); i++)
      ((Apple)apples.get(i)).id();
      // Orange is detected only at run time
  }
}
/** 输出：
 * (Execute to see output)
 *  类型转换异常：Orange cannot be cast to Apple
 */
