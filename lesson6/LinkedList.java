package lesson6;


import java.util.Iterator;

/**
 * Created by xmitya on 20.03.17.
 */
public class LinkedList implements List, Stack {
    private Item head;

    public void push(Object o) {
        Item next = head;

        head = new Item(o);

        head.next = next;
    }

    public Object poll() {
        return remove(0);
    }

    public void add(Object o) {
        if (head == null) {
            head = new Item(o);

            return;
        }

        for (Item prev = head; ; ) {
            Item next = prev.next;

            if (next == null) {
                prev.next = new Item(o);

                return;
            }

            prev = next;
        }
    }

    public Object get(int i) {
        if (head == null)
            return null;

        if (i == 0)
            return head.value;

        int cnt = 1;

        for (Item prev = head; ; ) {
            Item next = prev.next;

            if (next == null)
                return null;

            if (cnt++ == i)
                return next.value;

            prev = next;
        }
    }

    public Object remove(int i) {
        if (head == null)
            return null;

        if (i == 0) {
            Item h = head;

            head = head.next;

            return h.value;
        }

        int cnt = 1;

        for (Item prev = head; ; ) {
            Item next = prev.next;

            if (next == null)
                return null;

            if (cnt++ == i) {
                if (next.next != null)
                    prev.next = next.next;
                else
                    prev.next = null;

                return next.value;
            }

            prev = next;
        }
    }

    private class Item {
        Object value;
        Item next;

        Item(Object value) {
            this.value = value;
        }
    }

    @Override
    public Iterator iterator() {
        return new LlIterator(head);
    }

    public class LlIterator implements Iterator {
        Item next;

        LlIterator(Item next) {
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
}
