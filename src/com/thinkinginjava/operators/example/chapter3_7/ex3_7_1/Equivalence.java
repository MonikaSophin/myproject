package com.thinkinginjava.operators.example.chapter3_7.ex3_7_1;

public class Equivalence {
    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println("n1 == n2 : "+ (n1 == n2));
        System.out.println("n1 != n2 : "+ (n1 != n2));
    }
}
/**输出：
 * n1 == n2 : false
 * n1 != n2 : true
 *
 * 结论： 关系操作符 ==和!=也适用于所有对象。比较的是对象的引用，而不是是对象的内容。
 *    {@link java.lang.Object#equals(java.lang.Object)}与 == 的作用相同。
 *    如果需要比较两个对象的内容，需要覆写equals()方法。
 */