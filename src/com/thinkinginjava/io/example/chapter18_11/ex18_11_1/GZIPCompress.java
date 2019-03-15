package com.thinkinginjava.io.example.chapter18_11.ex18_11_1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/15
 * @description:
 */
public class GZIPCompress {
    public static void main(String[] args) throws IOException {
        String src_path = "src\\com\\thinkinginjava\\io\\example\\chapter18_11\\ex18_11_1\\GZIPCompress.java";
        String out_path = "src\\com\\thinkinginjava\\io\\example\\chapter18_11\\file\\GZIPCompress.gz";
        BufferedReader in = new BufferedReader(
                new FileReader(src_path));
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(
                        new FileOutputStream(out_path)));

        System.out.println("Writing file");
        int c;
        while((c = in.read()) != -1)
            out.write(c);
        out.close();
        in.close();
        System.out.println("Write complete!");
        System.out.println("-------------------------------------");

        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(
                        new GZIPInputStream(
                                new FileInputStream(out_path))));
        String s;
        while ((s = in2.readLine()) != null)
            System.out.println(s);
    }
}
//output:

//Writing file
//Write complete!
//-------------------------------------
//Reading file
//package com.thinkinginjava.io.example.chapter18_11.ex18_11_1;
//
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.zip.GZIPInputStream;
//import java.util.zip.GZIPOutputStream;
//
///**
// * @author: XueYing.Cao
// * @date: 2019/3/15
// * @description:
// */
//public class GZIPCompress {
//    public static void main(String[] args) throws IOException {
//        String src_path = "src\\com\\thinkinginjava\\io\\example\\chapter18_11\\ex18_11_1\\GZIPCompress.java";
//        String out_path = "src\\com\\thinkinginjava\\io\\example\\chapter18_11\\file\\GZIPCompress.gz";
//        BufferedReader in = new BufferedReader(
//                new FileReader(src_path));
//        BufferedOutputStream out = new BufferedOutputStream(
//                new GZIPOutputStream(
//                        new FileOutputStream(out_path)));
//
//        System.out.println("Writing file");
//        int c;
//        while((c = in.read()) != -1)
//            out.write(c);
//        out.close();
//        in.close();
//        System.out.println("Write complete!");
//        System.out.println("-------------------------------------");
//
//        System.out.println("Reading file");
//        BufferedReader in2 = new BufferedReader(
//                new InputStreamReader(
//                        new GZIPInputStream(
//                                new FileInputStream(out_path))));
//        String s;
//        while ((s = in2.readLine()) != null)
//            System.out.println(s);
//    }
//}