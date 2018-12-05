package com.monika.jdk8.new_features_for_java.better_type_inference_mechanism;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/4
 * @description:
 */
public class Value<T> {
    public static<T> T defaultValue(){
        return null;
    }
    public T getOrDefault(T value, T defaultValue){
        return (value != null)? value : defaultValue;
    }
}
