package com.thinkinginjava.io.example.chapter18_6.ex18_6_4;

import com.thinkinginjava.io.example.chapter18_6.ex18_6_1.BufferedInputFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/13
 * @description:
 */
public class BasicFileOutput {
    public static String file = "src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_4\\fileout\\BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_4\\BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)));
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
//5: import java.io.BufferedWriter;
//6: import java.io.FileWriter;
//7: import java.io.IOException;
//8: import java.io.PrintWriter;
//9: import java.io.StringReader;
//10:
//11: /**
//12:  * @author: XueYing.Cao
//13:  * @date: 2019/3/13
//14:  * @description:
//15:  */
//16: public class BasicFileOutput {
//17:     public static String file = "src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_4\\BasicFileOutput.out";
//18:
//19:     public static void main(String[] args) throws IOException {
//20:         BufferedReader in = new BufferedReader(
//21:                 new StringReader(
//22:                         BufferedInputFile.read("src\\com\\thinkinginjava\\io\\example\\chapter18_6\\ex18_6_4\\BasicFileOutput.java")));
//23:         PrintWriter out = new PrintWriter(
//24:                 new BufferedWriter(
//25:                         new FileWriter(file)));
//26:         int lineCount = 1;
//27:         String s;
//28:         while ((s = in.readLine()) != null)
//29:             out.println(lineCount++ + ": " + s);
//30:         out.close();
//31:         System.out.println(BufferedInputFile.read(file));
//32:     }
//33: }
