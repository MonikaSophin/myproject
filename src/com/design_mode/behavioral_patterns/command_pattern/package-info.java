package com.design_mode.behavioral_patterns.command_pattern;
/**
 *  3.2 命令模式
 *
 *    定义：请求以命令的形式包裹在对象中，并传给调用对象。
 *    调用对象寻找可以处理该命令的合适的对象，并把该命令
 *    传给相应的对象，该对象执行命令。
 *
 *    关键代码：定义三个角色：1、Execute/receiver 真正的命令执行对象
 *                        2、Command 命令对象
 *                        3、Invoker 使用命令对象的入口
 */