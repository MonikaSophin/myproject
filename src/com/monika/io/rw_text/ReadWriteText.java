package com.monika.io.rw_text;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author XueYing.Cao
 * @date 2019/9/3
 * 类作用：读写文本
 * 字符串流：StringReader、StringWriter
 * 打印流：PrintStream、PrintWriter
 */
public class ReadWriteText {

    public static void main(String[] args) {
        String str = "hello world!";

        // close()无效，所以不用放入try-resource代码块中，该流可以用来构造字符串。
        StringWriter sw = new StringWriter();
        try (
                StringReader sr = new StringReader(str);
        ) {
            int c;
            while ((c = sr.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();

            //获取在流中构造的字符串
            sw.write("hello 你好！");
            String buffer = sw.getBuffer().toString();
            System.out.println(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
