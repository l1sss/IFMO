package lesson4.linkedList;

/**
 * Created by l1s on 29.03.17.
 */
public interface List<T> extends Iterable<T> {
    void add(T val);

    T get(int index);

    T get(T o);

    T remove(int index);

    T remove(T val);

    int size();
}
