package lesson6;

/**
 * Created by l1s on 24.03.17.
 */
public interface Stack extends Iterable {
    void push(Object o);

    Object poll();
}