package com.monika.io.rw_text;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author XueYing.Cao
 * @date 2019/9/3
 * 类作用：读写文本
 * 打印流：PrintStream/PrintWriter
 */
public class PrintTest {

    public static void main(String[] args) {

        String fileOutName = "D:/GithubRepository/myproject/src/com/monika/io/rw_text/test_output";
        try(
                //将内容输出到控制台
                PrintStream ps = new PrintStream(System.out);

                //将内容输出到文件中
                FileWriter fw = new FileWriter(fileOutName);
                PrintWriter pw = new PrintWriter(fw, true)
        ) {
            ps.println("test~");
            ps.println("hello world!");
            pw.println("test");
            pw.printf("%s:%d --> %.2f", "Bob", 19, 2.2455);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
