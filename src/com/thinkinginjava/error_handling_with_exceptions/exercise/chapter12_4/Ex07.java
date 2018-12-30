package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @Author: monika
 * @Date: 2018/12/26 23:17
 * @Version: 1.0
 * @Description: page 256
 * 练习07：修改练习03，使得catch子句可以将结果作为日志记录。
 */
public class Ex07 {
    private static Logger logger = Logger.getLogger("Ex07");
    public static void main(String[] args) {
        int[] ints = new int[3];
        try{
            ints[5] = 5;
        }catch (ArrayIndexOutOfBoundsException e){
            logger.severe("Array Index Out Of Bounds : " + e);
//            StringWriter cause = new StringWriter();
//            PrintWriter printWriter = new PrintWriter(cause);
//            e.printStackTrace(printWriter);
//            logger.severe("Array Index Out Of Bounds : " + cause.toString());
        }
    }
}
/**output:
 * 十二月 26, 2018 11:24:05 下午 com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4.Ex07 main
 * 严重: Array Index Out Of Bounds : java.lang.ArrayIndexOutOfBoundsException: 5
 */