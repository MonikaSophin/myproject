package com.thinkinginjava.reusing_classes.exercise.chapter7_2;

import com.thinkinginjava.reusing_classes.example.chapter7_2.Detergent;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:24
 * @Version: 1.0
 * @Description: page 129
 * 练习02：从Detergent中继承产生一个新的类。覆盖scrub()并添加一个名为sterilize()的新方法。
 */
public class Ex02 extends Detergent {
    @Override
    public void scrub() {
        super.scrub();
        append(" Ex02--scrub()");
    }
    public void sterilize(){
        append(" Ex02--sterilize()");
    }

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        ex02.dilute();
        ex02.apply();
        ex02.scrub();
        ex02.foam();
        ex02.sterilize();
        System.out.println(ex02);
        Detergent.main(args);
    }
}
/**输出：
 * Cleanser dilute() apply() Detergent.scrub() scrub() Ex02--scrub() foam() Ex02--sterilize()
 * Cleanser dilute() apply() Detergent.scrub() scrub() foam()
 * Testing base class:
 * Cleanser dilute() apply() scrub()
 */