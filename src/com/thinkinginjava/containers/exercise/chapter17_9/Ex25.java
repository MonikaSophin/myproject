package com.thinkinginjava.containers.exercise.chapter17_9;

import com.thinkinginjava.util.Countries;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/1
 * @description: page 495
 * 练习25：修改MyMapEntry，使其成为一种自包含的单向链表（每个MyMapEntry应该都有一
 * 个指向下一个MyMapEntry的前向链接），从而不用对每个桶位都使用ListIterator。修改
 * SimpleHashMap.java中其余的代码，使得这种新方式可以正确地工作。
 */
class SimpleHashMap25<K,V> extends AbstractMap<K,V> {
    class MyMapEntry25<K,V> implements Map.Entry<K,V> {
        private K key;
        private V value;
        private MyMapEntry25<K,V> nextEntry = null;
        public MyMapEntry25(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
        public V setValue(V v) {
            V result = value;
            value = v;
            return result;
        }
        public MyMapEntry25<K,V> getNextEntry() {
            return this.nextEntry;
        }
        public void setNextEntry(MyMapEntry25<K,V> nextEntry) {
            this.nextEntry = nextEntry;
        }
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }
        public boolean equals(Object o) {
            if(!(o instanceof MyMapEntry25)) return false;
            MyMapEntry25 me = (MyMapEntry25)o;
            return
                    (key == null ?
                            me.getKey() == null : key.equals(me.getKey())) &&
                            (value == null ?
                                    me.getValue() == null : value.equals(me.getValue()));
        }
        public String toString() { return key + "=" + value; }
    }

    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<MyMapEntry25<K,V>>[] buckets = new LinkedList[SIZE];
    public V put(K key, V value) {
        V oldValue = null;
        MyMapEntry25<K,V> pair = new MyMapEntry25<>(key, value);
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) {
            buckets[index] = new LinkedList<>();
            LinkedList<MyMapEntry25<K,V>> bucket = buckets[index];
            bucket.add(pair);
        }
        LinkedList<MyMapEntry25<K,V>> bucket = buckets[index];
        if(buckets[index].size() > 0) {
            for(MyMapEntry25<K,V> entry = bucket.get(0); entry != null;
                entry = entry.getNextEntry()) {
                if(entry.getKey().equals(key)) {
                    oldValue = entry.getValue();
                    entry.setValue(value);
                    return oldValue;
                }
            }
            bucket.add(pair);
            int i = bucket.indexOf(pair);
            if(i > 0) {
                bucket.get(i - 1).setNextEntry(pair);
            }
            return pair.getValue();
        }
        return oldValue;
    }
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for(MyMapEntry25<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }
    public Set<Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for(LinkedList<MyMapEntry25<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MyMapEntry25<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }
}

public class Ex25 {
    public static void main(String[] args) {
        SimpleHashMap25<String,String> m = new SimpleHashMap25<>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        System.out.println(m.put("BENIN","New York?"));
        System.out.println(m.get("BENIN"));
        System.out.println(m.entrySet());
    }
}
/**output:
 * {ANGOLA=Luanda, BURKINA FASO=Ouagadougou, BENIN=Porto-Novo, ALGERIA=Algiers, BOTSWANA=Gaberone}
 * Porto-Novo
 * New York?
 * [ANGOLA=Luanda, BURKINA FASO=Ouagadougou, BENIN=New York?, ALGERIA=Algiers, BOTSWANA=Gaberone]
 */