package com.thinkinginjava.io.example.chapter18_1.ex18_1_2;

import com.thinkinginjava.util.Directory;
import com.thinkinginjava.util.PPrint;
import static com.thinkinginjava.util.Print.*;

import java.io.File;

/**
 * @Author: monika
 * @Date: 2019/3/10 22:03
 * @Version: 1.0
 * @Description:
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        // 所有目录:
        PPrint.pprint(Directory.walk(".").dirs);
        // 所有文件以“T”开头
        for(File file : Directory.local(".", "T.*"))
            print(file);
        print("----------------------");
        // 所有以'T'开头的Java文件:
        for(File file : Directory.walk(".", "T.*\\.java"))
            print(file);
        print("======================");
        // 包含“Z”或“z”的类文件:
        for(File file : Directory.walk(".",".*[Zz].*\\.class"))
            print(file);
    }
}
/**output:
 * 略~
 */