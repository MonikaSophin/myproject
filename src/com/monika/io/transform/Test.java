package com.monika.io.transform;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author XueYing.Cao
 * @date 2019/9/6
 * 类作用：转换流（字节流-->字符流）
 * 字节转换流：InputStreamReader、OutputStreamWriter
 */
public class Test {

    public static void main(String[] args) {

        String fileOutName = "D:/GithubRepository/myproject/src/com/monika/io/transform/test_output";
        try (
                //输出字节转换流
                FileOutputStream fos = new FileOutputStream(fileOutName);
                OutputStreamWriter osr = new OutputStreamWriter(fos);

                //输入字节转换流
                FileInputStream fis = new FileInputStream(fileOutName);
                InputStreamReader isr = new InputStreamReader(fis);
        ) {
            // 可以直接输出字符
            osr.write("hello world!\n你好~");
            osr.flush();

            int c;
            while ((c = isr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
/**output:
 * hello world!
 * 你好~
 */