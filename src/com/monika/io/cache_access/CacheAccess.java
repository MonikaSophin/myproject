package com.monika.io.cache_access;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author XueYing.Cao
 * @date 2019/9/2
 * 类的作用：内存缓存访问
 * 内存数组流：ByteArrayInputStream/CharArrayReader、ByteArrayOutputStream/CharArrayWriter
 */
public class CacheAccess {

    public static void main(String[] args) {
        // 向内存写入数据
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bytes = "hello world!".getBytes();
        out.write(bytes, 0, bytes.length);

        //从内存中读取数据
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
