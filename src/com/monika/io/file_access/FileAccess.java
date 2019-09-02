package com.monika.io.file_access;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author XueYing.Cao
 * @date 2019/9/2
 * 类的作用：文件访问
 * 文件流：FileInputStream/FileReader、FileOutputStream/FileWriter、RandomAccessFile、File、FileFilter/FilenameFilter etc.
 */
public class FileAccess {

    public static void main(String[] args) {
        //数据源
        String fileInName = "D:/GithubRepository/myproject/src/com/monika/io/file_access/test_input";
        File fileIn = new File(fileInName);

        //目标媒介
        String fileOutName = "D:/GithubRepository/myproject/src/com/monika/io/file_access/test_output";
        File fileOut = new File(fileOutName);

        // 数据源 ==program==> 目标媒介
        try (
                FileInputStream in = new FileInputStream(fileIn);
                FileOutputStream out = new FileOutputStream(fileOut)
        ) {
            int c;
            // 一次读取 一个长度为一个字节的数据
            while ((c = in.read()) != -1) {
                out.write(c);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * RandomAccessFile: 创建随机访问文件流，并可选择写入文件。
         * 可选模式：
         * r:只读
         * rw:读取与写入，若文件不存在，则尝试创建
         * rws:与'rw'类似，不过每次内容更新都要同步写入底层存储设备
         * rwd:与'rws'效果一致，但这个模式可用于减少执行的I/O操作次数
         */
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileIn, "rw")) {
            //可返回FileChannel
            FileChannel channel = randomAccessFile.getChannel();

            String s = randomAccessFile.readLine();
            boolean b = randomAccessFile.readBoolean();
            System.out.println(s);
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
