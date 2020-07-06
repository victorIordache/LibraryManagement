package ro.jademy.library.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    public static final int BORROWED_MAX_TIME = 30;
    public ArrayList<Shelf> shelfList = new ArrayList<>();
    public ArrayList<User> userList = new ArrayList<>();




    public void listBooks() {
        // Genre: SF
        //     - Dune, Frank Herbert (ISBN: 9780593099322) - Lei 1500
        // Genre: Classic
        //     - Slaughter House 5, Kurt Vonnegut (ISBN: 9780385333849) - Lei 3000
        //     - 1984, George Orwell (ISBN: 9780385333849) - Lei 3000
        for (Shelf shelf : shelfList) {
            System.out.println("Genre: " + shelf.getGenre());
            for (Book book : shelf.getBookList()) {
                System.out.println("    -" + book.getTitle() + ", " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ") - Lei " + book.getPrice());
            }
        }

    }

    public void listBooks(String genre) {
        // list all books by given genre
        for (Shelf shelf : shelfList) {
            if (genre.equals(shelf.getGenre())) {
                System.out.println("Genre: " + shelf.getGenre());
                for (Book book : shelf.getBookList()) {
                    System.out.println("    -" + book.getTitle() + ", " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ") - Lei " + book.getPrice());
                }
            }
        }
    }

    public void addBook(Book book) {
        // add a book to the library
        // steps:
        // if a shelf with the same genre as the book exists, add the book to that shelf
        // else
        // create a new shelf with the same genre as the book
        // add the book to the shelf
        // add the shelf to the library
        if (isGenreInLibrary(book.getGenre())) {
            for (Shelf shelf : shelfList) {
                if (book.getGenre().equals(shelf.getGenre())) {
                    shelf.getBookList().add(book);
                }
            }
        } else {
            Shelf shelf = new Shelf(book.getGenre());
            System.out.println(shelf);
            shelf.getBookList().add(book);
            this.shelfList.add(shelf);
        }
    }


    public boolean isGenreInLibrary(String genre) {
        // check if there is a shelf with the given genre
        for (Shelf shelf : shelfList) {
            if (genre.equals(shelf.getGenre())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> searchByTitle(String title) {
        // TO: return all the books with the given title
        // question: should it be the full title or just a part?
        ArrayList<Book> bookList = new ArrayList<>();
        for (Shelf shelf : shelfList) {
            for (Book book : shelf.getBookList()) {
                if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    bookList.add(book);
                }
            }
        }
        return bookList;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        // TO: return all the books with the given author
        ArrayList<Book> bookList = new ArrayList<>();
        for (Shelf shelf : shelfList) {
            for (Book book : shelf.getBookList()) {
                if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                    bookList.add(book);
                    System.out.println(book.getAuthor());
                }
            }
        }
        return bookList;
    }

    public Book searchByIsbn(String isbn) {
        // TO: return a single book with the given isbn
        // question: what should we return when no book is found?
        for (Shelf shelf : shelfList) {
            for (Book book : shelf.getBookList()) {
                if (isbn.equals(book.getIsbn())) {
                    return book;
                }
            }
        }
        System.out.println("That isbn doesn't exist!");
        return null;
    }


    public boolean borrowBook(Book book, User user) {
        // TO: remove the book from the library shelf and add it to the list of borrowed books of the user
        // TO: return true if the book was successfully borrowed
        for (Shelf shelfi : shelfList) {
            for (Book booki : shelfi.getBookList()) {
                if (booki.getIsbn().equals(book.getIsbn())) {
                    booki.setReturnDate(LocalDate.now().plusDays(BORROWED_MAX_TIME));
                    user.addBookToListBorrowed(book);
                    shelfi.getBookList().remove(book);
                    return true;
                }
            }
        }
        return false;

    }

    public boolean borrowBook(String isbn, User user) {
        Book book = searchByIsbn(isbn);
        return borrowBook(book, user);
    }
}
