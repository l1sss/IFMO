package lesson6;

import java.util.Iterator;

/**
 * Created by l1s on 24.03.17.
 */
public class LlIterator implements Iterator {
    Item next;

    public LlIterator(Item next) {
        this.next = next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Object next() {
        Item next = this.next;
        this.next = next.next;
        return next.value;
    }
}
