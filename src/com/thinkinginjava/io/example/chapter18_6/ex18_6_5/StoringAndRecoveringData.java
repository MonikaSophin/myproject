package com.thinkinginjava.io.example.chapter18_6.ex18_6_5;

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
 * @description:
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_5\\file\\Data.txt";
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filePath)));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filePath)));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
/**output:
 * 3.14159
 * That was pi
 * 1.41413
 * Square root of 2
 */