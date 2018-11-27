package com.thinkinginjava.interfaces.example.chapter9_7.ex9_7_1;
import java.util.*;

/**
 * 1.在接口中定义的域不能是“空白final”（被声明为final但又未给定初值的域），但是可以被非常量表达式初始化。
 * 这些域不是接口的一部分，它们的值被存储在该接口的静态存储区域内。
 */
public interface RandVals {
  Random RAND = new Random(47);
  int RANDOM_INT = RAND.nextInt(10);
  long RANDOM_LONG = RAND.nextLong() * 10;
  float RANDOM_FLOAT = RAND.nextLong() * 10;
  double RANDOM_DOUBLE = RAND.nextDouble() * 10;
} ///:~
