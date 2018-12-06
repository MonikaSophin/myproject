package com.design_mode.b_observer_pattern;

/**
 *  观察者模式
 *
 *    定义：
 *        在对象之间定义一对多的依赖，这样一来，当一个对象改变状态
 *     依赖它的对象都会收到通知，并自动更新。相当于 订阅者+发布者=观察者模式
 *
 *     注：这种观察者与被观察者(或者说是‘主题’)的关系，在处理被观察者的数据变化(状态更新)时，
 *     有两种方式去进行数据交互：
 *      +  被观察者去push(推)消息给观察者 （推荐使用）
 *      +  观察者去被观察者pull(拉)消息给自己
 *      不同点：
 *      push方式——Observer#update方法传递的是 信息
 *      pull方式——Observer#update方法传递的是 subject (subject要求信息的setter方法)
 */