package com.thinkinginjava.containers.exercise.chapter17_2;

import com.thinkinginjava.util.CountingMapData;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2019/2/24 20:21
 * @Version: 1.0
 * @Description: page 470
 * 练习05：修改CountingMapData.java，通过添加像Counties.java中那样的定制EntrySet
 * 类，来完全实现享元。
 */
public class Ex05 extends AbstractMap<Integer,String> {
    private static String[] chars =
            "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"
                    .split(" ");

    static class Entry implements Map.Entry<Integer,String> {
        int index;
        Entry(int index) { this.index = index; }
        public boolean equals(Object o) { return Integer.valueOf(index).equals(o); }
        public Integer getKey() { return index; }
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }
        public String setValue(String value) { throw new UnsupportedOperationException(); }
        public int hashCode() { return Integer.valueOf(index).hashCode(); }
    }

    // Use AbstractSet by implementing size() & iterator()
    static class EntrySet extends AbstractSet<Map.Entry<Integer,String>> {
        private int size;
        EntrySet(int size) {
            if(size < 0) this.size = 0;
            else this.size = size;
        }
        public int size() { return size; }
        private class Iter implements Iterator<Map.Entry<Integer,String>> {
            // Only one Entry object per Iterator:
            private Entry entry = new Entry(-1);
            public boolean hasNext() { return entry.index < size - 1; }
            public Map.Entry<Integer,String> next() {
                entry.index++;
                return entry;
            }
            public void remove() { throw new UnsupportedOperationException(); }
        }
        public Iterator<Map.Entry<Integer,String>> iterator() { return new Iter(); }
    }

    private static Set<Map.Entry<Integer,String>> entries = new EntrySet(chars.length);

    public Set<Map.Entry<Integer,String>> entrySet() { return entries; }

    static Map<Integer,String> select(final int size) {
        return new Ex05() {
            public Set<Map.Entry<Integer,String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(new Ex05());
        System.out.println(select(10));
    }

}
/**
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0, 25=Z0}
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
 */