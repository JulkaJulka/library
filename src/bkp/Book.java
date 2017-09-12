package bkp;

import java.util.Date;

/**
 * Created by user on 06.09.2017.
 */
public class Book {
    private long id;
    private String callNo;
    private String nameOfBook;
    private String nameOfAuthor;
    private String publisher;
    private int quantity;
    private int issued;
    private Date added;
    private Student student;

    public Book(long id, String callNo, String nameOfBook, String nameOfAuthor, String publisher,
                int quantity, int issued, Date added, Student student) {
        this.id = id;
        this.callNo = callNo;
        this.nameOfBook = nameOfBook;
        this.nameOfAuthor = nameOfAuthor;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issued = issued;
        this.added = added;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public String getCallNo() {
        return callNo;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIssued() {
        return issued;
    }

    public Date getAdded() {
        return added;
    }

    public Student getStudent() {
        return student;
    }
}
