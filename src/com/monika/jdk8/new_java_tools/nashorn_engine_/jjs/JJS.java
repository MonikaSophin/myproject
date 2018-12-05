package com.monika.jdk8.new_java_tools.nashorn_engine_.jjs;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/5
 * @description:
 */
public class JJS {
    /**
     * jjs是个基于Nashorn引擎的命令行工具。它接受一些JavaScript源代码为参数，并且执行这些源代码。
     * 例如，我们创建一个具有如下内容的func.js文件：
     * function f() {
     *      return 1;
     * };
     * print( f() + 1 );
     *
     * 我们可以把这个文件作为参数传递给jjs使得这个文件可以在命令行中执行：
     * jjs func.js
     *
     * 下面是程序在控制台上的输出：
     * 2
     *
     * 更多详情请参考官方文档
     */
}
