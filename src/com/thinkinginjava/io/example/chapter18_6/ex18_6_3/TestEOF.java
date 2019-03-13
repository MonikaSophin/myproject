package com.thinkinginjava.io.example.chapter18_6.ex18_6_3;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description:
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_3\\TestEOF.java")));
        while(in.available() != 0)
            System.out.print((char)in.readByte());
    }
}
//output:
//package com.thinkinginjava.io.example.chapter18_6.ex18_6_3;
//
//import java.io.BufferedInputStream;
//import java.io.DataInputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//
///**
// * @author: XueYing.Cao
// * @date: 2019/3/13
// * @description:
// */
//public class TestEOF {
//    public static void main(String[] args) throws IOException {
//        DataInputStream in = new DataInputStream(
//                new BufferedInputStream(
//                        new FileInputStream("src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_3\\TestEOF.java")));
//        while(in.available() != 0)
//            System.out.print((char)in.readByte());
//    }
//}