package lesson6.ArrayList;

import java.util.Iterator;

public class ALIterator implements Iterator {
    private Object[] array;
    private int index = 0;
    private int size;

    ALIterator(Object[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length && array[index] != null;
    }

    @Override
    public Object next() {
        return array[index++];
    }
}
