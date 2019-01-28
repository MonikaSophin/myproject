package com.thinkinginjava.type_information.exercise.chapter14_4;

import com.thinkinginjava.type_information.example.chapter14_4.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: monika
 * @Date: 2019/1/26 19:05
 * @Version: 1.0
 * @Description: page 333
 * 练习14：构造器就是一种工厂方法。修改RegisteredFactories.java，使其不要使用显式
 * 的工厂，而是价格类对象存储到List中，并使用newInstance()来创建对象。
 */
class Part {
    public String toString() { return this.getClass().getSimpleName(); }
    static List<Class<? extends Part>> partClasses = new ArrayList<>();
    static {
        partClasses.add(FuelFilter.class);
        partClasses.add(AirFilter.class);
        partClasses.add(CabinAirFilter.class);
        partClasses.add(OilFilter.class);
        partClasses.add(FanBelt.class);
        partClasses.add(PowerSteeringBelt.class);
        partClasses.add(GeneratorBelt.class);
    }
    private static Random rand = new Random();
    public static Part createRandom() {
        int n = rand.nextInt(partClasses.size());
        try {
            return partClasses.get(n).newInstance();
        } catch(InstantiationException e) {
            throw new RuntimeException(e);
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        }
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

public class Ex14 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
}
/**output:
 * GeneratorBelt
 * PowerSteeringBelt
 * PowerSteeringBelt
 * AirFilter
 * AirFilter
 * OilFilter
 * OilFilter
 * GeneratorBelt
 * FanBelt
 * AirFilter
 */