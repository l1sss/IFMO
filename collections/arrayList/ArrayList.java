package collections.arrayList;

import collections.linkedList.List;
import java.util.Iterator;

/**
 * Created by l1s on 27.03.17.
 */

//ДИНАМИЧЕСКИЙ МАССИВ
public class ArrayList<T> implements List<T> {
    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10; //вместимость по умолчанию
    private int size;

    public ArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T o) {
        if (size + 1 <= DEFAULT_CAPACITY) {
            elementData[size++] = o;

            return;
        }
        Object[] tmp = new Object[size * 2];
        System.arraycopy(elementData, 0, tmp, 0, size);
        elementData = tmp;
        elementData[size++] = o;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        return (T) elementData[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(Object value) {
        for (Object tmp : elementData) {
            if (value.equals(tmp)) return (T) value;
        }
        return null;
    }


    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        Object oldValue = elementData[index];
        int numMoved = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return (T) oldValue;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(T value) {
        Object oldValue;
        for (int i = 0; i < elementData.length; i++) {
            if (value.equals(elementData[i])) {
                oldValue = elementData[i];
                this.remove(i);
                return (T) oldValue;
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ALIterator(elementData);
    }

    public int size() {
        return size;
    }

//ИТЕРАТОР
    private class ALIterator implements Iterator<T> {
        private Object[] array;
        private int index = 0;

        ALIterator(Object[] array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return index < array.length && array[index] != null;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) array[index++];
        }
    }
}