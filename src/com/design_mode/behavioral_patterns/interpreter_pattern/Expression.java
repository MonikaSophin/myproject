package com.design_mode.behavioral_patterns.interpreter_pattern;

/**
 * @Author: monika
 * @Date: 2019/6/30 21:49
 * @Version: 1.0
 * @Description:
 * 步骤1.
 * 创建解释器接口
 */
public interface Expression {

    // 对应的解释方法
    int interpret(Context context);
}
