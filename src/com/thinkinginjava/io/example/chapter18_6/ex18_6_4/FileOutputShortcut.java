package com.thinkinginjava.io.example.chapter18_6.ex18_6_4;

import com.thinkinginjava.io.example.chapter18_6.ex18_6_1.BufferedInputFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description:
 */
public class FileOutputShortcut {
    public static String file = "src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_4\\fileout\\FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_4\\FileOutputShortcut.java")));
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
//output:
//1: package com.thinkinginjava.io.example.chapter18_6.ex18_6_4;
//2:
//3: import com.thinkinginjava.io.example.chapter18_6.ex18_6_1.BufferedInputFile;
//4: import java.io.BufferedReader;
//5: import java.io.IOException;
//6: import java.io.PrintWriter;
//7: import java.io.StringReader;
//8:
//9: /**
//10:  * @author: XueYing.Cao
//11:  * @date: 2019/3/13
//12:  * @description:
//13:  */
//14: public class FileOutputShortcut {
//15:     public static String file = "src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_4\\FileOutputShortcut.out";
//16:
//17:     public static void main(String[] args) throws IOException {
//18:         BufferedReader in = new BufferedReader(
//19:                 new StringReader(
//20:                         BufferedInputFile.read("src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_4\\FileOutputShortcut.java")));
//21:         PrintWriter out = new PrintWriter(file);
//22:         int lineCount = 1;
//23:         String s;
//24:         while ((s = in.readLine()) != null)
//25:             out.println(lineCount++ + ": " + s);
//26:         out.close();
//27:         System.out.println(BufferedInputFile.read(file));
//28:     }
//29: }