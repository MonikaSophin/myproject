package com.mybatis.mapper_scan.self;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author XueYing.Cao
 * @date 2020/5/14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyMapperScannerRegistrar.class)
public @interface MyMapperScan {
    String[] value() default {};
    String[] basePackages() default {};
}
