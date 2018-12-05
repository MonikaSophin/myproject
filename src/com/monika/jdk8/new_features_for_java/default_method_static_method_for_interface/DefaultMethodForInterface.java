package com.monika.jdk8.new_features_for_java.default_method_static_method_for_interface;

import java.util.function.Supplier;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/4
 * @description: Java8 用默认方法与静态方法这两个新概念来扩展接口的声明。
 *     与传统的接口又有些不一样，它允许在已有的接口中添加新方法，而同时又保持了与旧版本代码的兼容性。
 *   默认方法与抽象方法不同之处在于抽象方法必须要求实现，但是默认方法则没有这个要求。相反，每个接口都
 *   必须提供一个所谓的默认实现，这样所有的接口实现者将会默认继承它（如果有必要的话，可以覆盖这个默认
 *   实现）。让我们看看下面的例子：
 */
public class DefaultMethodForInterface {
    private interface Defaulable{
        //使用default关键字声明了默认方法
        default String notRequired(){
            return "Default implementation";
        }
    }

    private static class DefaultableImpl implements Defaulable{
    }

    private static class OverridableImpl implements Defaulable{
        @Override
        public String notRequired() {
            return "Overridden implementation";
        }
    }

    //Java 8带来的另一个有趣的特性是接口可以声明（并且可以提供实现）静态方法。例如：
    private interface DefaulableFactory{
        static Defaulable create(Supplier<Defaulable> supplier){
            return supplier.get();
        }
    }
    //下面的一小段代码片段把上面的默认方法与静态方法黏合到一起。
    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable.notRequired());
        defaulable = DefaulableFactory.create(OverridableImpl::new);
        System.out.println(defaulable.notRequired());
    }
}
/**
 *   在JVM中，默认方法的实现是非常高效的，并且通过字节码指令为方法调用提供了支持。默认方法
 * 允许继续使用现有的Java接口，而同时能够保障正常的编译过程。这方面好的例子是大量的方法被
 * 添加到java.util.Collection接口中去：stream()，parallelStream()，forEach()，removeIf()，……
 *   尽管默认方法非常强大，但是在使用默认方法时我们需要小心注意一个地方：在声明一个默认方法前，
 * 请仔细思考是不是真的有必要使用默认方法，因为默认方法会带给程序歧义，并且在复杂的继承体系中
 * 容易产生编译错误。更多详情请参考官方文档。
 */
/**输出：
 * Default implementation
 * Overridden implementation
 */