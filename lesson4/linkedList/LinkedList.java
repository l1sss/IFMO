package lesson4.linkedList;

import java.util.Iterator;

/**
 * Created by l1s on 22.03.17.
 */

//СВЯЗНЫЙ СПИСОК
public class LinkedList<T> implements List<T>, Stack<T> {
    private Item<T> head;//указатель на первый элемент
    private Item<T> tail;//указатель на последний элемент
    private int size;

    //добавление элемента в конец
    public void add(T val) {
        Item<T> it = new Item<>(val);

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
    public void push(T val) {
        Item<T> next = head;

        head = new Item<>(val);
        head.next = next;

        size++;
    }

    //взятие элемента по индексу
    @Override
    public T get(int i) {
        if (head == null)
            return null;

        if (i == 0)
            return head.value;

        int cnt = 1;

        for (Item<T> prev = head; ; ) {
            Item<T> next = prev.next;

            if (next == null)
                return null;

            if (cnt++ == i)
                return next.value;

            prev = next;
        }
    }

    //поиск элемента по значению
    public T get(T val) {
        if (head == null) return null;

        if (head.value.equals(val)) return head.value;

        Item<T> it = head;
        while(it.next != null) {
            if (it.next.value.equals(val)) return it.next.value;
            it = it.next;
        }
        return null;
    }

    //удаление по индексу
    @Override
    public T remove(int i) {
        if (head == null)
            return null;

        if (i == 0) {
            Item<T> h = head;
            head = head.next;
            size--;

            return h.value;
        }

        int cnt = 1;

        for (Item<T> prev = head; ; ) {
            Item<T> next = prev.next;

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
    @Override
    public T remove(T value) {
        if (head == null) return null; //список пуст, расходимся

        if (head == tail) {//в списке только один элемент
            Item<T> h = head;
            head = null;
            tail = null;
            size--;

            return h.value;
        }

        if (head.value.equals(value)) { //если первый элемент - наш, то перекидываем ссылку на следующий за головой элемент
            Item<T> h = head;
            head = head.next;
            size--;

            return h.value;
        }

        //во всех остальных случаях
        Item<T> it = head;
        while (it.next != null) { //итерируемся, пока следующий элемент существует
            if (it.next.value.equals(value)) {//проверяем следующий элемент
                Item<T> h = it.next;
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
    public T poll() {
        return remove(0);
    }

    public void print() {
        Item<T> it = head;

        while (it != null) {
            System.out.println(it);
            it = it.next;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedList<?> that = (LinkedList<?>) o;

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
    private static class Item<T> {
        Item<T> next; //указатель на следующий элемент
        T value; //значение

    public Item(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item<?> item = (Item<?>) o;

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
    public Iterator<T> iterator() {
        return new LlIterator(head);
    }

    public class LlIterator implements Iterator<T> {
        Item<T> next;

        LlIterator(Item<T> next) {
            this.next = next;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            Item<T> next = this.next;
            this.next = next.next;
            return next.value;
        }
    }
}
