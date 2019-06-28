package com.design_mode.structural_patterns.proxy_pattern;

import com.design_mode.structural_patterns.proxy_pattern.model.Me;
import com.design_mode.structural_patterns.proxy_pattern.model.Shopping;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 步骤3.
 * 静态代理类，要将目标对象传入
 */
public class StaticProxy implements Shopping {

    private Shopping me;

    @Override
    public void shopping() {
        if (me == null) {
            me = new Me();
        }
        me.shopping();
        System.out.println("静态代理--shopping");
    }
}
