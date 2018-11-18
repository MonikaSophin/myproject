package com.thinkinginjava.reusing_classes.exercise.chapter7_8;

/**
 * @Author: monika
 * @Date: 2018/11/18 12:16
 * @Version: 1.0
 * @Description:
 */
class AClass{
    final void f(){ System.out.println("AClass#f()"); }
    void g(){
        System.out.println("AClass#g()");
        f();
    }
}

public class Ex21 extends AClass{
    //error:'f()' cannot override 'f()' in 'AClass'; overridden method is final
    //! @Override
    //! void f(){}

    @Override
    void g(){
        System.out.println("Ex21#g();");
    }

    public static void main(String[] args) {
        Ex21 ex21 = new Ex21();
        ex21.g();
        ex21.f();

        AClass aClass = ex21;
        aClass.g();
        aClass.f();
    }
}
/**输出：
 * Ex21#g();
 * AClass#f()
 * Ex21#g();
 * AClass#f()
 */
