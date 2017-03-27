package lesson6.ArrayList;

import java.util.Iterator;

/**
 * Created by l1s on 27.03.17.
 */
public class ArrayList implements List {
    private Object[] elementData;
    private int capacity = 10; //вместимость по умолчанию
    private int size;

    public ArrayList() {
        this.elementData = new Object[capacity];
    }

    @Override
    public void add(Object o) {
        if (size + 1 <= capacity) {
            elementData[size++] = o;

            return;
        }
        Object[] tmp = new Object[size * 2];
        System.arraycopy(elementData, 0, tmp, 0, size);
        elementData = tmp;
        elementData[size++] = o;
    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public Object remove(int index) {
        Object oldValue = elementData[index];
        int numMoved = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return oldValue;
    }

    @Override
    public Iterator iterator() {
        return new ALIterator(elementData);
    }

    public int size() {
        return size;
    }
}
