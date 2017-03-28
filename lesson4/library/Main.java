package lesson4.library;

/**
 * Created by l1s on 21.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Library lib = new Library(5);

        Book bukvar = new Book("Букварь", "Жукова Н.", 91);
        Book code = new Book("Тайный язык программирования", "Петцольд Ч.", 512);
        Book data = new Book("Структуры данных и алгоритмы в Java",  "Лафоре Р.", 704 );
        Book thinking = new Book("Философия Java", "Эккель Б.", 1168);
        Book java = new Book("Язык программирования Java", "Гослинг Д.", 304);

        lib.put(code, 3);
        lib.put(bukvar, 2);
        lib.put(data, 5);
        lib.put(thinking, 1);
        lib.put(java, 1);

        lib.showBooks();
        System.out.println();

        lib.get(thinking, 1);
        lib.get(data, 3);

        lib.showBooks();
    }
}
