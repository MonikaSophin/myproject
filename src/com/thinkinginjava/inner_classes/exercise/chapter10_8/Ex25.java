package com.thinkinginjava.inner_classes.exercise.chapter10_8;

/**
 * @Author: monika
 * @Date: 2018/12/9 19:50
 * @Version: 1.0
 * @Description: page 212
 * 练习25:在GreenhouseControls.java中继承GreenhouseControls，增加Event内部类，用
 * 以开启，关闭喷水机。写一个新版的GreenhouseControls.java以使用这些新的Event对象。
 */
class GreenhouseControls25 extends GreenhouseControls24 {
    private boolean waterMist = false;
    public class WaterMistOn extends Event {
        public WaterMistOn(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here to
            // physically turn on water mist generator
            waterMist = true;
        }
        public String toString() {
            return "Water mist generator on";
        }
    }
    public class WaterMistOff extends Event {
        public WaterMistOff(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here to
            // physically turn off water mist generator
            waterMist = false;
        }
        public String toString() {
            return "Water mist generator off";
        }
    }
}
public class Ex25 {
    public static void main(String[] args) {
        GreenhouseControls25 gc = new GreenhouseControls25();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterMistOn(650),
                gc.new WaterMistOff(700),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400),
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if(args.length == 1)
            gc.addEvent(
                    new GreenhouseControls24.Terminate(
                            new Integer(args[0])));
        gc.run();
    }
}
/**输出：
 * Bing!
 * Thermostat on night setting
 * Light is on
 * Light is off
 * Greenhouse water is on
 * Water mist generator on
 * Water mist generator off
 * Greenhouse water is off
 * Thermostat on day setting
 * Restarting system
 */