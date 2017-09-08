package controller;

import model.Book;
import model.Student;

/**
 * Created by user on 06.09.2017.
 */
public interface ILibrarian {
    void addBooks(Book books);
    void issueBook(Student student);
    void returnBook(Student student);
    Book[] viewBooks();

}
