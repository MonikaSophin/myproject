package com.thinkinginjava.generics.example.chapter15_2.ex15_2_1;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description:
 */
class TwoTuple<A,B> {
    public final A first;
    public final B second;
    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;
    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }
    @Override
    public String toString() {
        return "ThreeTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;
    public FourTuple(A first, B second, C third, D fourth) {
        super(first, second, third);
        this.fourth = fourth;
    }
    @Override
    public String toString() {
        return "FourTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                '}';
    }
}

class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
    public final E fifth;
    public FiveTuple(A first, B second, C third, D fourth, E fifth) {
        super(first, second, third, fourth);
        this.fifth = fifth;
    }
    @Override
    public String toString() {
        return "FiveTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                ", fifth=" + fifth +
                '}';
    }
}

class Amphibian {}
class Vehicle {}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }
    static ThreeTuple<Amphibian, String, Integer> g(){
        return new ThreeTuple<>(new Amphibian(), "hi", 47);
    }
    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
    }
    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
       //! ttsi.first = "there"; //编译错误：final
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
/**output:
 * TwoTuple{first=hi, second=47}
 * ThreeTuple{first=com.thinkinginjava.generics.example.chapter15_2.ex15_2_1.Amphibian@4554617c, second=hi, third=47}
 * FourTuple{first=com.thinkinginjava.generics.example.chapter15_2.ex15_2_1.Vehicle@74a14482, second=com.thinkinginjava.generics.example.chapter15_2.ex15_2_1.Amphibian@1540e19d, third=hi, fourth=47}
 * FiveTuple{first=com.thinkinginjava.generics.example.chapter15_2.ex15_2_1.Vehicle@677327b6, second=com.thinkinginjava.generics.example.chapter15_2.ex15_2_1.Amphibian@14ae5a5, third=hi, fourth=47, fifth=11.1}
 */