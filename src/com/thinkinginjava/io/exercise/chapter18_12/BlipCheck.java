package com.thinkinginjava.io.exercise.chapter18_12;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import static com.thinkinginjava.util.Print.print;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/20
 * @description:
 */
public class BlipCheck implements Externalizable {
    // 如果没有定义构造函数，javac将自动创建默认构造函数，因此不需要:
    // 该构造函数需为public的
//     public BlipCheck() {
//    	print("BlipCheck Constructor");
//     }
    public void writeExternal(ObjectOutput out)
            throws IOException {
        print("BlipCheck writeExternal");
    }
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        print("BlipCheck readExternal");
    }
}
