package com.thinkinginjava.reusing_classes.example.chapter7_1;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:00
 * @Version: 1.0
 * @Description:  如果想初始化引用，可以在下列位置进行：
 *                1.在定义对象的地方。这意味着它们总是能够在海珠区被调用之前被初始化。
 *                2.在类的构造器中。
 *                3.就在正要使用这些对象之前，这种方式称为惰性初始化。在生成对象不值得以及
 *                不必每次都生成对象的情况下，这种放可以减少额外的负担。
 *                4.使用实例初始化。
 */
class Soap {
    private String s;
    Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }
    public String toString() {
        return s;
    }
}

public class Bath {
    private String //  1.在定义对象的地方。
            s1 = "Happy",
            s2 = "Happy",
            s3, s4;
    private Soap castille;
    private int i;
    private float toy;
    public Bath() { // 2.在类的构造器中。
        System.out.println("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }
    // 4.使用实例初始化。
    {
        i = 47;
    }
    public String toString() {
        if (s4 == null) // 3.惰性初始化
            s4 = "Joy";
        return
                "s1 = " + s1 + "\n" +
                        "s2 = " + s2 + "\n" +
                        "s3 = " + s3 + "\n" +
                        "s4 = " + s4 + "\n" +
                        "i = " + i + "\n" +
                        "toy = " + toy + "\n" +
                        "castille = " + castille;
    }
    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }
}
/**输出：
 * Inside Bath()
 * Soap()
 * s1 = Happy
 * s2 = Happy
 * s3 = Joy
 * s4 = Joy
 * i = 47
 * toy = 3.14
 * castille = Constructed
 */