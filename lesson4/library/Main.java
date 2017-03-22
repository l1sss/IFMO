package lesson4.library;


/**
 * Created by l1s on 21.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book bukvar = new Book("Zhukova", "bukvar", 91);
        Book code = new Book("Petzold", "code", 512);
        library.put(bukvar, 3);
        library.put(code, 2);
        library.get(code, 1);
        library.showBooks();
    }
}
