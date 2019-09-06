package com.monika.io.parse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author XueYing.Cao
 * @date 2019/9/3
 * 类作用：解析 输入流的数据
 * StreamTokenizer
 */
public class StreamTokenizerTest {

    public static void main(String[] args) {

        String str = "a b c d \n aaa vvv ++ ? : \n -- 123 455 6666 &&&";
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());

        InputStreamReader isr = new InputStreamReader(bais);
        StreamTokenizer st = new StreamTokenizer(isr);

        //指定换行符'\n'为普通字符
        st.ordinaryChar('\n');

        try {
            int i;
            int wordCount = 0;
            int numberCount = 0;
            int eolCount = 0;
            /**
             * TT_EOF（常量-1）:流的末尾
             * TT_NUMBER（常量-2）:数字
             * TT_WORD（常量-3）:字符
             * TT_EOL（常量'\n'）:换行符
             */
            while ((i = st.nextToken()) != StreamTokenizer.TT_EOF){
                switch (i) {
                    case StreamTokenizer.TT_WORD:
                        wordCount++;
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        numberCount++;
                        break;
                    case StreamTokenizer.TT_EOL:
                        eolCount++;
                        break;
                    default:
                        break;
                }
            }
            System.out.println("字符个数：" + wordCount);
            System.out.println("数字个数：" + numberCount);
            System.out.println("换行符个数：" + eolCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**output:
 * 字符个数：6
 * 数字个数：3
 * 换行符个数：2
 */