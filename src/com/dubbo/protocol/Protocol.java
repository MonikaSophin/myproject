package com.dubbo.protocol;

import java.net.URL;

/**
 * 2020/5/26 23:16
 *
 * @author Sakata Gintoki
 * @version 1.0
 * 模拟dubbo多协议
 */
public interface Protocol {
    void start(URL url);

}
