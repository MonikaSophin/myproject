package com.dubbo.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XueYing.Cao
 * @date 2020/5/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invocation {
    private String interfaceName;
    private String[] methodNames;
    private Class[] parameterTypes;
    private Object[] parameters;
}
