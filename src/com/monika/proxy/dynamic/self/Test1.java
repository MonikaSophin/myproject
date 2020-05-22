package com.monika.proxy.dynamic.self;

import com.monika.proxy.dynamic.Service;
import com.monika.proxy.dynamic.ServiceImpl;


/**
 * @author XueYing.Cao
 * @date 2020/5/22
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        ProxyUtils proxyUtils = new ProxyUtils();
        Service service = (Service) proxyUtils.newIntance(new ServiceImpl(), new MyHandler());
        service.doSomething();
    }
}
