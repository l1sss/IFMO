package lesson4.library;

/**
 * Created by l1s on 21.03.17.
 */
public class Book {
    private String author;
    private String title;
    private int pagesNum;

    public Book(String author, String title, int pagesNum) {
        this.author = author;
        this.title = title;
        this.pagesNum = pagesNum;
    }

    public String getAuthor(Book book) {
        return author;
    }

    public String getTitle(Book book) {
        return title;
    }

    public int getPagesNum(Book book) {
        return pagesNum;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPagesNum(int pagesNum) {
        this.pagesNum = pagesNum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pagesNum=" + pagesNum +
                '}';
    }
}
