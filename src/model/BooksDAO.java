package model;

import exception.BadRequestException;
import exception.InternalServerException;

import java.util.Date;

/**
 * Created by user on 06.09.2017.
 */
public class BooksDAO {
    private Book[] books = new Book[5];

    public Book[] getArrayBooks() {
        return books;
    }

    public void validate(Book book) throws Exception {
        int countNull = 0;
        for (Book bk : books) {
            if (bk == null)
                countNull++;
        }
        if (countNull == 0) {
            throw new InternalServerException("Method add in BooksDAO class " +
                    "failed to complete. Not enough space for Books with id " + book.getId());
        }

    }

    public boolean presenceBookInStudent(Student student, Book book) throws Exception {
        if (book.equals(null))
            throw new BadRequestException("Wrong Book");
        if (student.getBooks() == null)
            return false;
        for (int i = 0; i < student.getBooks().length; i++) {
            if (student.getBooks()[i] != null && student.getBooks()[i].equals(book)) {
                return true;
            }
        }
        return false;
    }

    public void addBook(Book book) throws Exception {
        if (book == null)
            throw new BadRequestException("Wrong Book");
        validate(book);
        for (Book bk : books) {
            if (bk != null && bk.equals(book))
                throw new BadRequestException("Book with id " + book.getId() + " is already exist." +
                        " Method add failed to complete.");
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                System.out.println("Book with id " + book.getId() + " added successfully!");
                break;
            }

        }
    }


    public void issueBook(Book book, Student student) throws Exception {

        if (presenceBookInStudent(student, book))
            throw new BadRequestException("Student already has such book");
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getStudent() == null
                    && books[i].equals(book)) {
                books[i].setStudent(student);
                books[i].setIssued(books[i].getIssued() + 1);
                books[i].setIssuedDate(new Date());
                for (int j = 0; j < student.getBooks().length; j++) {
                    if (student.getBooks()[i] == null) {
                        student.getBooks()[i] = book;
                        break;
                    }
                }
                System.out.println("Book with id " + book.getId() + " issued successfully!");
            } else if (books[i] != null && books[i].getStudent() != null && books[i].equals(book)) {
                System.out.println("Book is not available now");
            }
        }

    }


    public void returnBook(Student student, Book returnBook) throws Exception {
        if (!presenceBookInStudent(student, returnBook))
            throw new BadRequestException("User hasn't such book with id " + returnBook.getId());
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getStudent() != null &&
                    books[i].equals(returnBook) &&
                    books[i].getStudent() == student) {
                books[i].setStudent(null);
                books[i].setIssued(books[i].getIssued() - 1);
                books[i].setIssuedDate(null);
                for (int j = 0; j < student.getBooks().length; j++) {
                    if (student.getBooks()[i] != null && student.getBooks()[i].equals(returnBook)) {
                        student.getBooks()[i] = null;
                        break;
                    }
                }

                System.out.println("Book with id " + returnBook.getId() + " returned successfully!");

            }
        }
    }
}
