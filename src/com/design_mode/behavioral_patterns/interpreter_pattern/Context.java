package com.design_mode.behavioral_patterns.interpreter_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: monika
 * @Date: 2019/6/30 21:56
 * @Version: 1.0
 * @Description:
 * 步骤2.
 * 定义上下文对象
 */
public class Context {
    private Map<Expression, Integer> map = new HashMap<>();

    //定义变量
    public void add(Expression s, Integer value){
        map.put(s, value);
    }

    //将变量转换成数字
    public int cast(Expression s){
        return map.get(s);
    }
}
