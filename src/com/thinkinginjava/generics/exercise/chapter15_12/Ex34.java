package com.thinkinginjava.generics.exercise.chapter15_12;

/**
 * @Author: monika
 * @Date: 2019/2/17 21:13
 * @Version: 1.0
 * @Description: page 409
 * 练习34：创建一个自限定的泛型类型，它包含一个abstract方法，这个方法将接受一个
 * 泛型类型参数，并产生具有这个泛型类型参数的返回值。在这个类的非abstract方法中，
 * 调用这个abstract方法，并返回其结果。继承这个自限定类型，并测试所产生的类。
 */
abstract class SelfBound<T extends SelfBound<T>> {
    abstract T setAndGet(T arg);
    void f(T arg) {
        T t = setAndGet(arg);
        System.out.println(t.getClass().getSimpleName());
    }
}

class S1 extends SelfBound<S1> {
    @Override
    S1 setAndGet(S1 arg) { return arg; }
}

class S2 extends SelfBound<S1> { // 这样也可以
    @Override
    S1 setAndGet(S1 arg) { return arg; }
}

class S3 extends SelfBound<S3> {
    @Override
    S3 setAndGet(S3 arg) { return arg; }
}

public class Ex34 {
    public static void main(String[] args) {
        S1 s1 = new S1();
        S2 s2 = new S2();
        S3 s3 = new S3();
        SelfBound sb1 = new S1();
        SelfBound sb2 = new S2();
        SelfBound sb3 = new S3();

        s1.f(s1); //只能接受S1类型
        //! s1.f(s2);
        //! s1.f(s3);
        //! s1.f(sb1);
        //! s1.f(sb2);
        //! s1.f(sb3);

        s2.f(s1);//只能接受S1类型
        //! s2.f(s2);
        //! s2.f(s3);
        //! s2.f(sb1);
        //! s2.f(sb2);
        //! s2.f(sb3);

        s3.f(s3);//只能接受S3类型
        //! s3.f(s1);
        //! s3.f(s2);
        //! s3.f(sb1);
        //! s3.f(sb2);
        //! s3.f(sb3);
    }
}
/**output;
 * S1
 * S1
 * S3
 */