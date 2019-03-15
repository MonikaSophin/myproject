package com.thinkinginjava.io.example.chapter18_11.ex18_11_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/15
 * @description:
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {
        String src_path = "src\\com\\thinkinginjava\\io\\example\\chapter18_11\\ex18_11_2\\ZipCompress.java";
        String out_path = "src\\com\\thinkinginjava\\io\\example\\chapter18_11\\file\\ZipCompress.zip";

        // 压缩zip文件
        FileOutputStream f = new FileOutputStream(out_path);
        /**
         * 两种{@link Checksum}类型:
         * {@link Adler32} 速度稍快一点
         * {@link CRC32} 速度稍慢一点，但更准确。
         */
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");//设置ZIP文件注释。
        print("Writing file: " + src_path);
        BufferedReader in = new BufferedReader(
                new FileReader(src_path));
        zos.putNextEntry(new ZipEntry(src_path));
        int c;
        while ((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.flush();
        out.close();
        print("---------------------------------------");

        // 解压zip
        print("Checksum: " + csum.getChecksum().getValue());
        print("Reading file");
        FileInputStream fi = new FileInputStream(out_path);
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream zis = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(zis);
        ZipEntry ze;
        while ((ze = zis.getNextEntry()) != null) {
            print("Reading file: " + ze);
            int x;
            while ((x = bis.read()) != -1)
                System.out.write(x);
        }
        bis.close();
        print("---------------------------------------");

        //读取zip文件
        ZipFile zf = new ZipFile(out_path);
        Enumeration<? extends ZipEntry> es = zf.entries();
        while (es.hasMoreElements()) {
            ZipEntry z = es.nextElement();
            print("File: " + z);
        }
    }
}
//output:
//Writing file: src\com\thinkinginjava\io\example\chapter18_11\ex18_11_2\ZipCompress.java
//---------------------------------------
//Checksum: 3568182829
//Reading file
//Reading file: src\com\thinkinginjava\io\example\chapter18_11\ex18_11_2\ZipCompress.java
//package com.thinkinginjava.io.example.chapter18_11.ex18_11_2;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Enumeration;
//import java.util.zip.CheckedInputStream;
//import java.util.zip.CheckedOutputStream;
//import java.util.zip.Adler32;
//import java.util.zip.CRC32;
//import java.util.zip.Checksum;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipFile;
//import java.util.zip.ZipInputStream;
//import java.util.zip.ZipOutputStream;
//import static com.thinkinginjava.util.Print.*;
//
///**
// * @author: XueYing.Cao
//Disconnected from the target VM, address: '127.0.0.1:53225', transport: 'socket'
// * @date: 2019/3/15
// * @description:
// */
//public class ZipCompress {
//    public static void main(String[] args) throws IOException {
//        String src_path = "src\\com\\thinkinginjava\\io\\example\\chapter18_11\\ex18_11_2\\ZipCompress.java";
//        String out_path = "src\\com\\thinkinginjava\\io\\example\\chapter18_11\\file\\ZipCompress.zip";
//
//        // �)zip��
//        FileOutputStream f = new FileOutputStream(out_path);
//        /**
//         * $�{@link Checksum}{�:
//� �
//b �F��n
//         */
//        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
//        ZipOutputStream zos = new ZipOutputStream(csum);
//        BufferedOutputStream out = new BufferedOutputStream(zos);
//        zos.setComment("A test of Java Zipping");//�nZIP����
//        print("Writing file: " + src_path);
//        BufferedReader in = new BufferedReader(
//                new FileReader(src_path));
//        zos.putNextEntry(new ZipEntry(src_path));
//        int c;
//        while ((c = in.read()) != -1)
//            out.write(c);
//        in.close();
//        out.flush();
//        out.close();
//        print("---------------------------------------");
//
//        // �zip��
//        print("Checksum: " + csum.getChecksum().getValue());
//        print("Reading file");
//        FileInputStream fi = new FileInputStream(out_path);
//        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
//        ZipInputStream zis = new ZipInputStream(csumi);
//        BufferedInputStream bis = new BufferedInputStream(zis);
//        ZipEntry ze;
//        while ((ze = zis.getNextEntry()) != null) {
//            print("Reading file: " + ze);
//            int x;
//            while ((x = bis.read()) != -1)
//                System.out.write(x);
//        }
//        bis.close();
//        print("---------------------------------------");
//
//        //��zip��
//        ZipFile zf = new ZipFile(out_path);
//        Enumeration<? extends ZipEntry> es = zf.entries();
//        while (es.hasMoreElements()) {
//            ZipEntry z = es.nextElement();
//            print("File: " + z);
//        }
//    }
//}
//---------------------------------------
//File: src\com\thinkinginjava\io\example\chapter18_11\ex18_11_2\ZipCompress.java