package com.design_mode.structural_patterns.proxy_pattern;

/**
 *  2.8 代理模式
 *
 *    定义：为其他对象提供一种代理以控制对这个对象的访问。在某些情况下，一个对象不适合或者
 *    不能直接引用另一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用。
 *        著名的代理模式例子为引用计数（英语：reference counting）指针对象。
 *
 *    注意事项： 1、和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。
 *              2、和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制。
 *
 *   三种代理模式:
 *    ① 静态代理
 *    ② JDK动态代理 InvocationHandler#invoke()
 *    ③ cglib动态代理 MethodInterceptor#intercept()、Enhancer
 */