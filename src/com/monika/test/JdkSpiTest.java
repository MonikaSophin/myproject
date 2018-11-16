package com.monika.test;

import com.monika.test.domain.SpiService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: XueYing.Cao
 * @date: 2018/11/16
 * @description:  JDK spi服务扩展机制
 *
 */
public class JdkSpiTest {
    public static void main(String[] args) {
        ServiceLoader<SpiService> serviceLoader = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> it = serviceLoader.iterator();
        while (it != null && it.hasNext()) {
            SpiService spiService = it.next();
            System.out.println("class:" + spiService.getClass().getName() + " --- "
                    + spiService.sayHi("World"));
        }
    }
}
/**输出：
 * class:com.monika.test.domain.SpiService1 --- Hi World
 * class:com.monika.test.domain.SpiService2 --- 你好 World
 */