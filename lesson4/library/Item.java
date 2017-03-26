package lesson4.library;

/**
 * Created by l1s on 23.03.17.
 */
public class Item {
    Item next; //указатель на следующий элемент
    private Book value;//значение
    private int count;//счётчик

    public Item(Book value, int count) {
        this.value = value;
        this.count = count;
    }

    public Book value() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override   //когда печатаем наш Item, выводится его значение
    public String toString() {
        return value.toString();
    }
}
