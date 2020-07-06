package ro.jademy.library.model;

import java.util.ArrayList;

public class Shelf {

    private String genre;
    private ArrayList<Book> bookList = new ArrayList<>();

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<Book> getBookList(){
        return bookList;
    }



    public Shelf(String genre) {
        this.genre = genre;
    }
}

