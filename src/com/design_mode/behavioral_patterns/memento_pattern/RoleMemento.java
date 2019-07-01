package com.design_mode.behavioral_patterns.memento_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 * 步骤2.
 * 创建备忘录 -- 角色状态的备忘录
 */
public class RoleMemento {

    private int aggressivity;//攻击力
    private int defencivity;//防御力
    private int vitality;//生命力

    public int getAggressivity() {
        return aggressivity;
    }

    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }

    public int getDefencivity() {
        return defencivity;
    }

    public void setDefencivity(int defencivity) {
        this.defencivity = defencivity;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }
}
