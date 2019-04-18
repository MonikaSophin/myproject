// The @Unit @TestProperty tag.
package com.thinkinginjava.util.atunit;
import java.lang.annotation.*;

// 字段和方法都可以标记为属性:
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestProperty {} ///:~
