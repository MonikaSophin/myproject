package com.monika.io.parse;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

/**
 * @author XueYing.Cao
 * @date 2019/9/3
 * 类作用：解析 输入流的数据
 * 回退流：PushbackInputStream/PushbackReader
 */
public class PushbackTest {

    public static void main(String[] args) {
        byte[] bytes = "1, 2, 3, 4, 5, 6 * +".getBytes();

        // close()无效，所以不用放入try-resource代码块中
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try (
                PushbackInputStream pis = new PushbackInputStream(bais)
        ) {
            int c;
            while((c = pis.read()) != -1) {
                if (c == ',') {
                    //如果读取到的字节为','，则将','回退至该流缓冲区的前端。
                    pis.unread(c);
                    //再读一次，将处在','的游标 移动一位
                    c = pis.read();
                //    System.out.print("回退到缓冲区" + (char) c);
                } else {
                    // 输出解析过滤之后的字节数组
                    System.out.print((char) c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**output:
 * 1 2 3 4 5 6 * +
 */
