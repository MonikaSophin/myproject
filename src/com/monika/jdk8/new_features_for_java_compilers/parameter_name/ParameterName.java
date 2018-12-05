package com.monika.jdk8.new_features_for_java_compilers.parameter_name;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/4
 * @description:
 *    很长一段时间里，Java程序员一直在发明不同的方式使得方法参数的名字能保留在Java字节码中，并且能
 * 够在运行时获取它们（比如，Paranamer类库）。最终，在Java 8中把这个强烈要求的功能添加到语言层面
 * （通过反射API与Parameter.getName()方法）与字节码文件（通过新版的javac的–parameters选项）中。
 *
 *    如果不使用–parameters参数来编译这个类，然后运行这个类，会得到下面的输出：
 *       Parameter: arg0
 *    如果使用–parameters参数来编译这个类，程序的结构会有所不同（参数的真实名字将会显示出来）：
 *       Parameter: args
 *    对于有经验的Maven用户，通过maven-compiler-plugin的配置可以将-parameters参数添加到编译器中去。
 *    <code>
 *       <plugin>
 *         <groupId>org.apache.maven.plugins</groupId>
 *         <artifactId>maven-compiler-plugin</artifactId>
 *         <version>3.1</version>
 *         <configuration>
 *              <compilerArgument>-parameters</compilerArgument>
 *              <source>1.8</source>
 *              <target>1.8</target>
 *              </configuration>
 *       </plugin>
 *    </code>
 *
 *    此外，Parameter类有一个很方便的方法isNamePresent()来验证是否可以获取参数的名字。
 */
public class ParameterName {
    public static void main(String[] args) throws NoSuchMethodException {
        Method main = ParameterName.class.getMethod("main", String[].class);
        for (final Parameter parameter : main.getParameters()){
            System.out.println("是否可以获取参数的名字：" + parameter.isNamePresent());
            System.out.println("Parameter: " + parameter.getName());
        }
    }
}
/**输出:
 * 是否可以获取参数的名字：false
 * Parameter: arg0
 */
