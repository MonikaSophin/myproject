package com.thinkinginjava.holding_objects.exercise.chapter11_13;

import com.thinkinginjava.holding_objects.example.chapter11_12.InterfaceVsIterator;
import com.thinkinginjava.holding_objects.example.pets.Pet;
import com.thinkinginjava.holding_objects.example.pets.Pets;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/22 15:29
 * @Version: 1.0
 * @Description: page 245
 * 练习32:按照MultiIterableClass示例，在NonCollectionSequence.java中添加reversed()
 * 和randomized()方法，并让NonCollectionSequence实现Iterable。然后在foreach语句中展示
 * 所有的使用方式。
 */
class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}

class NonCollectionSequence extends PetSequence implements Iterable {
    //正常继承Iterable接口的iterator()方法
    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            public boolean hasNext() {
                return index < pets.length;
            }
            public Pet next() { return pets[index++]; }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterable<Pet> reversed() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    private int current = pets.length - 1;
                    public boolean hasNext() { return current > -1; }
                    public Pet next() { return pets[current--]; }
                    public void remove() { throw new UnsupportedOperationException(); }
                };
            }
        };
    }

    public Iterable<Pet> randomized(){
        return new Iterable<Pet>(){
            @Override
            public Iterator<Pet> iterator() {
                Random random = new Random(47);
                //将Arrays.asList()生成的ArrayList填充到了另一个容器中，
                List<Pet> list = new ArrayList<>(Arrays.asList(pets));
                Collections.shuffle(list,random);
                return list.iterator();
            }
        };
    }

    public void toArrayString(){ System.out.println(Arrays.toString(pets)); }
}

public class Ex32 {
    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
        InterfaceVsIterator.display(nc.reversed().iterator());
        InterfaceVsIterator.display(nc.randomized().iterator());
        //可以查看到结果，源数组的元素没有变化。
        nc.toArrayString();
    }
}
/**output:
 * 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 * 7:Manx 6:Pug 5:Cymric 4:Pug 3:Mutt 2:Cymric 1:Manx 0:Rat
 * 4:Pug 3:Mutt 6:Pug 0:Rat 7:Manx 1:Manx 2:Cymric 5:Cymric
 * [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
 */