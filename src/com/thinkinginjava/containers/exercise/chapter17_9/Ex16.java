package com.thinkinginjava.containers.exercise.chapter17_9;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.thinkinginjava.containers.example.chapter17_9.ex17_9_1.MyMapEntry;
import com.thinkinginjava.containers.example.chapter17_9.ex17_9_1.SlowMap;
import com.thinkinginjava.util.CountingMapData;
import static com.thinkinginjava.util.Print.print;
import static com.thinkinginjava.util.Print.printnb;
/**
 * @author: XueYing.Cao
 * @date: 2019/2/27
 * @description: page 492
 * 练习16：将Map.java中的测试应用于SlowMap，验证并修改它，使其能正常工作
 */
class SlowMap16<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    private EntrySet entries = new EntrySet();
    @Override
    public Set<Entry<K,V>> entrySet() { return entries; }
    @Override
    public V put(K key, V value) {
        V oldValue = get(key); // 旧值或null
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }
    @Override
    public V get(Object key) { // key是Object类型，而不是K.
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }
    private class EntrySet extends AbstractSet<Entry<K,V>> {
        public int size() { return keys.size(); }
        public Iterator<Entry<K,V>> iterator() {
            return new Iterator<Map.Entry<K,V>>() {
                private int index = -1;
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }
                @SuppressWarnings("unchecked")
                public Map.Entry<K,V> next() {
                    int i = ++index;
                    return new MyMapEntry(keys.get(i), values.get(i));
                }
                public void remove() {
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }
    }
}

public class Ex16 {
    public static void printKeys(Map<Integer,String> map) {
        printnb("Size = " + map.size() + ", ");
        printnb("Keys: ");
        print(map.keySet()); // Produce a set of the keys
    }
    public static void test(Map<Integer,String> map) {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        // Map has 'Set' behavior for keys:
        map.putAll(new CountingMapData(25));
        printKeys(map);
        // Producing a collection of the values:
        printnb("Values: ");
        print(map.values());
        print(map);
        print("map.containsKey(11): " + map.containsKey(11));
        print("map.get(11): " + map.get(11));
        print("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        print("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty(): " + map.isEmpty());
    }

    public static void main(String[] args) {
        test(new HashMap<>());
        print();
        test(new SlowMap<>());
        print();
        test(new SlowMap16<>());
    }
}
/**output:
 * HashMap
 * Size = 25, Keys: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
 * Values: [A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0]
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0}
 * map.containsKey(11): true
 * map.get(11): L0
 * map.containsValue("F0"): true
 * First key in map: 0
 * Size = 24, Keys: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
 * map.isEmpty(): true
 * map.isEmpty(): true
 *
 * SlowMap
 * Size = 25, Keys: [6, 0, 2, 4, 8, 10, 12, 14, 17, 19, 21, 23, 7, 1, 3, 5, 9, 11, 13, 15, 18, 20, 22, 24, 16]
 * Values: [G0, A0, C0, E0, I0, K0, M0, O0, R0, T0, V0, X0, H0, B0, D0, F0, J0, L0, N0, P0, Q0, S0, U0, W0, Y0]
 * {6=G0, 0=A0, 2=C0, 4=E0, 8=I0, 10=K0, 12=M0, 14=O0, 17=R0, 19=T0, 21=V0, 23=X0, 7=H0, 1=B0, 3=D0, 5=F0, 9=J0, 11=L0, 13=N0, 15=P0, 18=S0, 20=U0, 22=W0, 24=Y0, 16=Q0}
 * map.containsKey(11): true
 * map.get(11): L0
 * map.containsValue("F0"): true
 * First key in map: 6
 * Size = 25, Keys: [6, 0, 2, 4, 8, 10, 12, 14, 17, 19, 21, 23, 7, 1, 3, 5, 9, 11, 13, 15, 18, 20, 22, 24, 16]
 * map.isEmpty(): false
 * map.isEmpty(): false
 *
 * SlowMap16
 * Size = 25, Keys: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
 * Values: [A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0]
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0}
 * map.containsKey(11): true
 * map.get(11): L0
 * map.containsValue("F0"): true
 * First key in map: 0
 * Size = 24, Keys: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
 * map.isEmpty(): true
 * map.isEmpty(): true
 */