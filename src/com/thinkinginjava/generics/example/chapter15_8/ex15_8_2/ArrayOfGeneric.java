package com.thinkinginjava.generics.example.chapter15_8.ex15_8_2;

public class ArrayOfGeneric {
  static final int SIZE = 100;
  static Generic<Integer>[] gia;
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    // 运行时异常; 发生ClassCastException:
    //! gia = (Generic<Integer>[])new Object[SIZE];

    // 运行时类型是原始（擦除）类型:
    gia = (Generic<Integer>[])new Generic[SIZE];
    System.out.println(gia.getClass().getSimpleName());

    gia[0] = new Generic<>();
    //! gia[1] = new Object(); // 编译时错误

    // 在编译时发现类型不匹配:
    //! gia[2] = new Generic<Double>();
  }
}
/**Output:
 * Generic[]
 */
