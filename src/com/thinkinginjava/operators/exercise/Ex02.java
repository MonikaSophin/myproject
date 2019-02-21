package com.thinkinginjava.operators.exercise;

import com.thinkinginjava.util.Print;

/**page 40
 *
 * 创建一个包含float域的类，并用这个类展示别名机制。
 */
class Level{
    float level;
}

public class Ex02 {
    public static void main(String[] args) {
        Level t1 = new Level();
        Level t2 = new Level();

        t1.level = 9.0F;
        t2.level = 47.0F;
        Print.print("1:对象引用:"+
                "  t1 >>"+t1+
                "  t2 >>"+t2);
        Print.print("1: t1.level = "+t1.level+
                ", t2.level = "+t2.level);

        t1 = t2;//引用t1与t2是相同的引用指向都是t2对象。
        Print.print("2:对象引用:"+
                "  t1 >>"+t1+
                "  t2 >>"+t2);
        Print.print("2: t1.level = "+t1.level+
                ", t2.level = "+t2.level);

        t1.level = 27;//操作引用t1，其实就是操作t2对象
        Print.print("3:对象引用:"+
                "  t1 >>"+t1+
                "  t2 >>"+t2);
        Print.print("3: t1.level = "+t1.level+
                ", t2.level = "+t2.level);
    }
}
