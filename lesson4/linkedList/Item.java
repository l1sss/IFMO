package lesson4.linkedList;

/**
 * Created by l1s on 22.03.17.
 */
public class Item {
    private String value;
    Item next;

    public Item(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Item next() {
        return next;
    }

    @Override
    public String toString() {
        return value;
    }
}
