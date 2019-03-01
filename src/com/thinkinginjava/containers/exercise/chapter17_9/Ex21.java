package com.thinkinginjava.containers.exercise.chapter17_9;

import com.thinkinginjava.containers.example.chapter17_9.ex17_9_1.MyMapEntry;
import com.thinkinginjava.util.Countries;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/1
 * @description: page 495
 * 练习21：修改SimpleHashMap，令其能够报告要探询多少次才能发现冲突。也就是说，插入
 * 元素时，对Iterator调用多少次next()才能在LinkedList中发现此元素已经存在。
 */
class SimpleHashMap21<K,V> extends AbstractMap<K,V> {
    // 选择哈希表大小的素数，以实现均匀分布:
    static final int SIZE = 997;
    // 你不能拥有一套物理的泛型，你可以将其转换成一个:
    @SuppressWarnings("unchecked")
    LinkedList<MyMapEntry<K,V>>[] buckets = new LinkedList[SIZE];
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<MyMapEntry<K,V>> bucket = buckets[index];
        MyMapEntry<K,V> pair = new MyMapEntry<>(key, value);
        ListIterator<MyMapEntry<K,V>> it = bucket.listIterator();
        boolean found = false;
        int count = 0; //next()方法调用的次数
        while(it.hasNext()) {
            MyMapEntry<K,V> iPair = it.next();
            count++;
            if(iPair.getKey().equals(key)) { // 冲突
                System.out.println(String.format("Collision: new %s for old %s", pair, iPair));
                oldValue = iPair.getValue();
                it.set(pair); // 用新的替换旧的
                found = true;
                break;
            }
        }
        if(!found)
            buckets[index].add(pair);
        else
            System.out.println("need found count = " + count);
        return oldValue;
    }
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for(MyMapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }
    public Set<Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for(LinkedList<MyMapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MyMapEntry<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }
}

public class Ex21 {
    public static void main(String[] args) {
        SimpleHashMap21<String,String> m = new SimpleHashMap21<>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        m.put("EGYPT","Berlin?");
        m.put("EGYPT","Cairo");
        System.out.println(m);
        m.putAll(Countries.capitals(5));
    }
}
/**output:
 * {ANGOLA=Luanda, BURKINA FASO=Ouagadougou, BENIN=Porto-Novo, ALGERIA=Algiers, BOTSWANA=Gaberone}
 * Collision: new EGYPT=Cairo for old EGYPT=Berlin?
 * need found count = 1
 * {ANGOLA=Luanda, EGYPT=Cairo, BURKINA FASO=Ouagadougou, BENIN=Porto-Novo, ALGERIA=Algiers, BOTSWANA=Gaberone}
 * Collision: new ALGERIA=Algiers for old ALGERIA=Algiers
 * need found count = 1
 * Collision: new ANGOLA=Luanda for old ANGOLA=Luanda
 * need found count = 1
 * Collision: new BENIN=Porto-Novo for old BENIN=Porto-Novo
 * need found count = 1
 * Collision: new BOTSWANA=Gaberone for old BOTSWANA=Gaberone
 * need found count = 1
 * Collision: new BURKINA FASO=Ouagadougou for old BURKINA FASO=Ouagadougou
 * need found count = 1
 */