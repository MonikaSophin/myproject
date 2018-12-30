package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_11;

/**
 * @Author: monika
 * @Date: 2018/12/30 16:31
 * @Version: 1.0
 * @Description: page 276
 * 练习25：建立一个三层的异常继承体系，然后创建基类A，它的一个方法能抛出异常体系
 * 的基类异常。让B继承A，并且覆盖这个方法，让它抛出第二层的异常。让C继承B，再次
 * 覆盖这个方法，让它抛出第三层的异常。在main()里创建一个C类型的对象，把它向上
 * 转型为A，然后调用这个方法。
 */
class LevelOneException extends Exception {
}

class LevelTwoException extends LevelOneException {
}

class LevelThreeException extends LevelTwoException {
}

class A {
    void f() throws LevelOneException {
        throw new LevelOneException();
    }
}

class B extends A {
    @Override
    void f() throws LevelTwoException {
        throw new LevelTwoException();
    }
}

class C extends B {
    @Override
    void f() throws LevelThreeException {
        throw new LevelThreeException();
    }
}

public class Ex25 {
    public static void main(String[] args) {
        System.out.println("A a = new C();");
        A a = new C();
        try {
            a.f();
        } catch (LevelThreeException e) {
            System.out.println("Caught LevelThreeException");
        } catch (LevelTwoException e) {
            System.out.println("Caught LevelTwoException");
        } catch (LevelOneException e) {
            System.out.println("Caught LevelOneException");
        }

        System.out.println("A a2 = new B();");
        A a2 = new B();
        try {
            a2.f();
        } catch (LevelThreeException e) {
            System.out.print("Caught LevelThreeException");
        } catch (LevelTwoException e) {
            System.out.print("Caught LevelTwoException");
        } catch (LevelOneException e) {
            System.out.print("Caught LevelOneException");
        }
    }
}
/**output:
 * A a = new C();
 * Caught LevelThreeException
 * A a2 = new B();
 * Caught LevelTwoException
 */