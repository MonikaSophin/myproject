package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @Author: monika
 * @Date: 2018/12/26 22:52
 * @Version: 1.0
 * @Description:
 * 1.logger.severe(String msg); 日志级别为'严重'。
 *   logger.warning(String msg); 日志级别为'警告'。
 */
class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException() {
        StringWriter trace = new StringWriter();
        PrintWriter printWriter = new PrintWriter(trace);
        printStackTrace(printWriter);
        logger.severe(trace.toString());
    }
}

public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}
/**output(85% match):
 * 十二月 26, 2018 10:58:18 下午 com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.LoggingException <init>
 * 严重: com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.LoggingException
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.LoggingExceptions.main(LoggingExceptions.java:26)
 *
 * Caught com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.LoggingException
 * 十二月 26, 2018 10:58:18 下午 com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.LoggingException <init>
 * 严重: com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.LoggingException
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.LoggingExceptions.main(LoggingExceptions.java:31)
 *
 * Caught com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4.ex12_4_1.LoggingException
 */