package com.dubbo.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
@Data
public class ProtocolModel implements Serializable {

    private String protocol;
    private String ip;
    private String port;
    private String serviceName;
    private String[] methodNames;
    private Object[] params;
    private Class[] paramType;

    private String[] group;
    private String version;
}
