package com.dubbo.protocol;

import com.dubbo.common.model.Invocation;
import com.dubbo.common.model.URL;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
public interface Protocol {

    void start(URL url);

    String send(URL url, Invocation invocation);
}
