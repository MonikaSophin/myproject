package com.thinkinginjava.reusing_classes.exercise.chapter7_8;

import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/11/17 19:33
 * @Version: 1.0
 * @Description: page 142
 * 练习18：
 */
class Test {
    Test(String name ) { System.out.println(name+" Test()"); }
}

class Difference {
    private String name;
    public Difference(String s) { name = s;  }
    static final Test sft = new Test("static_final"); // constant reference address
    private final Test ft = new Test("final");
    static final String SFS = "static final"; // class constant
    private final String fs = "final";
    private static Random rand = new Random();
    static final int SFI = rand.nextInt(); // class constant
    private final int fi = rand.nextInt();
    public String toString() {
        return (name + ": " + sft + ", " + ft + ", " + SFS + ", " + fs + ", " + SFI + ", " + fi);
    }

}

public class Ex18 {
    public static void main(String[] args) {
        Difference d1 = new Difference("d1");
        Difference d2 = new Difference("d2");
        Difference d3 = new Difference("d3");
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
    }
}
/**输出：
 * static_final Test()
 * final Test()
 * final Test()
 * final Test()
 * d1: com.thinkinginjava.reusing_classes.exercise.chapter7_8.Test@74a14482, com.thinkinginjava.reusing_classes.exercise.chapter7_8.Test@1540e19d, static final, final, -555631269, -1676152017
 * d2: com.thinkinginjava.reusing_classes.exercise.chapter7_8.Test@74a14482, com.thinkinginjava.reusing_classes.exercise.chapter7_8.Test@677327b6, static final, final, -555631269, -1756317122
 * d3: com.thinkinginjava.reusing_classes.exercise.chapter7_8.Test@74a14482, com.thinkinginjava.reusing_classes.exercise.chapter7_8.Test@14ae5a5, static final, final, -555631269, -1276652932
 */