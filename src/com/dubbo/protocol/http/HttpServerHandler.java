package com.dubbo.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.dubbo.common.model.Invocation;
import com.dubbo.registry.impl.RemoteRegistry;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {

        try {
            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);

            String interfaceName = invocation.getInterfaceName();
            Class implClass = RemoteRegistry.getImpl(interfaceName);
            Method method = implClass.getMethod(invocation.getMethodNames()[0], invocation.getParameterTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParameters());

            System.out.println("tomcat:" + result);
            IOUtils.write(result, resp.getOutputStream());
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
