package com.thinkinginjava.containers.example.chapter17_9.ex17_9_2;

import com.thinkinginjava.containers.example.chapter17_9.ex17_9_1.MyMapEntry;
import com.thinkinginjava.util.Countries;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/28
 * @description:
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<MyMapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<MyMapEntry<K, V>> bucket = buckets[index];

        V oldValue = null;
        boolean found = false;
        MyMapEntry<K, V> kv = new MyMapEntry<>(key, value);
        ListIterator<MyMapEntry<K, V>> it = bucket.listIterator();
        while(it.hasNext()) {
            MyMapEntry<K, V> pair = it.next();
            if(pair.getKey().equals(key)){ //如果找到了对应的key
                oldValue = pair.getValue();
                it.set(kv);
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(kv);
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        for (MyMapEntry<K, V> pair : buckets[index]) {
            if (pair.getKey().equals(key))
                return pair.getValue();
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MyMapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MyMapEntry<K, V> pair : bucket)
                set.add(pair);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.putAll(Countries.capitals(10));
        System.out.println(map);
        System.out.println(map.get("BURUNDI"));
        System.out.println(map.entrySet());
    }
}
/**output:
 * {CAPE VERDE=Praia, ANGOLA=Luanda, CENTRAL AFRICAN REPUBLIC=Bangui, BURKINA FASO=Ouagadougou, CHAD=N'djamena, BURUNDI=Bujumbura, BENIN=Porto-Novo, ALGERIA=Algiers, CAMEROON=Yaounde, BOTSWANA=Gaberone}
 * Bujumbura
 * [CAPE VERDE=Praia, ANGOLA=Luanda, CENTRAL AFRICAN REPUBLIC=Bangui, BURKINA FASO=Ouagadougou, CHAD=N'djamena, BURUNDI=Bujumbura, BENIN=Porto-Novo, ALGERIA=Algiers, CAMEROON=Yaounde, BOTSWANA=Gaberone]
 */