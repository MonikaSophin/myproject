package com.monika.proxy.dynamic.self;


/**
 * @author XueYing.Cao
 * @date 2020/5/22
 */
public class MyHandler implements Handler {

    @Override
    public String invoke() {

       return "dynamic invoke ...";
    }
}
