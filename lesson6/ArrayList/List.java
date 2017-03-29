package lesson6.ArrayList;

/**
 * Created by l1s on 27.03.17.
 */
public interface List extends Iterable {
    void add(Object o);

    Object get(int index0);

    Object remove(int index);

    int size();
}
