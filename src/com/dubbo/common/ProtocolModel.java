package com.dubbo.common;

import lombok.Data;

/**
 * @author XueYing.Cao
 * @date 2020/5/27
 */
@Data
public class ProtocolModel {

    private String protocol;
    private String ip;
    private String port;
    private String serviceName;
    private String[] methodNames;
    private String[] group;
    private String version;
}
