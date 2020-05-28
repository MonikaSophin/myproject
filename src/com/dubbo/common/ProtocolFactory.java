package com.dubbo.common;

import com.dubbo.common.model.URL;
import com.dubbo.protocol.Protocol;
import com.dubbo.protocol.http.HttpProtocol;

public class ProtocolFactory {

    public static Protocol getProtocol(URL url) {
        String name = url.getProtocol();
        if (name == null || name.equals("")) name = "http";
        switch (name) {
            case "http":
                return new HttpProtocol();
//            case "dubbo":
//                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
