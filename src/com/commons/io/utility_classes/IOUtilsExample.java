package com.commons.io.utility_classes;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * @author XueYing.Cao
 * @date 2019/9/9
 * commons-io常用工具类
 * IOUtils的示例
 */
public class IOUtilsExample {

    public static void main(String[] args) throws IOException {

        String fileInName1 = "D:/GithubRepository/myproject/src/com/commons/io/utility_classes/src/fileIn1";
        String fileInName2 = "D:/GithubRepository/myproject/src/com/commons/io/utility_classes/src/fileIn2";
        String fileOutName1 = "D:/GithubRepository/myproject/src/com/commons/io/utility_classes/dest/fileOut1";
        String fileOutName2 = "D:/GithubRepository/myproject/src/com/commons/io/utility_classes/dest/fileOut2";

        //***************************      IOUtils的使用     *****************************

        /**
         * 1. buffer() 给InputStream/Reader、OutputStream/Writer装饰为对应的缓冲流
         * 方法中使用的流需要手动关闭。
         */
        BufferedInputStream buffer1 = IOUtils.buffer(new FileInputStream(fileInName1));
        // 可指定缓冲区大小
        BufferedInputStream buffer2 = IOUtils.buffer(new FileInputStream(fileInName1), 1024);

        /**
         * 2. contentEquals()/contentEqualsIgnoreEOL() 对比两个流的内容。
         * 方法中使用的流需要手动关闭。
         * EOF: 流的结尾(-1) ， EOL: 默认系统换行符('\n') 。
         */
        boolean b = IOUtils.contentEquals(new FileInputStream(fileInName1), new FileInputStream(fileInName2));
        // 可忽略换行符的差异
        boolean b1 = IOUtils.contentEqualsIgnoreEOL(new FileReader(fileInName1), new FileReader(fileInName2));

        /**
         * 3. copy()/copyLarge() 将所有数据从一个输入流复制到另一个输出流。
         * 方法中使用的流需要手动关闭。
         */
        int copy_byte_size = IOUtils.copy(new FileInputStream(fileInName1), new FileOutputStream(fileOutName1)); //返回：23
        //一般用来处理大的（超过2GB）输入流 的复制操作
        long copy_byte_size2 = IOUtils.copyLarge(new FileInputStream(fileInName1), new FileOutputStream(fileOutName1)); //返回：23

        /**
         * 4. lineIterator() 返回一个读取文件内容的遍历器LineIterator。
         */
        LineIterator lineIterator = IOUtils.lineIterator(new FileReader(fileInName1));
        while (lineIterator.hasNext()) {
            lineIterator.next();
            // lineIterator.nextLine();
        }
        lineIterator.close();

        /**
         * 5. read()/readFully() 每次读取指定大小数组的数据。
         * 方法中使用的流需要手动关闭。
         */
        int read = IOUtils.read(new FileInputStream(fileInName1), new byte[1024]); // 返回：23
        int read1 = IOUtils.read(new FileReader(fileInName1), new char[1024]); // 返回：23
        IOUtils.readFully(new FileReader(fileInName1), new char[23]);// 正确
        // 流中的内容到结尾 都不足 数组指定大小的话，则会报错。
        //! IOUtils.readFully(new FileReader(fileInName1), new char[30]);// 报错：java.io.EOFException: Length to read: 30 actual: 23

        /**
         * 6. readLines() 将流内容全部按照 换行符 进行读取。
         * 方法中使用的流需要手动关闭。
         */
        List<String> list1 = IOUtils.readLines(new FileReader(fileInName1));
        List<String> list2 = IOUtils.readLines(new FileInputStream(fileInName1), "UTF-8");

        /**
         * 7. toByteArray() 将URL/URI/InputStream/Reader的内容转为byte[]
         * 方法中使用的流需要手动关闭。
         */
        byte[] bytes1 = IOUtils.toByteArray(new File(fileInName1).toURI());
        byte[] bytes2 = IOUtils.toByteArray(new File(fileInName1).toURI().toURL());
        byte[] bytes3 = IOUtils.toByteArray(new URL("http://www.baidu.com"));
        byte[] bytes4 = IOUtils.toByteArray(new FileInputStream(fileInName1));
        byte[] bytes5 = IOUtils.toByteArray(new FileReader(fileInName1), "UTF-8");

        /**
         * 8. toString() 将输入流中的内容输出为字符串。
         * 方法中使用的流需要手动关闭。
         */
        String string = IOUtils.toString(new FileReader(fileInName1));
        String string1 = IOUtils.toString(new FileInputStream(fileInName1), "UTF-8");

        /**
         * 9. toInputStream() 将字符串内容 包装为InputStream
         */
        InputStream input1 = IOUtils.toInputStream("xxx", "UTF-8");

        /**
         * 10. write()/writeChunked()/writeLines() 将数据写入输出流
         * 方法中使用的流需要手动关闭。
         */
        IOUtils.write("xxx", new FileOutputStream(fileOutName2), "UTF-8");
        //该方法是为了分块写入大数据而设计的
        IOUtils.writeChunked("yyyy".getBytes(), new FileOutputStream(fileInName2));

    }
}
