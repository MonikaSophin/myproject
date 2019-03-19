package com.thinkinginjava.io.example.chapter18_12.ex18_12_1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/19
 * @description:
 */
public class FreezeAllen {
    public static void main(String[] args) throws IOException {
        String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_12\\file\\FreezeAllen.file";
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filePath));
        Allen quellek = new Allen();
        out.writeObject(quellek);
    }
}
