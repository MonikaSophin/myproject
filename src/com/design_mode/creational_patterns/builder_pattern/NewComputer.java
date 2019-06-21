package com.design_mode.creational_patterns.builder_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description: 将builder与director作为静态内部类
 */
public class NewComputer {
    private String brand;
    private String cpu;
    private String mainBoard;
    private String hardDisk;
    private String displayCard;
    private String power;
    private String memory;

    private NewComputer() {}

    private NewComputer(Builder builder) {
        brand = builder.brand;
        cpu = builder.cpu;
        mainBoard = builder.mainBoard;
        hardDisk = builder.hardDisk;
        displayCard = builder.displayCard;
        power = builder.power;
        memory = builder.memory;
    }

    public static final class Builder {
        private String brand;
        private String cpu;
        private String mainBoard;
        private String hardDisk;
        private String displayCard;
        private String power;
        private String memory;

        public NewComputer build() {
            return new NewComputer(this);
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder mainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this;
        }

        public Builder hardDisk(String hardDisk) {
            this.hardDisk = hardDisk;
            return this;
        }

        public Builder displayCard(String displayCard) {
            this.displayCard = displayCard;
            return this;
        }

        public Builder power(String power) {
            this.power = power;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }
    }

    @Override
    public String toString() {
        return "NewComputer{" +
                "brand='" + brand + '\'' +
                ", cpu='" + cpu + '\'' +
                ", mainBoard='" + mainBoard + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", displayCard='" + displayCard + '\'' +
                ", power='" + power + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }
}
