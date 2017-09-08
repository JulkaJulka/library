package model;

import exception.BadRequestException;
import exception.InternalServerException;

/**
 * Created by user on 06.09.2017.
 */
public class BooksDAO {
    private Books[] arrayBooks = new Books[5];

    public Books[] getArrayBooks() {
        return arrayBooks;
    }
    public void validate(Books books) throws Exception {
        int countNull = 0;
        for (Books bk : arrayBooks) {
            if (bk == null)
                countNull++;
        }
        if (countNull == 0) {
            throw new InternalServerException("Method add in BooksDAO class " +
                    "failed to complete. Not enough space for Books with id " + books.getId());
        }

    }

    public void addBooks(Books books) throws  Exception {
        if (books == null)
            throw new BadRequestException("Wrong Books");
        validate(books);
        for (Books bk : arrayBooks) {
            if (bk != null && bk.equals(books))
                throw new BadRequestException("Books with id " + books.getId() + " is already exist." +
                        " Method add failed to complete.");
    }
    }


    public void issueBook(String bookCallNo, long id, String name, long phoneNumber) {

    }


    public void returnBook(Student student) {

    }


    public Books[]  viewBooks() {
        int countFullPosition = 0;
        for (Books bk:arrayBooks) {
            if(bk != null){
                countFullPosition++;
            }
        }
        if(countFullPosition == 0)
            return new Books[] {};

        Books[] bookList = new Books[countFullPosition];
        int index = 0;
        for (Books bk:arrayBooks) {
            if(bk!= null){
                bookList[index] = bk;
                index++;
            }
        }
        return bookList;
    }
}
