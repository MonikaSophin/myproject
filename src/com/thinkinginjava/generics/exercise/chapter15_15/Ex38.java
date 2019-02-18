package com.thinkinginjava.generics.exercise.chapter15_15;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description: page 415
 * 练习38：从基本的咖啡入手，创建一个简单的装饰器系统，然后提供可以到倒入牛奶、
 * 泡沫、巧克力、焦糖和生奶油的装饰器。
 */
class BasicCoffee {
    private static long counter = 0;
    private final long id = counter++;
    private String value;
    public void set(String val) { value = val; }
    public String get() { return value; }
    @Override
    public String toString() { return getClass().getSimpleName() + " " + id; }
}

class Decorator extends BasicCoffee {
    protected BasicCoffee basicCoffee;
    public Decorator(BasicCoffee basicCoffee) { this.basicCoffee = basicCoffee; }
    @Override
    public void set(String val) { basicCoffee.set(val); }
    @Override
    public String get() { return basicCoffee.get(); }
}

class SteamedMilk extends Decorator {
    private final String steamedMilk = "steamedMilk";
    public SteamedMilk(BasicCoffee basicCoffee) { super(basicCoffee); }
    public String getSteamedMilk() { return steamedMilk; }
}

class Foam extends Decorator {
    private final String foam = "foam";
    public Foam(BasicCoffee basicCoffee) { super(basicCoffee); }
    public String getFoam() { return foam; }
}

class Chocolate extends Decorator {
    private final String chocolate = "chocolate";
    public Chocolate(BasicCoffee basicCoffee) { super(basicCoffee); }
    public String getChocolate() { return chocolate; }
}

class Caramel extends Decorator {
    private final String caramel = "caramel";
    public Caramel(BasicCoffee basicCoffee) { super(basicCoffee); }
    public String getCaramel() { return caramel; }
}

class WhippedCream extends Decorator {
    private final String whippedCream = "whippedCream";
    public WhippedCream(BasicCoffee basicCoffee) { super(basicCoffee); }
    public String getWhippedCream() { return whippedCream; }
}

public class Ex38 {
    public static void main(String[] args) {
        SteamedMilk sm = new SteamedMilk(new BasicCoffee());
        System.out.println(sm);

        SteamedMilk sm2 = new SteamedMilk(
                new Foam(new BasicCoffee()));
        System.out.println(sm2);

        Chocolate c = new Chocolate(new BasicCoffee());
        System.out.println(c);

        WhippedCream wc = new WhippedCream(new Caramel(
                new Chocolate(new Foam(new SteamedMilk(
                        new BasicCoffee())))));
        System.out.println(wc);
    }
}
/**output:
 * SteamedMilk 1
 * SteamedMilk 4
 * Chocolate 6
 * WhippedCream 12
 */