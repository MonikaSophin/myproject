package com.design_mode.behavioral_patterns.memento_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        //1.游戏角色的初始状态
        GameRole role = new GameRole();
        role.setAggressivity(100);
        role.setDefencivity(100);
        role.setVitality(100);
        System.out.println("游戏刚开始，角色各属性:");
        role.showState();


        //2.备忘录管理类保存游戏角色状态
        RoleMementoManager manager = new RoleMementoManager();
        System.out.println("\n【保存游戏状态！】\n");
        RoleMemento roleMemento1 = role.saveToMemento();
        manager.add(roleMemento1);

        //3.开始打boss
        role.setAggressivity(20);
        role.setDefencivity(30);
        role.setVitality(0);
        System.out.println("与Boss对战后，角色各项能力已大大下降:");
        role.showState();

        //4.恢复保存的角色状态
        RoleMemento roleMemento = manager.getRoleMemento(0);
        role.loadFromMemento(roleMemento);
        System.out.println("\n【恢复保存的角色状态！】");
        System.out.println("\n恢复后角色的当前状态：");
        role.showState();
    }
}
/**output:
 * 游戏刚开始，角色各属性:
 * 攻击力：100|防御力：100|生命力：100
 *
 * 【保存游戏状态！】
 *
 * 与Boss对战后，角色各项能力已大大下降:
 * 攻击力：20|防御力：30|生命力：0
 *
 * 【恢复保存的角色状态！】
 *
 * 恢复后角色的当前状态：
 * 攻击力：100|防御力：100|生命力：100
 */