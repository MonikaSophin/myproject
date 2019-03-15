package com.thinkinginjava.io.exercise.chapter18_10;

import com.thinkinginjava.string.example.chapter13_6.ex13_6_8.JGrep;
import com.thinkinginjava.util.TextFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description: page 566
 * 练习26:修改{@link JGrep}，让其使用java的nio内存映射文件。
 */
class JGrep26 {
    private static final String regex = "\\b[Ssct]\\w+";
    private static final String fileName = "src\\com\\thinkinginjava\\string\\example\\chapter13_6\\ex13_6_8\\JGrep.java";

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileInputStream(fileName).getChannel();
        MappedByteBuffer in =
                fc.map(FileChannel.MapMode.READ_ONLY, 0,
                        new File(fileName).length());

        /**
         *   需要采用本机的编码格式进行解码，不然
         * 直接采用下面注解掉的用法，会乱码。
         */
        //! String[] sa = in.asCharBuffer().toString().split("\n");
        Charset charset = Charset.forName(System.getProperty("file.encoding"));
        CharBuffer cb = charset.decode(in);
        String[] sa = cb.toString().split("\n");// 将字节解码为字符并创建“行”数组:

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(""); // 创建emtpy Matcher对象
        int index = 0;
        for(String line : sa) {
            m.reset(line);
            while(m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        }
        fc.close();
    }
}

public class Ex26 {
    public static void main(String[] args) throws IOException {
        JGrep26.main(args);
    }
}
/**output:
 * 0: com: 8
 * 1: thinkinginjava: 12
 * 2: string: 27
 * 3: chapter13_6: 42
 * 4: com: 7
 * 5: thinkinginjava: 11
 * 6: class: 7
 * 7: static: 11
 * 8: String: 28
 * 9: String: 8
 * 10: Ssct: 28
 * 11: String: 8
 * 12: src: 27
 * 13: com: 32
 * 14: thinkinginjava: 37
 * 15: string: 53
 * 16: chapter13_6: 70
 * 17: compile: 28
 * 18: String: 13
 * 19: System: 16
 * 20: start: 45
 * 21: com: 6
 * 22: thinkinginjava: 6
 * 23: string: 6
 * 24: chapter13_6: 6
 * 25: com: 6
 * 26: thinkinginjava: 6
 * 27: chapter11_9: 6
 * 28: class: 6
 * 29: static: 6
 * 30: String: 6
 * 31: String: 7
 * 32: Ssct: 7
 * 33: String: 7
 * 34: src: 7
 * 35: com: 7
 * 36: thinkinginjava: 7
 * 37: string: 7
 * 38: chapter13_6: 7
 * 39: compile: 7
 * 40: String: 7
 * 41: System: 7
 * 42: start: 7
 */