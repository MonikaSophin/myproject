package com.thinkinginjava.io.exercise.chapter18_7;

import com.thinkinginjava.util.BinaryFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description: page 548
 * 练习19：用{@link BinaryFile}和Map<Byte,Integer>创建一个程序，它可以对在一个文件中所有
 * 不同的字节出现的次数进行计数。
 */
public class Ex19 {
    public static void main(String[] args) throws IOException {
        String path = "src\\com\\thinkinginjava\\io\\exercise\\chapter18_7\\file\\Ex19.txt";
        byte[] bytes = BinaryFile.read(path);

        Map<Byte,Integer> map = new HashMap<>();
        for (byte aByte : bytes) {
            Integer count = map.get(aByte);
            if (count == null)
                map.put(aByte, 1);
            else {
                count++;
                map.put(aByte, count);
            }
        }

        System.out.println(map);
    }
}
/**output:
 * {10=31, 13=31, 92=6, 97=14, 98=6, 99=16, 100=8, 101=11, 102=20, 103=13, 39=9, 104=8, 105=9, 106=10, 42=16, 107=20, 108=9, 109=9, 110=10, 113=21, 114=8, 116=9, 117=8, 119=7, 120=16, 121=8, 122=9, 63=10}
 */