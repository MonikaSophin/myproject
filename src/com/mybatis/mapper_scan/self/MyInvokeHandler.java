package com.mybatis.mapper_scan.self;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author XueYing.Cao
 * @date 2020/5/15
 */
@Component
public class MyInvokeHandler implements InvocationHandler {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private Class clazz;

    public MyInvokeHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if (StringUtils.equals("toString", method.getName())) {
//            // doSomething();
//        }

//        Select select = method.getAnnotation(Select.class);
//        sqlSessionFactory.openSession().selectList(select.value()[0]);
//        method.invoke(clazz);


        return proxy.getClass().getSimpleName();
    }
}
