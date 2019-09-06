package com.monika.io.rw_primary;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author XueYing.Cao
 * @date 2019/9/6
 * 类作用：读写基本数据类型
 * 基本数据流：DataInputStream、DataOutputStream
 */
public class ReadWritePrimaryData {

    public static void main(String[] args) {

        String fileOutName = "D:/GithubRepository/myproject/src/com/monika/io/rw_primary/test_output";
        try(
                //基本数据输入流
                FileOutputStream fos = new FileOutputStream(fileOutName);
                DataOutputStream dos = new DataOutputStream(fos);
                //基本数据输出流
                FileInputStream fis = new FileInputStream(fileOutName);
                DataInputStream dis = new DataInputStream(fis)
        ) {
            byte b = 1;
            char c = 'a';
            short s = 1;
            int i = 1;
            long l = 11L;
            float f = 1.0F;
            double d = 1.11;
            boolean bool = true;
            String str = "hello!";

            //写入基本数据类型
            dos.writeByte(b);
            dos.writeChar(c);
            dos.writeShort(s);
            dos.writeInt(i);
            dos.writeLong(l);
            dos.writeFloat(f);
            dos.writeDouble(d);
            dos.writeBoolean(bool);
            //写入字符串
            dos.writeUTF(str);
            dos.flush();

            //读取基本数据类型
            System.out.println("readByte() : " + dis.readByte());
            System.out.println("readChar() : " + dis.readChar());
            System.out.println("readShort() : " + dis.readShort());
            System.out.println("readInt() : " + dis.readInt());
            System.out.println("readLong() : " + dis.readLong());
            System.out.println("readFloat() : " + dis.readFloat());
            System.out.println("readDouble() : " + dis.readDouble());
            System.out.println("readBoolean() : " + dis.readBoolean());
            //读取字符串
            System.out.println("readUTF() : " + dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**output:
 * readByte() : 1
 * readChar() : a
 * readShort() : 1
 * readInt() : 1
 * readLong() : 11
 * readFloat() : 1.0
 * readDouble() : 1.11
 * readBoolean() : true
 * readUTF() : hello!
 */