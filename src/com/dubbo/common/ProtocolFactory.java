package com.dubbo.common;

import com.dubbo.protocol.Protocol;
import com.dubbo.protocol.http.HttpProtocol;
import org.apache.dubbo.rpc.protocol.dubbo.DubboProtocol;

public class ProtocolFactory {

    public static Protocol getProtocol(ProtocolModel protocolModel) {
        String name = protocolModel.getProtocol();
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
