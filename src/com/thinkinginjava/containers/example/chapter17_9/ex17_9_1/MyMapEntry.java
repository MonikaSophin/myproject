package com.thinkinginjava.containers.example.chapter17_9.ex17_9_1;

import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description:
 * 可以仿照 {@link java.util.AbstractMap.SimpleEntry}
 */
public class MyMapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;
    public MyMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public K getKey() { return key; }
    @Override
    public V getValue() { return value; }
    @Override
    public V setValue(V value) {
        V result = value;
        this.value = value;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyMapEntry)) return false;
        MyMapEntry me = (MyMapEntry)o;
        return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
                (value == null ? me.getValue() == null : value.equals(me.getValue()));
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    @Override
    public String toString() { return String.format("%s=%s", key, value); }
}
