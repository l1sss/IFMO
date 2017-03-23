package lesson4.linkedList;

/**
 * Created by l1s on 22.03.17.
 */
public class Item {
    Item next; //указатель на следующий элемент
    private String value; //данные, можно взять всё, что душе угодно... В данном случае строка

    public Item(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override   //когда печатаем наш Item, выводится его значение
    public String toString() {
        return value;
    }
}
