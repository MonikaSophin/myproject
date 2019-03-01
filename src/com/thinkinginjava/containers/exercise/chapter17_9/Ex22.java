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
 * 练习22：实现SimpleHashMap的clear()和remove()方法。
 */
class SimpleHashMap22<K,V> extends AbstractMap<K,V> {
    static final int SIZE = 997;
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
        while(it.hasNext()) {
            MyMapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)) { // 冲突
                oldValue = iPair.getValue();
                it.set(pair); // 用新的替换旧的
                found = true;
                break;
            }
        }
        if(!found)
            buckets[index].add(pair);
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
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for(LinkedList<MyMapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MyMapEntry<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }
    @Override
    public void clear() {
        for (LinkedList<MyMapEntry<K, V>> bucket : buckets)
            if (bucket != null) bucket.clear();
    }
    @Override
    public V remove(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for(MyMapEntry<K,V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                V value = iPair.getValue();
                int i = buckets[index].indexOf(iPair);//找到key所属MyMapEntry 所在LinkedList的位置
                buckets[index].remove(i);
                return value;
            }
        }
        return null;
    }
}

public class Ex22 {
    public static void main(String[] args) {
        SimpleHashMap22<String,String> m = new SimpleHashMap22<>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        m.put("EGYPT","Berlin?");
        System.out.println(m);
        System.out.println("---------------------------------------");

        System.out.println(String.format("m.remove(\"EGYPT\"): ", m.remove("EGYPT")));
        System.out.println(m);
        System.out.println(String.format("m.clear(): "));
        m.clear();
        System.out.println(m);
    }
}
/**output:
 * {ANGOLA=Luanda, BURKINA FASO=Ouagadougou, BENIN=Porto-Novo, ALGERIA=Algiers, BOTSWANA=Gaberone}
 * {ANGOLA=Luanda, EGYPT=Berlin?, BURKINA FASO=Ouagadougou, BENIN=Porto-Novo, ALGERIA=Algiers, BOTSWANA=Gaberone}
 * ---------------------------------------
 * m.remove("EGYPT"):
 * {ANGOLA=Luanda, BURKINA FASO=Ouagadougou, BENIN=Porto-Novo, ALGERIA=Algiers, BOTSWANA=Gaberone}
 * m.clear():
 * {}
 *
 * Process finished with exit code 0
 */