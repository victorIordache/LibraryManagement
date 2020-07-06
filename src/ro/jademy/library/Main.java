package ro.jademy.library;

import ro.jademy.library.model.Library;
import ro.jademy.library.model.Shelf;
import ro.jademy.library.model.Book;
import ro.jademy.library.model.User;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Library library = initLibrary();
        Book book4 = new Book("The idiot", "Fedor Dostoesvkij", 25000, "9780679642428", 667, "Philosophical");
        User user1 = new User("Gigi", "Gigescu", "gigi.gigescu", "1234");
        library.listBooks();
        ArrayList<Book> search = library.searchByAuthor("R");
        System.out.println(search.size());
        Book bookS = library.searchByIsbn("9780679642428");
        library.borrowBook("9780679642428",user1);
        user1.printBorrowedBooks();
    }
        public static Library initLibrary(){
            Book book1 = new Book("Dune", "Frank Herbert", 150000, "9780593099322", 688, "SF");
            Book book2 = new Book("Slaughter House 5", "Kurt Vonnegut", 300000, "9780385333849", 275, "Classic");
            Book book3 = new Book("1984", "George Orwell", 250000, "B003JTHWKU", 237, "Classic");

            book1.addBooksToTotalQuantity(book1, 1);
            book2.addBooksToTotalQuantity(book2, 1);
            book3.addBooksToTotalQuantity(book3, 1);

            System.out.println(book2.hasInStock());
            Shelf shelf1 = new Shelf("SF");
            Shelf shelf2 = new Shelf("Classic");
            System.out.println(shelf1);
            shelf1.getBookList().add(book1);
            shelf2.getBookList().add(book2);
            shelf2.getBookList().add(book3);

            User user1 = new User("Gigi", "Gigescu", "gigi.gigescu", "1234");
            Library library = new Library();
            library.shelfList.add(shelf1);
            library.shelfList.add(shelf2);
            library.userList.add(user1);

            return library;
        }
}