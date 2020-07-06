package ro.jademy.library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Book {
    private String title;
    private String author;
    private long price;
    private String isbn;
    private int numberOfPages;
    private String genre;
    private LocalDate returnDate;

    private ArrayList<Book> totalQuantity= new ArrayList<>();
    private ArrayList<Book> inStockQuantity = new ArrayList<>();
    private ArrayList<Book> borrowedQuantity = new ArrayList<>();

    public void addBooksToTotalQuantity(Book book, int numberOfBooksToAdd) {
        for (int i = 0; i < numberOfBooksToAdd; i++) {
            book.totalQuantity.add(book);
        }
    }

    public int hasInStock() {
        int hasInStock = totalQuantity.size();
        return hasInStock;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }


    public Book(String title, String author, long price, String isbn, int numberOfPages, String genre) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.genre = genre;

    }

    public boolean isEqual(Book book1) {
        if (this.title.equals(book1.title) && this.author.equals(book1.author) && this.price == book1.price && this.isbn.equals(book1.isbn) && this.numberOfPages == book1.numberOfPages && this.genre.equals(book1.genre)) {
            return true;
        } else {
            return false;
        }
    }
}
