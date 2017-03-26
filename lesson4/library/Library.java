package lesson4.library;

/**
 * Created by l1s on 21.03.17.
 */

public class Library {
     private LinkedList[] books = new LinkedList[5];

//заполняем библиотеку книгами
    public void put(Book book, int quantity) {
        if (quantity <= 0) {
            System.out.println("Вы ошиблись.");

            return;
        }

        int i = Math.abs(book.hashCode() % books.length);

        if (books[i] == null) {
            books[i] = new LinkedList();
            books[i].push(book, quantity);
        } else {
            if(books[i].get(book) != null)
                books[i].get(book).setCount(books[i].get(book).getCount() + quantity); //простите меня за эту строчку
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

        if (books[i] == null || books[i].get(book) == null) {
            System.out.println("У нас нет такой книги.");

            return 0;
        }
        if (books[i].get(book).getCount() <= quantity) {
                int available = books[i].get(book).getCount();
                books[i].remove(book);

                return available;
        }
        books[i].get(book).setCount(books[i].get(book).getCount() - quantity);

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
}