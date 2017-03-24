package lesson4.library;


/**
 * Created by l1s on 21.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book bukvar = new Book("Букварь", "Жукова Н.", 91);
        Book code = new Book("Тайный язык программирования", "Петцольд Ч.", 512);
        library.showBooks();
        library.put(bukvar, 3);
        library.put(code, 1);
        library.showBooks();
    }
}
