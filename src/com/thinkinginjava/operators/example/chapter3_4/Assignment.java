package com.thinkinginjava.operators.example.chapter3_4;

import com.thinkinginjava.operators.example.chapter3_1.Print;

class Tank{
    int level;
}

public class Assignment {
    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();

        t1.level = 9;
        t2.level = 47;
        Print.print("1:对象引用:"+
                "  t1 >>"+t1+
                "  t2 >>"+t2);
        Print.print("1: t1.level = "+t1.level+
                ", t2.level = "+t2.level);

        /**
         *   t1与t2包含的是相同的引用，它们指向相同的对象。(原本t1包含的对对象的引用，是指向一个值为9的对象。
         * 在对t1赋值的时候，这个引用被覆盖，也就是丢失了；而这个不再被引用的对象会由“垃圾回收器”自动清理。)
         *   这种特殊的现象通常被称作“别名现象”，是java操作对象的一种基本方式。在这里，如果想保持两个对象相互独立，
         * 可以这样写，t1.level = t2.level; 这样，引用t1指向就是t1对象，引用t2指向就是t2对象了。
         */
        t1 = t2;
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
/**输出：
 * 1:对象引用:  t1 >>com.thinkinginjava.operators.example.chapter3_4.Tank@4554617c  t2 >>com.thinkinginjava.operators.example.chapter3_4.Tank@74a14482
 * 1: t1.level = 9, t2.level = 47
 * 2:对象引用:  t1 >>com.thinkinginjava.operators.example.chapter3_4.Tank@74a14482  t2 >>com.thinkinginjava.operators.example.chapter3_4.Tank@74a14482
 * 2: t1.level = 47, t2.level = 47
 * 3:对象引用:  t1 >>com.thinkinginjava.operators.example.chapter3_4.Tank@74a14482  t2 >>com.thinkinginjava.operators.example.chapter3_4.Tank@74a14482
 * 3: t1.level = 27, t2.level = 27
 */