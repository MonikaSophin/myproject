package com.thinkinginjava.io.example.chapter18_12.ex18_12_2;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/19
 * @description:
 */
class Blip1 implements Externalizable {
    public Blip1() {
        print("Blip1 Constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip1.writeExternal");
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2() {
        print("Blip2 Constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip2.writeExternal");
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip2.readExternal");
    }
}

public class Blips {
    private static String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_12\\file\\Blips.out";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(filePath));
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filePath));
        print("Recovering b1:");
        b1 = (Blip1) in.readObject();

        //!运行异常：InvalidClassException 没有有效的构造器（没有默认构造器）
       //! print("Recovering b2:");
       //! b2 = (Blip2) in.readObject();
    }
}
/**output:
 * Constructing objects:
 * Blip1 Constructor
 * Blip2 Constructor
 * Saving objects:
 * Blip1.writeExternal
 * Blip2.writeExternal
 * Recovering b1:
 * Blip1 Constructor
 * Blip1.readExternal
 */