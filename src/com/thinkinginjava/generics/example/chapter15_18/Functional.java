package com.thinkinginjava.generics.example.chapter15_18;//: generics/Functional.java

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// 不同类型的功能对象:
interface Combiner<T> { T combine(T x, T y); }

interface UnaryFunction<R,T> { R function(T x); }

interface Collector<T> extends UnaryFunction<T,T> {
  T result(); // 提取采集参数的结果
}

interface UnaryPredicate<T> { boolean test(T x); }

public class Functional {
  // Extract调用每个元素上的Combiner对象，将其与运行的结果结合起来，最终返回:收集参数的result
  public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
    Iterator<T> it = seq.iterator();
    if(it.hasNext()) {
      T result = it.next();
      while(it.hasNext())
        result = combiner.combine(result, it.next());
      return result;
    }
    // 如果seq是空列表:
    return null; // 或抛出异常
  }
  // 获取一个函数对象，并在列表中的每个对象上调用它，忽略返回值。
  // 函数对象可以作为一个收集参数，因此它在最后被返回。
  public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
    for(T t : seq)
      func.function(t);
    return func;
  }
  // 通过为列表中的每个对象调用函数对象来创建结果列表:
  public static <R,T> List<R> transform(Iterable<T> seq, UnaryFunction<R,T> func) {
    List<R> result = new ArrayList<R>();
    for(T t : seq)
      result.add(func.function(t));
    return result;
  }
  // 将一元谓词应用于序列中的每个项，并返回生成“true”的项列表:
  public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
    List<T> result = new ArrayList<T>();
    for(T t : seq)
      if(pred.test(t))
        result.add(t);
    return result;
  }

  // 为了使用上述通用方法，我们需要创建函数对象来适应我们的特殊需要:
  static class IntegerAdder implements Combiner<Integer> {
    public Integer combine(Integer x, Integer y) {
      return x + y;
    }
  }
  static class IntegerSubtracter implements Combiner<Integer> {
    public Integer combine(Integer x, Integer y) {
      return x - y;
    }
  }
  static class BigDecimalAdder implements Combiner<BigDecimal> {
    public BigDecimal combine(BigDecimal x, BigDecimal y) {
      return x.add(y);
    }
  }
  static class BigIntegerAdder implements Combiner<BigInteger> {
    public BigInteger combine(BigInteger x, BigInteger y) {
      return x.add(y);
    }
  }
  static class AtomicLongAdder implements Combiner<AtomicLong> {
    public AtomicLong combine(AtomicLong x, AtomicLong y) {
      // 不清楚这是否有意义:
      return new AtomicLong(x.addAndGet(y.get()));
    }
  }
  //我们甚至可以用“ulp”(最后一个单位)来实现UnaryFunction:
  static class BigDecimalUlp implements UnaryFunction<BigDecimal,BigDecimal> {
    public BigDecimal function(BigDecimal x) {
      return x.ulp();
    }
  }
  static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
    private T bound;
    public GreaterThan(T bound) { this.bound = bound; }
    public boolean test(T x) {
      return x.compareTo(bound) > 0;
    }
  }
  static class MultiplyingIntegerCollector implements Collector<Integer> {
    private Integer val = 1;
    public Integer function(Integer x) {
      val *= x;
      return val;
    }
    public Integer result() { return val; }
  }

  public static void main(String[] args) {
    // 泛型，varargs和自动装箱机制一起工作:
    List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    Integer result = reduce(li, new IntegerAdder());
    System.out.println(result);

    result = reduce(li, new IntegerSubtracter());
    System.out.println(result);

    System.out.println(filter(li, new GreaterThan<Integer>(4)));

    System.out.println(forEach(li,
      new MultiplyingIntegerCollector()).result());

    System.out.println(forEach(filter(li, new GreaterThan<Integer>(4)),
      new MultiplyingIntegerCollector()).result());

    MathContext mc = new MathContext(7);
    List<BigDecimal> lbd = Arrays.asList(
      new BigDecimal(1.1, mc), new BigDecimal(2.2, mc),
      new BigDecimal(3.3, mc), new BigDecimal(4.4, mc));
    BigDecimal rbd = reduce(lbd, new BigDecimalAdder());
    System.out.println(rbd);

    System.out.println(filter(lbd, new GreaterThan<>(new BigDecimal(3))));

    // 使用BigInteger的prime-generation工具:
    List<BigInteger> lbi = new ArrayList<>();
    BigInteger bi = BigInteger.valueOf(11);
    for(int i = 0; i < 11; i++) {
      lbi.add(bi);
      bi = bi.nextProbablePrime();
    }
    System.out.println(lbi);

    BigInteger rbi = reduce(lbi, new BigIntegerAdder());
    System.out.println(rbi);
    // 这些素数的和也是素数:
    System.out.println(rbi.isProbablePrime(5));

    List<AtomicLong> lal = Arrays.asList(
      new AtomicLong(11), new AtomicLong(47),
      new AtomicLong(74), new AtomicLong(133));
    AtomicLong ral = reduce(lal, new AtomicLongAdder());
    System.out.println(ral);

    System.out.println(transform(lbd,new BigDecimalUlp()));
  }
}
/**Output:
 * 28
 * -26
 * [5, 6, 7]
 * 5040
 * 210
 * 11.000000
 * [3.300000, 4.400000]
 * [11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
 * 311
 * true
 * 265
 * [0.000001, 0.000001, 0.000001, 0.000001]
 */
