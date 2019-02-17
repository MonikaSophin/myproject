package com.thinkinginjava.generics.example.chapter15_11.ex15_11_5;

/**
 * @Author: monika
 * @Date: 2019/2/16 19:51
 * @Version: 1.0
 * @Description:
 */
public class ComparablePet implements Comparable<ComparablePet>{
    @Override
    public int compareTo(ComparablePet o) { return 0; }
}

/**
 * 错误：Comparable不能继承不同的参数<Cat>和<Pet>
 */
// public class Cat extends ComparablePet implements ComparablePet<Cat> { }

class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) { return 0; }
}

class Gecko extends ComparablePet {
    @Override
    public int compareTo(ComparablePet o) { return 0; }
}
