package lesson4.linkedList;

import java.util.Iterator;

/**
 * Created by l1s on 22.03.17.
 */

//СВЯЗНЫЙ СПИСОК
public class LinkedList implements List, Stack {
    private Item head;//указатель на первый элемент
    private Item tail;//указатель на последний элемент
    private int size;

    //добавление элемента в конец
    public void add(Object o) {
        Item it = new Item(o);

        if (head == null) {
            head = it;
            tail = it;
        } else {
            tail.next = it;
            tail = it;
        }
        size++;
    }

    //добавление элемента в начало
    @Override
    public void push(Object o) {
        Item next = head;

        head = new Item(o);
        head.next = next;

        size++;
    }

    //взятие элемента по индексу
    @Override
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

    //удаление по индексу
    @Override
    public Object remove(int i) {
        if (head == null)
            return null;

        if (i == 0) {
            Item h = head;
            head = head.next;
            size--;

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
                size--;

                return next.value;
            }
            prev = next;
        }
    }

    //удаление элемента по значению
    public Object remove(Object value) {
        if (head == null) return null; //список пуст, расходимся

        if (head == tail) {//в списке только один элемент
            Item h = head;
            head = null;
            tail = null;
            size--;

            return h.value;
        }

        if (head.value.equals(value)) { //если первый элемент - наш, то перекидываем ссылку на следующий за головой элемент
            Item h = head;
            head = head.next;
            size--;

            return h.value;
        }

        //во всех остальных случаях
        Item it = head;
        while (it.next != null) { //итерируемся, пока следующий элемент существует
            if (it.next.value.equals(value)) {//проверяем следующий элемент
                Item h = it.next;
                if (tail == it.next) { //если он последний
                    tail = it; //перекидываем указатель хвоста на текущий элемент
                }
                it.next = it.next.next; //перекидываем ссылку через найденный элемент
                size--;
                return h.value;
            }
            it = it.next; //иначе шагаем дальше
        }
        return null;
    }

    @Override
    public Object poll() {
        return remove(0);
    }

    public void print() {
        Item it = head;

        while (it != null) {
            System.out.println(it);
            it = it.next;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedList that = (LinkedList) o;

        if (size != that.size) return false;
        if (head != null ? !head.equals(that.head) : that.head != null) return false;
        return tail != null ? tail.equals(that.tail) : that.tail == null;
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + (tail != null ? tail.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }

    public int size() {
        return size;
    }

//УЗЕЛ СВЯЗНОГО СПИСКА
    private static class Item {
        Item next; //указатель на следующий элемент
        Object value;

        public Item(Object value) {
            this.value = value;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (next != null ? !next.equals(item.next) : item.next != null) return false;
        return value != null ? value.equals(item.value) : item.value == null;
    }

    @Override
    public int hashCode() {
        int result = next != null ? next.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override   //когда печатаем наш Item, выводится его значение
        public String toString() {
            return value.toString();
        }
    }

//ИТЕРАТОР
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
