package com.monika.jdk8.new_java_tools.class_depends_parser_jdeps;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/5
 * @description:
 */
public class jdeps {
    /**
     * jdeps是一个很有用的命令行工具。它可以显示Java类的包级别或类级别的依赖。它接受一个.class文件，
     * 一个目录，或者一个jar文件作为输入。jdeps默认把结果输出到系统输出（控制台）上。
     *
     * 下面我们查看现阶段较流行的Spring框架类库的依赖报告，为了简化这个例子，我们只分析一个jar文件：
     * org.springframework.core-3.0.5.RELEASE.jar
     *
     * jdeps org.springframework.core-3.0.5.RELEASE.jar
     * 这个命令输出的内容很多，所以这里我们只选取一小部分。依赖信息按照包名进行分组。如果依赖不在
     * classpath中，那么就会显示not found。
     *
     * org.springframework.core-3.0.5.RELEASE.jar -> C:\Program Files\Java\jdk1.8.0\jre\lib\rt.jar
     *    org.springframework.core (org.springframework.core-3.0.5.RELEASE.jar)
     *       -> java.io
     *       -> java.lang
     *       -> java.lang.annotation
     *       -> java.lang.ref
     *       -> java.lang.reflect
     *       -> java.util
     *       -> java.util.concurrent
     *       -> org.apache.commons.logging                         not found
     *       -> org.springframework.asm                            not found
     *       -> org.springframework.asm.commons                    not found
     *    org.springframework.core.annotation (org.springframework.core-3.0.5.RELEASE.jar)
     *       -> java.lang
     *       -> java.lang.annotation
     *       -> java.lang.reflect
     *       -> java.util
     *
     * 更多详情请参考官方文档
     */
}
