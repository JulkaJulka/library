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

    public void addBook(Book book) throws  Exception {
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


    public void issueBook(long id, Student student) {
       /* for (Book bk: books) {
            if(bk.getId() == book.getId() && bk.getStudent() == null){
                bk.getStudent() = student;
            }*/
        for (int i = 0; i < books.length ; i++) {
            if(books[i] != null && books[i].getStudent() == null && books[i].getId() == id){
                books[i].setStudent(student);
                books[i].setIssued(books[i].getIssued() + 1);
                books[i].setQuantity(books[i].getQuantity() - 1);
                books[i].setIssuedDate(new Date());
                student.setBookCallNo( books[i].getCallNo());
                student.setBookId(books[i].getId());
                System.out.println("Book with id " + id + " issued successfully!");
            } else
           if( books[i] != null && books[i].getStudent() != null && books[i].getId() == id){
               System.out.println("Book is not available now");
           }
        }

    }


    public void returnBook(Student student, long returnBookId) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getStudent() != null &&
                    books[i].getId() == student.getBookId() &&
                    books[i].getStudent() == student) {
                books[i].setStudent(null);
                books[i].setIssued(books[i].getIssued() - 1);
                books[i].setQuantity(books[i].getQuantity() + 1);
                books[i].setIssuedDate(null);
                student.setBookCallNo(null);
                student.setBookId(0);
                System.out.println("Book with id " + returnBookId + " returned successfully!");
            }
        }


    /*public Book[]  viewBooks() {
        int countFullPosition = 0;
        for (Book bk:books) {
            if(bk != null){
                countFullPosition++;
            }
        }
        if(countFullPosition == 0)
            return new Book[] {};

        Book[] bookList = new Book[countFullPosition];
        int index = 0;
        for (Book bk:books) {
            if(bk!= null){
                bookList[index] = bk;
                index++;
            }
        }
        return bookList;
    }*/
    }
}
