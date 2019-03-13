package com.thinkinginjava.io.example.chapter18_6.ex18_6_3;

import com.thinkinginjava.io.example.chapter18_6.ex18_6_1.BufferedInputFile;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description:
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read("src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_3\\FormattedMemoryInput.java").getBytes()));
            while (true)
                System.out.print((char)in.readByte());
        }catch (EOFException e) {
            System.err.println("End of stream");
        }
    }
}
//output:
//End of stream
//package com.thinkinginjava.io.example.chapter18_6.ex18_6_3;
//
//import com.thinkinginjava.io.example.chapter18_6.ex18_6_1.BufferedInputFile;
//import java.io.ByteArrayInputStream;
//import java.io.DataInputStream;
//import java.io.EOFException;
//import java.io.IOException;
//
///**
// * @author: XueYing.Cao
// * @date: 2019/3/13
// * @description:
// */
//public class FormattedMemoryInput {
//    public static void main(String[] args) throws IOException {
//        try {
//            DataInputStream in = new DataInputStream(
//                    new ByteArrayInputStream(
//                            BufferedInputFile.read("src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_3\\FormattedMemoryInput.java").getBytes()));
//            while (true)
//                System.out.print((char)in.readByte());
//        }catch (EOFException e) {
//            System.err.println("End of stream");
//        }
//    }
//}
