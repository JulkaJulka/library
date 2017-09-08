package controller;

import model.Books;
import model.Student;

/**
 * Created by user on 06.09.2017.
 */
public interface ILibrarian {
    void addBooks(Books books);
    void issueBook(Student student);
    void returnBook(Student student);
    Books[] viewBooks();

}
