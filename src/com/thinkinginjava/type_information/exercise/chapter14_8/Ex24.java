package com.thinkinginjava.type_information.exercise.chapter14_8;

import com.thinkinginjava.type_information.example.chapter14_4.Factory;
import com.thinkinginjava.type_information.example.chapter14_8.Null;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/29
 * @description: page 346
 * 练习24：在RegisteredFactories.java中添加空对象。
 */
class Part {
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        partFactories.add(new FuelFilter.Factory1());
        partFactories.add(new AirFilter.Factory1());
        partFactories.add(new CabinAirFilter.Factory1());
        partFactories.add(new OilFilter.Factory1());
        partFactories.add(new FanBelt.Factory1());
        partFactories.add(new PowerSteeringBelt.Factory1());
        partFactories.add(new GeneratorBelt.Factory1());
        partFactories.add(new NullFilter.Factory1());
    }
    private static Random rand = new Random(47);
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    // Create a Class Factory for each specific type:
    public static class Factory1 implements Factory<FuelFilter> {
        public FuelFilter create() { return new FuelFilter(); }
    }
}

class AirFilter extends Filter {
    public static class Factory1 implements Factory<AirFilter> {
        public AirFilter create() { return new AirFilter(); }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory1 implements Factory<CabinAirFilter> {
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory1 implements Factory<OilFilter> {
        public OilFilter create() { return new OilFilter(); }
    }
}

class NullFilter extends Filter implements Null{
    public static class Factory1 implements Factory<NullFilter> {
        public NullFilter create() { return new NullFilter(); }
    }
}



class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory1 implements Factory<FanBelt> {
        public FanBelt create() { return new FanBelt(); }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory1 implements Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory1 implements Factory<PowerSteeringBelt> {
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class Ex24 {
    public static void main(String[] args) {
        for(int i = 0; i < 12; i++){
            Part part = Part.createRandom();
            if (Null.class.isInstance(part))
                System.out.println(part + " [NULL]");
            else
                System.out.println(part);
        }
    }
}
/**output:
 * PowerSteeringBelt
 * OilFilter
 * FanBelt
 * FuelFilter
 * AirFilter
 * FanBelt
 * AirFilter
 * OilFilter
 * FanBelt
 * PowerSteeringBelt
 * CabinAirFilter
 * NullFilter [NULL]
 */