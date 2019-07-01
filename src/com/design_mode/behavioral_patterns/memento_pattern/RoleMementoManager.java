package com.design_mode.behavioral_patterns.memento_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 * 步骤3.
 * 创建备忘录管理类
 */
public class RoleMementoManager {
    private List<RoleMemento> roleMementos = new ArrayList<>();

    public void add(RoleMemento roleMemento) {
        roleMementos.add(roleMemento);
    }

    // 获取备忘录中的状态信息
    public RoleMemento getRoleMemento(int index) {
        return roleMementos.get(index);
    }
}
