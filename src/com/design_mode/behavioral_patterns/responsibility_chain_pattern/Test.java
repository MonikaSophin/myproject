package com.design_mode.behavioral_patterns.responsibility_chain_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 步骤3.
 * 创建不同类型的记录器。赋予它们不同的错误级别，并在每个记录器中设置下一个记录器。
 * 每个记录器中的下一个记录器代表的是链的一部分。
 */
public class Test {

    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");
        System.out.println();

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");
        System.out.println();

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
/**output:
 * Standard Console::Logger: This is an information.
 *
 * File::Logger: This is a debug level information.
 * Standard Console::Logger: This is a debug level information.
 *
 * Error Console::Logger: This is an error information.
 * File::Logger: This is an error information.
 * Standard Console::Logger: This is an error information.
 */