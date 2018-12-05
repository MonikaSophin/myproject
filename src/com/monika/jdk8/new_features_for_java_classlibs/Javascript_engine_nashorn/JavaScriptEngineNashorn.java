package com.monika.jdk8.new_features_for_java_classlibs.Javascript_engine_nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/5
 * @description:
 *   Nashorn，一个新的JavaScript引擎随着Java 8一起公诸于世，它允许在JVM上开发运行某些JavaScript应用。
 * Nashorn就是javax.script.ScriptEngine的另一种实现，并且它们俩遵循相同的规则，允许Java与JavaScript
 * 相互调用。下面看一个例子：
 */
public class JavaScriptEngineNashorn {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        System.out.println(engine.getClass().getName());
        System.out.println("Result； " + engine.eval("function f() { return 1; }; f() + 1;"));
    }
}
/**输出：
 * jdk.nashorn.api.scripting.NashornScriptEngine
 * Result； 2.0
 */