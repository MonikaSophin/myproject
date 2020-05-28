package com.dubbo.consumer;

import com.dubbo.common.reference.ExecuteConsumerTask;
import com.dubbo.common.model.URL;
import com.dubbo.common.reference.ReferenceConfig;
import com.dubbo.service.TestService;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
public class Consumer {

    public static void main(String[] args) {

        URL url = new URL("http", TestService.class.getSimpleName());
        ReferenceConfig referenceConfig = new ReferenceConfig();
        referenceConfig.setUrl(url);
        referenceConfig.setInterfaceClass(TestService.class);

        TestService testService = ExecuteConsumerTask.execute(referenceConfig);
        System.out.println(testService.sayHello("xxx"));
    }
}
