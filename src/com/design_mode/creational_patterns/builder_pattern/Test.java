package com.design_mode.creational_patterns.builder_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Director director = new Director();

        Builder asusBuilder = new ASUSBuilder();
        Computer asus = director.builder(asusBuilder);
        System.out.println(asus);

        Builder dellBuilder = new DELLBuilder();
        Computer dell = director.builder(dellBuilder);
        System.out.println(dell);

        System.out.println("--------------------------");

        NewComputer newComputer = new NewComputer.Builder()
                .brand("brand")
                .cpu("cpu")
                .mainBoard("mainBoard")
                .hardDisk("hardDisk")
                .displayCard("displayCard")
                .power("power")
                .build();
        System.out.println(newComputer);
    }
}
/**output:
 * Computer{brand='华硕电脑', cpu='Intel 第8代 酷睿', mainBoard='华硕主板', hardDisk='256GB SSD', displayCard='MX150 独立2GB', power='3芯 锂离子电池 65W AC适配器', memory='1 x SO-DIMM  8GB'}
 * Computer{brand='戴尔电脑', cpu='i5-8300H 四核', mainBoard='戴尔主板', hardDisk='1T + 128GB SSD', displayCard='GTX1060 独立6GB', power='4芯 锂离子电池 180W AC适配器', memory='4G + 4G'}
 * --------------------------
 * NewComputer{brand='brand', cpu='cpu', mainBoard='mainBoard', hardDisk='hardDisk', displayCard='displayCard', power='power', memory='null'}
 */