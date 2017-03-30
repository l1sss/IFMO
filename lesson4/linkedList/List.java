package lesson4.linkedList;

/**
 * Created by l1s on 29.03.17.
 */
public interface List extends Iterable {
    void add(Object o);

    Object get(int index);

    Object remove(int index);

    Object remove(Object value);

    int size();
}
