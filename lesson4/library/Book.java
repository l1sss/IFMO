package lesson4.library;

/**
 * Created by l1s on 21.03.17.
 */
public class Book extends Item {
    private String title;
    private String author;
    private int pagesNum;

    public Book(String title, String author, int pagesNum) {
        this.title = title;
        this.author = author;
        this.pagesNum = pagesNum;
    }


    public String getTitle(Book book) {
        return title;
    }

    public String getAuthor(Book book) {
        return author;
    }

    public int getPagesNum(Book book) {
        return pagesNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (pagesNum != book.pagesNum) return false;
        if (!title.equals(book.title)) return false;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + pagesNum;
        return result;
    }

    @Override
    public String toString() {
        return title + ", " + author;
    }
}