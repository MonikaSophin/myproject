package com.thinkinginjava.io.example.chapter18_6.ex18_6_2;

import com.thinkinginjava.io.example.chapter18_6.ex18_6_1.BufferedInputFile;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/11
 * @description:
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        String in = new BufferedInputFile().read(
                "src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_2\\MemoryInput.java");
        StringReader reader = new StringReader(in);
        int c;
        /**
         * {@link StringReader#read()} 注意:
         * read()是以int形式返回下一字节，因此必须类型转换为char才能正确打印。
         */
        while((c = reader.read()) != -1)
            System.out.print((char) c);
    }
}
//output:
//package com.thinkinginjava.io.example.chapter18_6.ex18_6_2;
//
//        import com.thinkinginjava.io.example.chapter18_6.ex18_6_1.BufferedInputFile;
//        import java.io.IOException;
//        import java.io.StringReader;
//
///**
// * @author: XueYing.Cao
// * @date: 2019/3/11
// * @description:
// */
//public class MemoryInput {
//    public static void main(String[] args) throws IOException {
//        String in = new BufferedInputFile().read(
//                "src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_2\\MemoryInput.java");
//        StringReader reader = new StringReader(in);
//        int c;
//        /**
//         * {@link StringReader#read()} 注意:
//         * read()是以int形式返回下一字节，因此必须类型转换为char才能正确打印。
//         */
//        while((c = reader.read()) != -1)
//            System.out.print((char) c);
//    }
//}