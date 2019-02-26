package com.thinkinginjava.containers.example.chapter17_9.ex17_9_1;

import com.thinkinginjava.util.Countries;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description:
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    @Override
    public V put(K key, V value) {
        V oldVlaue = get(key);
        if (!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else {
            values.set(keys.indexOf(key), value);
        }
        return oldVlaue;
    }

    @Override
    public V get(Object key) { //不是K
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        Iterator<K> kit = keys.iterator();
        Iterator<V> vit = values.iterator();
        while(kit.hasNext()){
            set.add(new MyMapEntry<>(kit.next(), vit.next()));
            /**
             * {@link java.util.AbstractMap.SimpleEntry}
             */
            //set.add(new SimpleEntry(kit.next(), vit.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("ANGOLA"));
        System.out.println(m.entrySet());
    }
}
/**output:
 * {ANGOLA=Luanda, CAPE VERDE=Praia, EGYPT=Cairo, BURUNDI=Bujumbura, BENIN=Porto-Novo, ALGERIA=Algiers, CAMEROON=Yaounde, CONGO=Brazzaville, CENTRAL AFRICAN REPUBLIC=Bangui, EQUATORIAL GUINEA=Malabo, COMOROS=Moroni, DJIBOUTI=Dijibouti, BURKINA FASO=Ouagadougou, CHAD=N'djamena, BOTSWANA=Gaberone}
 * Luanda
 * [ANGOLA=Luanda, CAPE VERDE=Praia, EGYPT=Cairo, BURUNDI=Bujumbura, BENIN=Porto-Novo, ALGERIA=Algiers, CAMEROON=Yaounde, CONGO=Brazzaville, CENTRAL AFRICAN REPUBLIC=Bangui, EQUATORIAL GUINEA=Malabo, COMOROS=Moroni, DJIBOUTI=Dijibouti, BURKINA FASO=Ouagadougou, CHAD=N'djamena, BOTSWANA=Gaberone]
 */