package com.thinkinginjava.containers.exercise.chapter17_9;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.thinkinginjava.containers.example.chapter17_9.ex17_9_1.MyMapEntry;
import com.thinkinginjava.util.Countries;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/27
 * @description: page 492
 * 练习17：令SlowMap实现完整的Map接口。
 */
class SlowMap17<K,V> implements Map<K,V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    private EntrySet entries = new EntrySet();
    private Set<K> keySet = new KeySet();
    public Set<Map.Entry<K,V>> entrySet() { return entries; }
    @Override
    public Set<K> keySet() { return keySet; }
    @Override
    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }
    @Override
    public V get(Object key) { // key is type Object, not K
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }
    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public int size() { return keys.size(); }
        public Iterator<Map.Entry<K,V>> iterator() {
            return new Iterator<Map.Entry<K,V>>() {
                private int index = -1;
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }
                @SuppressWarnings("unchecked")
                public Map.Entry<K,V> next() {
                    int i = ++index;
                    return new MyMapEntry<>(keys.get(i), values.get(i));
                }
                public void remove() {
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }
    }
    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }
    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }
    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof SlowMap17) {
            if(this.entrySet().equals(((SlowMap17)o).entrySet()))
                return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.entrySet().hashCode();
    }
    @Override
    public boolean isEmpty() {
        return this.entrySet().isEmpty();
    }
    private class KeySet extends AbstractSet<K> {
        public int size() { return keys.size(); }
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                private int index = -1;
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }
                public K next() {
                    int i = ++index;
                    return keys.get(index);
                }
                public void remove() {
                    keys.remove(index--);
                }
            };
        }

    }
    @Override
    public void putAll(Map<? extends K,? extends V> m) {
        for(Map.Entry<? extends K,? extends V> me : m.entrySet())
            this.put(me.getKey(), me.getValue());
    }
    @Override
    public V remove(Object key) {
        V v = this.get(key);
        int i = keys.indexOf(key);
        keys.remove(i);
        values.remove(i);
        return v;
    }
    @Override
    public int size() { return keys.size(); }
    @Override
    public Collection<V> values() {
        return values;
    }
    @Override
    public String toString() {
        return this.entrySet().toString();
    }
}

public class Ex17 {
    public static void main(String[] args) {
        SlowMap17<String,String> m = new SlowMap17<>();
        m.putAll(Countries.capitals(15));
        print("m: " + m);
        print("m.get(\"BURUNDI\"): " + m.get("BURUNDI"));
        print("m.entrySet(): " + m.entrySet());
        print("m.keySet(): " + m.keySet());
        print("m.values() = " + m.values());
        print("Two different maps: ");
        SlowMap17<String,String> m2 = new SlowMap17<>();
        print("m.equals(m2): " + m.equals(m2));
        m2.putAll(Countries.capitals(15));
        print("Maps with same entries: ");
        print("m.equals(m2): " + m.equals(m2));
        m.clear();
        print("After m.clear(), m.isEmpty(): " +
                m.isEmpty() + ", m = " + m);
        m2.keySet().clear();
        print("After m2.keySet().clear(), m2.isEmpty(): "
                + m2.isEmpty() + ", m2 = " + m2);
    }
}
/**output:
 * m: [ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo]
 * m.get("BURUNDI"): Bujumbura
 * m.entrySet(): [ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo]
 * m.keySet(): [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA]
 * m.values() = [Algiers, Luanda, Porto-Novo, Gaberone, Ouagadougou, Bujumbura, Yaounde, Praia, Bangui, N'djamena, Moroni, Brazzaville, Dijibouti, Cairo, Malabo]
 * Two different maps:
 * m.equals(m2): false
 * Maps with same entries:
 * m.equals(m2): true
 * After m.clear(), m.isEmpty(): true, m = []
 * After m2.keySet().clear(), m2.isEmpty(): true, m2 = []
 */