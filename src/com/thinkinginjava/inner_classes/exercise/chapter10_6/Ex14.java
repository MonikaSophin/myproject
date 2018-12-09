package com.thinkinginjava.inner_classes.exercise.chapter10_6;

/**
 * @Author: monika
 * @Date: 2018/12/6 22:22
 * @Version: 1.0
 * @Description: page 199
 * 练习14：修改interface/HorrorShow.java，用匿名类实现DangerousMonster和Vampire。
 */
interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    public void menace() {}
    public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    public void menace() {}
    public void destroy() {}
    public void kill() {}
    public void drinkBlood() {}
}

class HorrorShow14 {
    static void u(Monster b) { b.menace(); }
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    static void w(Lethal l) { l.kill(); }
    public DangerousMonster monsterMaker() {
        return new DangerousMonster() {
            public void menace() { System.out.println("DangerousMonster Menace"); }
            public void destroy() { System.out.println("DangerousMonster Destroy"); }
        };
    }
    public Vampire vampireMaker() {
        return new Vampire() {
            public void menace() { System.out.println("Vampire Menace"); }
            public void destroy() { System.out.println("Vampire Destroy"); }
            public void kill() { System.out.println("Vampire Kill"); }
            public void drinkBlood() { System.out.println("Vampire DrinkBlood"); }
        };
    }
}

public class Ex14 {
    public static void main(String[] args) {
        HorrorShow14 show = new HorrorShow14();
        show.u(show.monsterMaker());
        show.v(show.monsterMaker());
        show.u(show.vampireMaker());
        show.v(show.vampireMaker());
        show.w(show.vampireMaker());
    }
}
/**输出：
 * DangerousMonster Menace
 * DangerousMonster Menace
 * DangerousMonster Destroy
 * Vampire Menace
 * Vampire Menace
 * Vampire Destroy
 * Vampire Kill
 */