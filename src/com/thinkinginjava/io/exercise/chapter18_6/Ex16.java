package com.thinkinginjava.io.exercise.chapter18_6;

import com.thinkinginjava.io.example.chapter18_6.ex18_6_6.UsingRandomAccessFile;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description: page 545
 * 练习16：在JDK文档中查找RandomAccessFile，以{@link UsingRandomAccessFile}为基础,
 * 创建一个程序，它可以存储然后获取RandomAccessFile类能够提供的所有不同的类型。验证
 * 它可以准确地存储和获取各个值。
 */
public class Ex16 {
    static String file = "src\\com\\thinkinginjava\\io\\exercise\\chapter18_6\\file\\Ex16.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        System.out.println(String.format("rf.readFloat(): %s", rf.readFloat()));
        System.out.println(String.format("rf.readDouble(): %s", rf.readDouble()));
        System.out.println(String.format("rf.readInt(): %s", rf.readInt()));
        System.out.println(String.format("rf.readLong(): %s", rf.readLong()));
        System.out.println(String.format("rf.readByte(): %s", rf.readByte()));
        System.out.println(String.format("rf.readBoolean(): %s", rf.readBoolean()));
        System.out.println(String.format("rf.readChar(): %s", rf.readChar()));
        System.out.println(String.format("rf.readShort(): %s", rf.readShort()));
        System.out.println(String.format("rf.readUTF(): %s", rf.readUTF()));
        System.out.println();
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        rf.writeFloat(1.0f);
        rf.writeDouble(1.414);
        rf.writeInt(1);
        rf.writeLong(2L);
        rf.writeByte((byte)3);
        rf.writeBoolean(true);
        rf.writeChar('a');
        rf.writeShort(4);
        rf.writeUTF("The end of the file");
        rf.close();

        display();
    }
}
/**output:
 * rf.readFloat(): 1.0
 * rf.readDouble(): 1.414
 * rf.readInt(): 1
 * rf.readLong(): 2
 * rf.readByte(): 3
 * rf.readBoolean(): true
 * rf.readChar(): a
 * rf.readShort(): 4
 * rf.readUTF(): The end of the file
 */