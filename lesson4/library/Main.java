package lesson4.library;


/**
 * Created by l1s on 21.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book bukvar = new Book("Букварь", "Жукова Н.", 91);
        Book code = new Book("Тайный язык программирования", "Петцольд Ч.", 512);
        library.put(bukvar, 3);
        System.out.println(bukvar.getCounter());
        library.put(code, 1);
        library.get(code, 1);
        library.get(bukvar, 1);
        System.out.println(bukvar.getCounter());
        library.get(bukvar, 3);
        library.showBooks();
    }
}
