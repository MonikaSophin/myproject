package com.thinkinginjava.type_information.exercise.chapter14_2;

/**
 * @Author: monika
 * @Date: 2019/1/25 21:54
 * @Version: 1.0
 * @Description: page 318
 * 练习07：修改SweetShop.java，使每种类型对象的创建由命令行参数控制。即，如果命令行
 * 是“java SweetShop Candy”，那么只有Candy对象被创建。注意你是如何通过命令行参数
 * 来控制加载哪个Class对象的。
 */
class Candy {
    static { System.out.println("Loading Candy"); }
}

class Gum {
    static { System.out.println("Loading Gum"); }
}

class Cookie {
    static { System.out.println("Loading Cookie"); }
}

public class Ex07 {
    public static void main(String[] args) {
        System.out.println("inside main");
        if(args.length < 1) {
            System.out.println("Usage: sweetName");
            System.exit(0);
        }
        Class c = null;
        try {
            c = Class.forName(args[0]);
            System.out.println("Enjoy your " + args[0]);
        } catch(ClassNotFoundException e) {
            System.out.println("Couldn't find " + args[0]);
        }
    }
}
/**output:
 * inside main
 * Enjoy your Candy
 */