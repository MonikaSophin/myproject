package com.thinkinginjava.type_information.example.chapter14_8;

import com.thinkinginjava.util.Null;
import java.util.Arrays;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/29
 * @description:
 */
interface Operation {
    String description();
    void command();
}

interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test {
        public static void test(Robot r) {
            if (r instanceof Null)
                System.out.println("[Null Robot]");
            System.out.println("Robot name: " + r.name());
            System.out.println("Robot model: " + r.model());
            for (Operation operation : r.operations()){
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}

public class SnowRemovalRobot implements Robot {
    private String name;
    public SnowRemovalRobot(String name) { this.name = name; }
    @Override
    public String name() { return name; }
    @Override
    public String model() { return "Snow Series 11"; }
    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String description() { return name + " can shovel snow"; }
                    @Override
                    public void command() { System.out.println(name + " shoveling snow"); }
                },
                new Operation() {
                    @Override
                    public String description() { return name + " can chip ice"; }
                    @Override
                    public void command() { System.out.println(name + " chipping ice");
                    }
                },
                new Operation() {
                    @Override
                    public String description() { return name + " can clear the roof"; }
                    @Override
                    public void command() { System.out.println(name + " clearing roof");
                    }
                });
    }

    public static void main(String[] args) { Robot.Test.test(new SnowRemovalRobot("Slusher")); }
}
/**output:
 * Robot name: Slusher
 * Robot model: Snow Series 11
 * Slusher can shovel snow
 * Slusher shoveling snow
 * Slusher can chip ice
 * Slusher chipping ice
 * Slusher can clear the roof
 * Slusher clearing roof
 */