package lesson4.library;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by l1s on 21.03.17.
 */

public class Library {
    private int totalPlaces = 5; //всего мест в библиотеке
    private Book[] books = new Book[totalPlaces];

    public int getTotalPlaces() {
        return totalPlaces;
    }

    public void setTotalPlaces(int totalPlaces) {
        this.totalPlaces = totalPlaces;
    }

//заполняем библиотеку книгами
    public void put(Book book, int quantity) {
        if (quantity <= 0) System.out.println("Вы ошиблись.");

        //проверяем кол-во свободных мест
        int freePlaces = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) freePlaces++;
        }
        if(freePlaces < quantity) System.out.println("Мы не можем принять такое кол-во книг." +
                "\nСвободных мест: " + freePlaces);
        else {
            int accepted = 0;
            for (int i = 0; i < books.length; i++) {
                if (books[i] == null) {
                    books[i] = book;
                    accepted++;
                }
                if (accepted == quantity) break;
            }
            book.cntUp(quantity);
            System.out.println("Принято: " + book + ", " + quantity + " шт. " +
                    "Осталось свободных мест " + (freePlaces - quantity) + ".");
        }
    }

//берём книги из библиотеки
    public int get(Book book, int quantity) {
        if (quantity <= 0) System.out.println("Вы ошиблись");

        //проверяем есть ли такая книга в нашей библиотеке в доступном количестве
        if (book.getCounter() == 0) {
            System.out.println("У нас нет такой книги.");
            return 0;
        } else if (book.getCounter() > 0 && book.getCounter() < quantity) {
            System.out.println("У нас нет книги: " + book +
                    " в количестве " + quantity + " шт. Доступное количество " + book.getCounter() + " шт.");
            return 1;
        } else {
            int accepted = 0;
            for (int i = 0; i < books.length; i++) {
                if (book.equals(books[i])) {
                    books[i] = null;
                    accepted++;
                }
                if (accepted == quantity) break;
            }
            System.out.println("Выдано: " + book + ", " + quantity + " шт.");
            book.cntDown(quantity);
            return quantity;
        }
    }

//смотрим всю библиотеку
    public void showBooks() {
        System.out.println("Доступные книги: ");
        int available = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(books[i]);
                available++;
            }
            else if (i == books.length -1 && available == 0)
                System.out.println("Библиотека пуста.");
        }
    }
}