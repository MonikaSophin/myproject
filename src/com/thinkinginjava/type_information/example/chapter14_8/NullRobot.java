package com.thinkinginjava.type_information.example.chapter14_8;

import com.thinkinginjava.util.Null;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/29
 * @description:
 */
class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    private Robot proxied = new NRobot();
    public NullRobotProxyHandler(Class<? extends Robot> type) { nullName = type.getSimpleName() + " NullRobot"; }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { return method.invoke(proxied, args); }
    private class NRobot implements Null, Robot {
        @Override
        public String name() { return nullName; }
        @Override
        public String model() { return nullName; }
        @Override
        public List<Operation> operations() { return Collections.emptyList(); }
    }
}

public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{Null.class, Robot.class},
                new NullRobotProxyHandler(type));
    }

    public static void main(String[] args) {
        Robot[] bots = {new SnowRemovalRobot("SnowBee"), newNullRobot(SnowRemovalRobot.class)};
        for (Robot bot : bots){
            Robot.Test.test(bot);
            System.out.println();
        }
    }
}
/**output:
 * Robot name: SnowBee
 * Robot model: Snow Series 11
 * SnowBee can shovel snow
 * SnowBee shoveling snow
 * SnowBee can chip ice
 * SnowBee chipping ice
 * SnowBee can clear the roof
 * SnowBee clearing roof
 *
 * [Null Robot]
 * Robot name: SnowRemovalRobot NullRobot
 * Robot model: SnowRemovalRobot NullRobot
 */