package lesson4.linkedList;

/**
 * Created by l1s on 22.03.17.
 */

//СВЯЗНЫЙ СПИСОК
public class LinkedList {
    private Item head;//указатель на первый элемент
    private Item tail;//указатель на последний элемент
    private int size;

    //добавление элемента
    public void add(String value) {
        Item it = new Item(value);

        if (head == null) {
            head = it;
            tail = it;
        } else {
            tail.next = it;
            tail = it;
        }
        size++;
    }

    //удаление элемента по значению
    public void remove(String value) {
        if (head == null) return; //список пуст, расходимся

        if (head == tail) { //в списке только один элемент
            head = null;
            tail = null;
            size--;
            return;
        }

        if (head.getValue().equals(value)) { //если первый элемент - наш, то перекидываем ссылку на следующий за головой элемент
            head = head.next;
            size--;
            return;
        }

//во всех остальных случаях
        Item it = head;
        while (it.next != null) { //итерируемся, пока следующий элемент существует
            if (it.next.getValue().equals(value)) { //проверяем следующий элемент
                if (tail == it.next) { //если он последний
                    tail = it; //перекидываем указатель хвоста на текущтй элемент
                }
                it.next = it.next.next; //перекидываем ссылку через найденный элемент
                size--;
                return;
            }
            it = it.next; //иначе шагаем дальше
        }
    }

    public void print() {
        Item it = head;

        while (it != null) {
            System.out.println(it);
            it = it.next;
        }
    }

    public int getSize() {
        return size;
    }

//УЗЕЛ СВЯЗНОГО СПИСКА
    private static class Item {
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
}
