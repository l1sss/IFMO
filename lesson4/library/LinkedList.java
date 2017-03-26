package lesson4.library;

/**
 * Created by l1s on 22.03.17.
 */
public class LinkedList {
    private Item head;//указатель на первый элемент
    private Item tail;//указатель на последний элемент
    private int size;

//добавление элемента в конец
    public void add(Book book, int quantity) {
        Item it = new Item(book, quantity);

        if (head == null) {
            head = it;
            tail = it;
        }
        else {
            tail.next = it;
            tail = it;
        }
        size++;
    }

//вставка элемента в начало
    public void push(Book book, int quantity) {
        Item next = head;
        head = new Item(book, quantity);
        head.next = next;
        size++;
    }

//поиск элемента по значению
    public Item get(Book book) {
        if (head == null) return null;

        if (head.value().equals(book)) return head;

        Item it = head;
        while(it.next != null) {
            if (it.next.value().equals(book)) return it.next;
            it = it.next;
        }
        return null;
    }

//удаление элемента по значению
    public void remove(Book book) {
        if (head == null) return; //список пуст, расходимся

        if (head == tail) { //в списке только один элемент
            head = null;
            tail = null;
            size--;
            return;
        }

        if (head.value().equals(book)) { //если первый элемент - наш, то перекидываем ссылку на следующий за головой элемент
            head = head.next;
            size--;
            return;
        }

//во всех остальных случаях
        Item it = head;
        while (it.next != null) { //итерируемся, пока следующий элемент существует
            if (it.next.value().equals(book)) { //проверяем следующий элемент
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

    public boolean contains(Book book) {
        Item it = head;

        while (it != null) {
            if(it.value().equals(book)) return true;
            it = it.next;
        }
        return false;
    }

    public void print() {
        Item it = head;

        while(it != null) {
            System.out.println(it + "   " + it.getCount());
            it = it.next;
        }
    }

    public int getSize() {
        return size;
    }
}
