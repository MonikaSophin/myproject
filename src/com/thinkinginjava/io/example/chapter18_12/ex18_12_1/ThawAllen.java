package com.thinkinginjava.io.example.chapter18_12.ex18_12_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/19
 * @description:
 */
public class ThawAllen {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_12\\file\\FreezeAllen.file";
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filePath));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
/**output:
 * class com.thinkinginjava.io.example.chapter18_12.ex18_12_1.Allen
 */