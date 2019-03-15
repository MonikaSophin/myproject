package com.thinkinginjava.io.exercise.chapter18_10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description: page 566
 * 练习25：试着将本章例子中的{@link ByteBuffer#allocate(int)}语句改为{@link ByteBuffer#allocateDirect(int)} 。
 * 用来证实性能之间的差异，但是请注意程序的启动时间是否发生了明显的改变。
 */
public class Ex25 {
    private static final String FILE_PREFIX = "src\\com\\thinkinginjava\\io\\";
    private static final String PACKAGE_PREFIX = "com.thinkinginjava.io.";
    //复制文件的方法，用allocateDirect()替换allocate()，并重命名fileDirect:
    public static File toDirect(File f) throws IOException {
        FileChannel fcIn = new FileInputStream(f).getChannel();
        ByteBuffer b = ByteBuffer.allocateDirect((int)f.length());
        fcIn.read(b);
        b.flip();
        Charset cs = Charset.defaultCharset();
        CharBuffer cb = cs.decode(b);
        String cbD1 = cb.toString().replace(
                ".allocate(", ".allocateDirect(");
        String cbD = cbD1.replace(f.getName().split("\\.")[0],
                f.getName().split("\\.")[0] + "Direct");
        CharBuffer cbNew = CharBuffer.wrap(cbD);
        String ext = (f.getName().split("\\."))[1];
        String outFile = (f.getName().split("\\."))[0] +
                "Direct." + ext;
        String prefix = FILE_PREFIX + "exercise\\chapter18_10\\file\\";
        FileChannel fcOut =
                new FileOutputStream(
                        new File(prefix + outFile)).getChannel();
        fcOut.write(cs.encode(cbNew));
        // fcIn.transferTo(0, f.length(), fcOut);
        fcIn.close();
        fcOut.close();
        return new File(outFile);
    }
    // 测试性能的方法
    public static void Tester(String s) {
        try { // 使用反射来调用main方法:
            Class c = Class.forName(s);
            String name = c.getSimpleName();
            print("Testing: " + name);
            @SuppressWarnings("unchecked")
            Method m = c.getMethod("main", String[].class);
            // 测试ChannelCopy.class
            // (otherwise (String)null OK for second argument):
            String[] sa = new String[]{"ChannelCopy.java", "Test.txt"};
            long startRun = System.nanoTime();
            m.invoke(c.newInstance(), (Object)sa);
            long duration = System.nanoTime() - startRun;
            print("\nTime to run " + name + " = "
                    + duration + " nanoseconds");
        } catch(Exception e) {
            e.printStackTrace(System.err);
        }
    }
    public static long allocationTime(int i) {
        long start = System.nanoTime();
        ByteBuffer bb = ByteBuffer.allocate(i);
        return System.nanoTime() - start;
    }
    public static long directAllocationTime(int i) {
        long start = System.nanoTime();
        ByteBuffer bb = ByteBuffer.allocateDirect(i);
        return System.nanoTime() - start;
    }

    public static void main(final String[] args) throws IOException {
        // 与statup时间相关的分配时间:
        print("Time to allocate 1024 bytes = "
                + allocationTime(1024) + " nanoseconds");
        print("Time to allocateDirect 1024 bytes = "
                + directAllocationTime(1024) + " nanoseconds");
        print("Time to allocate 48 bytes = "
                + allocationTime(48) + " nanoseconds");
        print("Time to allocateDirect 48 bytes = "
                + directAllocationTime(48) + " nanoseconds");
        print("Time to allocate 1 byte = "
                + allocationTime(1) + " nanoseconds");
        print("Time to allocateDirect 1 byte = "
                + directAllocationTime(1) + " nanoseconds");
        print();

        Tester(PACKAGE_PREFIX + "example.chapter18_10.GetChannel");
        toDirect(new File(FILE_PREFIX + "example\\chapter18_10\\GetChannel.java"));
        // after compiling GetChannelDirect:
        Tester(PACKAGE_PREFIX + "example.chapter18_10.GetChannelDirect");

        Tester(PACKAGE_PREFIX + "example.chapter18_10.ex18_10_1.BufferToText");
        toDirect(new File(FILE_PREFIX + "example\\chapter18_10\\ex18_10_1\\BufferToText.java"));
        // after compiling BufferToText.java:
        Tester(PACKAGE_PREFIX + "example.chapter18_10.ex18_10_1.BufferToTextDirect");

        Tester(PACKAGE_PREFIX + "example.chapter18_10.ex18_10_2.GetData");
        toDirect(new File(FILE_PREFIX + "example\\chapter18_10\\ex18_10_2\\GetData.java"));
        // after compiling GetDataDirect.java:
        Tester(PACKAGE_PREFIX + "example.chapter18_10.ex18_10_2.GetDataDirect");

        Tester(PACKAGE_PREFIX + "example.chapter18_10.ex18_10_2.IntBufferDemo");
        toDirect(new File(FILE_PREFIX + "example\\chapter18_10\\ex18_10_2\\IntBufferDemo.java"));
        // after compiling IntBufferDemoDirect.java:
        Tester(PACKAGE_PREFIX + "example.chapter18_10.ex18_10_2.IntBufferDemoDirect");

        Tester(PACKAGE_PREFIX + "example.chapter18_10.ex18_10_5.UsingBuffers");
        toDirect(new File(FILE_PREFIX + "example\\chapter18_10\\ex18_10_5\\UsingBuffers.java"));
        // after compiling UsingBuffersDirect.java:
        Tester(PACKAGE_PREFIX + "example.chapter18_10.ex18_10_5.UsingBuffersDirect");
    }
}
/**output:
 * Time to allocate 1024 bytes = 18039 nanoseconds
 * Time to allocateDirect 1024 bytes = 167640 nanoseconds
 * Time to allocate 48 bytes = 1244 nanoseconds
 * Time to allocateDirect 48 bytes = 5599 nanoseconds
 * Time to allocate 1 byte = 933 nanoseconds
 * Time to allocateDirect 1 byte = 4043 nanoseconds
 *
 * Testing: GetChannel
 * Some text Some more
 * Time to run GetChannel = 3194490 nanoseconds
 * Testing: GetChannelDirect
 * Some text Some more
 * Time to run GetChannelDirect = 512251 nanoseconds
 * Testing: BufferToText
 * 卯浥⁴數
 * ----------------------------
 * Decode using UTF-8: Some text
 * ----------------------------
 * Some text
 * ----------------------------
 * Some text
 *
 * Time to run BufferToText = 14775020 nanoseconds
 * Testing: BufferToTextDirect
 * 卯浥⁴數
 * ----------------------------
 * Decode using UTF-8: Some text
 * ----------------------------
 * Some text
 * ----------------------------
 * Some text
 *
 * Time to run BufferToTextDirect = 1222310 nanoseconds
 * Testing: GetData
 * i = 1025
 * H o w d y !
 * 12390
 * 99471142
 * 99471142
 * 9.9471144E7
 * 9.9471142E7
 *
 * Time to run GetData = 2022254 nanoseconds
 * Testing: GetDataDirect
 * i = 1025
 * H o w d y !
 * 12390
 * 99471142
 * 99471142
 * 9.9471144E7
 * 9.9471142E7
 *
 * Time to run GetDataDirect = 986868 nanoseconds
 * Testing: IntBufferDemo
 * 99
 * 11 42 47 1811 142 811 1016
 * Time to run IntBufferDemo = 146491 nanoseconds
 * Testing: IntBufferDemoDirect
 * 99
 * 11 42 47 1811 142 811 1016
 * Time to run IntBufferDemoDirect = 158931 nanoseconds
 * Testing: UsingBuffers
 * UsingBuffers
 * sUniBgfuefsr
 * UsingBuffers
 *
 * Time to run UsingBuffers = 118810 nanoseconds
 * Testing: UsingBuffersDirect
 * UsingBuffersDirect
 * sUniBgfuefsriDertc
 * UsingBuffersDirect
 *
 * Time to run UsingBuffersDirect = 171372 nanoseconds
 */