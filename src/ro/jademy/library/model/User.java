package ro.jademy.library.model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean isAdmin;
    private ArrayList<Book> bookListBorrowed = new ArrayList<>();

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getUserName(){
        return userName;
    }

    // In case I'll make the Forgot Password feature
    public String getPassword(){
        return password;
    }

    //We don't have setIsAdmin because I don't want other people to modify their account status!
    public boolean getIsAdmin(){
        return isAdmin;
    }

    public ArrayList<Book> getBookListBorrowed(){
        return bookListBorrowed;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public void setLastName(String lastName){
        this.lastName= lastName;
    }

    public void setUserName(String username){
        this.userName= username;
    }

    public void addBookToListBorrowed(Book book){
        bookListBorrowed.add(book);
    }

    public void removeBookFromListBorrowed(Book book){
        bookListBorrowed.remove(book);
    }

    //In case you want to change ur password / Forgot Password Feature
    public void setPassword(String password){
        this.password= password;
    }



    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.isAdmin = false;
    }
    public User(String firstName, String lastName, String userName, String password, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public void printBorrowedBooks (){
        for (Book book : bookListBorrowed){
            //TODO
            String formattedDate = book.getReturnDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.println(book.getTitle()+" "+book.getAuthor()+" "+ formattedDate);
        }

    }
}
