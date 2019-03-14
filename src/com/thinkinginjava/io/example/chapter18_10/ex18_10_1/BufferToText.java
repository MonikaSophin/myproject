package com.thinkinginjava.io.example.chapter18_10.ex18_10_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description:
 */
public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_10\\file\\BufferToText.txt";
        FileChannel fc = new FileOutputStream(filePath).getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new FileInputStream(filePath).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        //不能工作
        System.out.println(buffer.asCharBuffer());
        System.out.println("----------------------------");


        //使用这个系统的默认字符集解码
        /**
         * {@link ByteBuffer#rewind()} :倒回这个缓冲区.
         */
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println(String.format("Decode using %s: %s", encoding,
                Charset.forName(encoding).decode(buffer)));
        System.out.println("----------------------------");


        //或者，我们可以用一些可以打印的东西来编码
        fc = new FileOutputStream(filePath).getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();

        //现在，尝试再读
        fc = new FileInputStream(filePath).getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        System.out.println("----------------------------");

        //使用CharBuffer进行写操作
        fc = new FileOutputStream(filePath).getChannel();
        buffer = ByteBuffer.allocate(24);// 超过需要
        buffer.asCharBuffer().put("Some text");
        fc.write(buffer);
        fc.close();

        //读并展示
        fc = new FileInputStream(filePath).getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}
/**output:
 * 卯浥⁴數
 * ----------------------------
 * Decode using UTF-8: Some text
 * ----------------------------
 * Some text
 * ----------------------------
 * Some text
 */