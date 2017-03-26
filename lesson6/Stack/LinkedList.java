package lesson6.Stack;


import java.util.Iterator;

/**
 * Created by xmitya on 20.03.17.
 */
public class LinkedList implements List, Stack{
    private Item head;

    public void push(Object object) {
        Item next = head;

        head = new Item(object);

        head.next = next;
    }

    public Object poll() {
        return remove(0);
    }

    public void add(Object object) {
        if (head == null) {
            head = new Item(object);

            return;
        }

        for (Item prev = head;;) {
            Item next = prev.next;

            if (next == null) {
                prev.next = new Item(object);

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

        for (Item prev = head;;) {
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

        for (Item prev = head;;) {
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

    @Override
    public Iterator iterator() {
        return new LlIterator(head);
    }
}
