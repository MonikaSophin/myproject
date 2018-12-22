package com.thinkinginjava.holding_objects.exercise.chapter11_12;

import com.thinkinginjava.holding_objects.example.chapter11_12.InterfaceVsIterator;
import com.thinkinginjava.holding_objects.example.pets.Pet;
import com.thinkinginjava.holding_objects.example.pets.Pets;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: monika
 * @Date: 2018/12/22 12:42
 * @Version: 1.0
 * @Description: page 241
 * 练习30：修改CollectionSequence.java，使其不要继承AbstractCollection，而是实现Collection.
 */
class CollectionSequence
        implements Collection<Pet> {
    private Pet[] pets = Pets.createArray(8);
    public int size() { return pets.length; }
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            public boolean hasNext() {
                return index < pets.length;
            }
            public Pet next() { return pets[index++]; }
            public void remove() { // not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
    public void clear() {
        if(this.size() != 0)
            for(Pet p : pets)
                p = null;
    }
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    public boolean addAll(Collection<? extends Pet> c) {
        throw new UnsupportedOperationException();
    }
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }
    public boolean isEmpty() {
        return (this.size() == 0) ? true : false;
    }
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
    public boolean add(Pet p) {
        throw new UnsupportedOperationException();
    }
    public Object[] toArray() {
        return pets;
    }
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
}

public class Ex30 {
    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
