package com.thinkinginjava.inner_classes.exercise.chapter10_4.package3;

import com.thinkinginjava.inner_classes.exercise.chapter10_4.package1.Interface1;
import com.thinkinginjava.inner_classes.exercise.chapter10_4.package2.Clazz1;

/**
 * @Author: monika
 * @Date: 2018/12/4 22:19
 * @Version: 1.0
 * @Description:
 */
public class Clazz2 extends Clazz1 {
    public Interface1 getInnerClazz1(){
        return this.new InnerClazz1();
    }
}
