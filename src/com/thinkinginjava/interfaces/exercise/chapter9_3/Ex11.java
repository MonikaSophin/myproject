package com.thinkinginjava.interfaces.exercise.chapter9_3;

import com.thinkinginjava.interfaces.example.chapter9_3.interfaceprocessor.Apply;
import com.thinkinginjava.interfaces.example.chapter9_3.interfaceprocessor.Processor;

/**
 * @Author: monika
 * @Date: 2018/11/25 11:22
 * @Version: 1.0
 * @Description: page 178
 * 练习11：创建一个类，它有一个方法用于接受一个String类型的参数，生成的结果是将
 * 该参数中的每一对字符进行互换。对该类进行适配，使得它可以用于interfaceprocesser.Apply.proces()。
 */
class StringMixerAdapter implements Processor {
    public String name() { return "StringMixerAdapter"; }
    StringMixer stringMixer;
    public StringMixerAdapter(StringMixer stringMixer) {
        this.stringMixer = stringMixer;
    }
    public String process(Object input) {
        return stringMixer.process((String)input);
    }
}

public class Ex11 {
    public static void main(String[] args) {
        String s = "abcde";
        Apply.process(new StringMixerAdapter(new StringMixer()), s);
    }
}
/**输出：
 * Using Processor StringMixerAdapter
 * badce
 */