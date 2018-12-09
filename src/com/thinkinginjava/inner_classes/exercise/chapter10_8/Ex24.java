package com.thinkinginjava.inner_classes.exercise.chapter10_8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2018/12/9 19:42
 * @Version: 1.0
 * @Description: page 212
 * 练习24：在GreenhouseControls.java中增加一个Event内部类，用以打开、关闭风扇。
 * 配置GreenhouseControls.java以使用这些新的Event对象。
 */
class Controller {
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event c) { eventList.add(c); }
    public void run() {
        while ( eventList.size() > 0)
            for (Event e : new ArrayList<>(eventList))
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
    }
}

abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() { // Allows restarting
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}

class GreenhouseControls24 extends Controller {
    private boolean fan = false;
    public class FanOn extends Event {
        public FanOn(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here to
            // physically turn on the fan.
            fan = true;
        }
        public String toString() { return "Fan is on"; }
    }
    public class FanOff extends Event {
        public FanOff(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control here to
            // physically turn off the fan.
            fan = false;
        }
        public String toString() { return "Fan is off"; }
    }
    private boolean light = false;
    public class LightOn extends Event {
        public LightOn(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here to
            // physically turn on the light.
            light = true;
        }
        public String toString() { return "Light is on"; }
    }
    public class LightOff extends Event {
        public LightOff(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control here to
            // physically turn off the light.
            light = false;
        }
        public String toString() { return "Light is off"; }
    }
    private boolean water = false;
    public class WaterOn extends Event {
        public WaterOn(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here
            water = true;
        }
        public String toString() {
            return "Greenhouse water is on";
        }
    }
    public class WaterOff extends Event {
        public WaterOff(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here
            water = false;
        }
        public String toString() {
            return "Greenhouse water is off";
        }
    }
    private String thermostat = "Day";
    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here
            thermostat = "Night";
        }
        public String toString() {
            return "Thermostat on night setting";
        }
    }
    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here
            thermostat = "Day";
        }
        public String toString() {
            return "Thermostat on day setting";
        }
    }
    // An example of an action() that inserts a
    // new one of itself into the event list:
    public class Bell extends Event {
        public Bell(long delayTime) { super(delayTime); }
        public void action() {
            addEvent(new Bell(delayTime));
        }
        public String toString() { return "Bing!"; }
    }
    public class Restart extends Event {
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for(Event e : eventList)
                addEvent(e);
        }
        public void action() {
            for(Event e : eventList) {
                e.start(); // Rerun each event
                addEvent(e);
            }
            start(); // Rerun this Event
            addEvent(this);
        }
        public String toString() {
            return "Restarting system";
        }
    }
    public static class Terminate extends Event {
        public Terminate(long delayTime) { super(delayTime); }
        public void action() { System.exit(0); }
        public String toString() { return "Terminating"; }
    }
}

public class Ex24 {
    public static void main(String[] args) {
        GreenhouseControls24 gc = new GreenhouseControls24();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new FanOn(300),
                gc.new LightOff(400),
                gc.new FanOff(500),
                gc.new WaterOn(600),
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
 * Fan is on
 * Light is off
 * Fan is off
 * Greenhouse water is on
 * Greenhouse water is off
 * Thermostat on day setting
 * Restarting system
 */