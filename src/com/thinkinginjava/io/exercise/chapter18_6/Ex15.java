package com.thinkinginjava.io.exercise.chapter18_6;

import com.thinkinginjava.io.example.chapter18_6.ex18_6_5.StoringAndRecoveringData;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description: page 544
 * 练习15：在JDK文档中查找{@link DataInputStream}和{@link DataOutputStream}，以
 * {@link StoringAndRecoveringData}为基础，创建一个程序，它可以存储然后获取DataOutputStream
 * 和DataInputStream类能够提供的所有不同的类型。验证它可以准确地存储和获取各个值。
 */
public class Ex15 {
    public static void main(String[] args) throws IOException {
        String filePath = "src\\com\\thinkinginjava\\io\\exercise\\chapter18_6\\file\\Ex15.txt";
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filePath)));
        out.writeUTF("That was pi");
        out.writeBoolean(true);
        out.writeByte(1);
        out.writeFloat(1.0f);
        out.writeDouble(3.14159);
        out.writeInt(1);
        out.writeChar('A');
        out.writeShort(1);
        out.writeLong(1L);
        out.close();

        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filePath)));
        System.out.println(String.format("in.readUTF(): %s", in.readUTF()));
        System.out.println(String.format("in.readBoolean(): %s", in.readBoolean()));
        System.out.println(String.format("in.readByte(): %s", in.readByte()));
        System.out.println(String.format("in.readFloat(): %s", in.readFloat()));
        System.out.println(String.format("in.readDouble(): %s", in.readDouble()));
        System.out.println(String.format("in.readInt(): %s", in.readInt()));
        System.out.println(String.format("in.readChar(): %s", in.readChar()));
        System.out.println(String.format("in.readShort(): %s", in.readShort()));
        System.out.println(String.format("in.readLong(): %s", in.readLong()));
    }
}
/**output:
 * in.readUTF(): That was pi
 * in.readBoolean(): true
 * in.readByte(): 1
 * in.readFloat(): 1.0
 * in.readDouble(): 3.14159
 * in.readInt(): 1
 * in.readChar(): A
 * in.readShort(): 1
 * in.readLong(): 1
 */
