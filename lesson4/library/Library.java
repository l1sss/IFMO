package lesson4.library;

/**
 * Created by l1s on 28.03.17.
 */

//БИБЛИОТЕКА
public class Library {
     private LinkedList<Book, Integer>[] books;

    public Library(int capacity) {
        this.books = new LinkedList[capacity];
    }

    //заполняем библиотеку книгами
    public void put(Book book, int quantity) {
        if (quantity <= 0) {
            System.out.println("Вы ошиблись.");

            return;
        }
        int i = Math.abs(book.hashCode() % books.length);
        if (books[i] == null) {
            books[i] = new LinkedList<>();
            books[i].push(book, quantity);
        } else {
            if(books[i].find(book) != null)
                books[i].find(book).count = books[i].find(book).count + quantity;//простите меня за эту строчку
            else
                books[i].push(book, quantity);
        }
    }

    //берём книги из библиотеки
    public int get(Book book, int quantity) {
        if (quantity <= 0) {
            System.out.println("Вы ошиблись");

            return 0;
        }
        int i = Math.abs(book.hashCode() % books.length);
        if (books[i] == null || books[i].find(book) == null) {
            System.out.println("У нас нет такой книги.");

            return 0;
        }
        if (books[i].find(book).count <= quantity) {
                int available = books[i].find(book).count;
                books[i].remove(book);

                return available;
        }
        books[i].find(book).count = books[i].find(book).count - quantity;

        return quantity;
    }

    //смотрим всю библиотеку
    public void showBooks() {
        int available = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                books[i].print();
                available++;
            }
            else if (i == books.length -1 && available == 0)
                System.out.println("Библиотека пуста.");
        }
    }

//СВЯЗНЫЙ СПИСОК
    private class LinkedList<K, V> {
        Item<K, V> head;//указатель на первый элемент
        Item<K, V> tail;//указатель на последний элемент
        int size;

        //вставка элемента в начало
        public void push(K book, V quantity) {
            Item<K, V> next = head;
            head = new Item<>(book, quantity);
            head.next = next;
            size++;
        }

        //поиск элемента по значению
        public Item<K, V> find(K book) {
            if (head == null) return null;

            if (head.value.equals(book)) return head;

            Item<K, V> it = head;
            while(it.next != null) {
                if (it.next.value.equals(book)) return it.next;
                it = it.next;
            }
            return null;
        }

        //удаление элемента по значению
        void remove(K book) {
            if (head == null) return; //список пуст, расходимся

            if (head == tail) { //в списке только один элемент
                head = null;
                tail = null;
                size--;
                return;
            }

            if (head.value.equals(book)) { //если первый элемент - наш, то перекидываем ссылку на следующий за головой элемент
                head = head.next;
                size--;
                return;
            }

        //во всех остальных случаях
            Item<K, V> it = head;
            while (it.next != null) { //итерируемся, пока следующий элемент существует
                if (it.next.value.equals(book)) { //проверяем следующий элемент
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
            Item<K, V> it = head;

            while(it != null) {
                System.out.println(it + "   " + it.count);
                it = it.next;
            }
        }

//УЗЛЫ СВЯЗНОГО СПИСКА
        private class Item<K1, V1> {
            Item<K1, V1> next; //указатель на следующий элемент
            K1 value;//значение
            V1 count;//счётчик

            Item(K1 value, V1 count) {
                this.value = value;
                this.count = count;
            }
            @Override   //когда печатаем наш Item, выводится его значение
            public String toString() {
                return value.toString();
            }
        }
    }
}