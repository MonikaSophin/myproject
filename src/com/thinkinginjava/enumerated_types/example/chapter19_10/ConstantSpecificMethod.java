package com.thinkinginjava.enumerated_types.example.chapter19_10;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Author: monika
 * @Date: 2019/4/14 22:15
 * @Version: 1.0
 * @Description:
 */
public enum ConstantSpecificMethod {
    DATA_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            /**
             * {@link System#getenv(String)}
             * 获取指定环境变量的值。环境变量是依赖于系统的外部命名值。
             */
            return System.getenv("JAVA_HOME");
        }
    },
    VERSION {
        String getInfo() {
            /**
             * {@link System#getProperty(String)}
             * 获取指定键指示的系统属性。
             */
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values())
            System.out.println(csm.getInfo());
    }
}
/**output:
 * 2019-4-14
 * E:\Java\JDK1.8
 * 1.8.0_181
 */