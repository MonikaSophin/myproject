package com.dubbo.registry.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2020/5/29 9:25
 *
 * @author Sakata Gintoki
 * @version 1.0
 */
public class FilterTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public static @interface Filter {
        String value();
    }

    public static interface F {

    }
}
