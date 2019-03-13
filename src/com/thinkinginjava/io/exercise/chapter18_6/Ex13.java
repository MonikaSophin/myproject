package com.thinkinginjava.io.exercise.chapter18_6;

import com.thinkinginjava.io.example.chapter18_6.ex18_6_1.BufferedInputFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description: page 543
 * 练习13：修改BasicFileOutput.java，以便可以使用LineNumberReader来记录行数。
 * 注意继续使用编程方式实现跟踪会更简单。
 */
public class Ex13 {
    public static String file = "src\\com\\thinkinginjava\\io\\exercise\\chapter18_6\\file\\Ex13.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("src\\com\\thinkinginjava\\io\\exercise\\chapter18_6\\Ex13.java")));
        LineNumberReader line = new LineNumberReader(in);
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)));
        String s;
        while ((s = line.readLine()) != null)
            out.println(line.getLineNumber() + ": " + s);
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
//output:
//1: package com.thinkinginjava.io.exercise.chapter18_6;
//2:
//3: import com.thinkinginjava.io.example.chapter18_6.ex18_6_1.BufferedInputFile;
//4: import java.io.BufferedReader;
//5: import java.io.BufferedWriter;
//6: import java.io.FileWriter;
//7: import java.io.IOException;
//8: import java.io.LineNumberReader;
//9: import java.io.PrintWriter;
//10: import java.io.StringReader;
//11:
//12: /**
//13:  * @author: XueYing.Cao
//14:  * @date: 2019/3/13
//15:  * @description: page 543
//16:  * 练习13：修改BasicFileOutput.java，以便可以使用LineNumberReader来记录行数。
//17:  * 注意继续使用编程方式实现跟踪会更简单。
//18:  */
//19: public class Ex13 {
//20:     public static String file = "src\\com\\thinkinginjava\\io\\exercise\\chapter18_6\\fileout\\Ex13.out";
//21:
//22:     public static void main(String[] args) throws IOException {
//23:         BufferedReader in = new BufferedReader(
//24:                 new StringReader(
//25:                         BufferedInputFile.read("src\\com\\thinkinginjava\\io\\exercise\\chapter18_6\\Ex13.java")));
//26:         LineNumberReader line = new LineNumberReader(in);
//27:         PrintWriter out = new PrintWriter(
//28:                 new BufferedWriter(
//29:                         new FileWriter(file)));
//30:         String s;
//31:         while ((s = line.readLine()) != null)
//32:             out.println(line.getLineNumber() + ": " + s);
//33:         out.close();
//34:         System.out.println(BufferedInputFile.read(file));
//35:     }
//36: }