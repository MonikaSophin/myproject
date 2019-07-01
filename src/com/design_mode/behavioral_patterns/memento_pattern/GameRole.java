package com.design_mode.behavioral_patterns.memento_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 * 步骤1.
 * 创建游戏角色类，其中包含状态
 */
public class GameRole {

    private int aggressivity;//攻击力
    private int defencivity;//防御力
    private int vitality;//生命力

    public void showState() {
        System.out.println("攻击力：" + this.aggressivity + "|防御力：" + this.defencivity
                + "|生命力：" + this.vitality);
    }

    //保存记录至备忘录
    public RoleMemento saveToMemento() {
        RoleMemento roleMemento = new RoleMemento();
        roleMemento.setAggressivity(this.aggressivity);
        roleMemento.setDefencivity(this.defencivity);
        roleMemento.setVitality(this.vitality);
        return roleMemento;
    }

    //获取备忘录中的状态信息
    public void loadFromMemento(RoleMemento roleMemento) {
        this.aggressivity = roleMemento.getAggressivity();
        this.defencivity = roleMemento.getDefencivity();
        this.vitality = roleMemento.getVitality();
    }

    public int getAggressivity() {
        return aggressivity;
    }

    public int getDefencivity() {
        return defencivity;
    }

    public int getVitality() {
        return vitality;
    }

    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }

    public void setDefencivity(int defencivity) {
        this.defencivity = defencivity;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }
}
