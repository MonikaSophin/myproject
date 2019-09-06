package com.monika.io.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author XueYing.Cao
 * @date 2019/9/3
 * 类作用:缓冲
 * 缓冲流：BufferedInputStream/BufferReader、BufferedOutputStream/BufferedWriter
 */
public class BufferTest {

    public static void main(String[] args) {
        //数据源
        String fileInName = "D:/GithubRepository/myproject/src/com/monika/io/file_access/test_input";
        File fileIn = new File(fileInName);

        //目标媒介
        String fileOutName = "D:/GithubRepository/myproject/src/com/monika/io/buffer/test_output";
        File fileOut = new File(fileOutName);

        // 数据源 ==program==> 目标媒介
        try (
                FileInputStream fis = new FileInputStream(fileIn);
                FileOutputStream fos = new FileOutputStream(fileOut);

                //BufferedInputStream给另一个输入流添加了功能（装饰者模式），即缓冲输入和支持mark和reset方法的功能。
                BufferedInputStream in = new BufferedInputStream(fis);
                //BufferedOutputStream给另一个输出流添加了缓冲输出的功能。
                BufferedOutputStream out = new BufferedOutputStream(fos)
        ) {
            // in.markSupported(); //标识是否此流是否支持mark。true为支持，false为不支持。
            // in.mark(1); //在输入流中标识当前位置。参数readlimit：从当前位置读取，最多读取readlimit个字节。
            // in.reset(); //将此流重新定位到 上次在此输入流上调用mark方法时的位置。

            int c;
            // 一次读取 一个长度为一个字节的数据
            while ((c = in.read()) != -1) {
                out.write(c);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
