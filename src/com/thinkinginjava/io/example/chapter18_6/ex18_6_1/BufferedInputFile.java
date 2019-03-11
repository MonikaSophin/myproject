package com.thinkinginjava.io.example.chapter18_6.ex18_6_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/11
 * @description:
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(
                new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read(
                "src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_1\\BufferedInputFile.java"));
    }
}
//output:
//package com.thinkinginjava.io.example.chapter18_6.ex18_6_1;
//
//        import java.io.BufferedReader;
//        import java.io.FileReader;
//        import java.io.IOException;
//
///**
// * @author: XueYing.Cao
// * @date: 2019/3/11
// * @description:
// */
//public class BufferedInputFile {
//    public static String read(String filename) throws IOException {
//        BufferedReader in = new BufferedReader(
//                new FileReader(filename));
//        String s;
//        StringBuilder sb = new StringBuilder();
//        while((s = in.readLine()) != null)
//            sb.append(s + "\n");
//        in.close();
//        return sb.toString();
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.out.println(read(
//                "src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_1\\BufferedInputFile.java"));
//    }
//}
