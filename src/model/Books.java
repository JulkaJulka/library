package model;

import java.util.Date;

/**
 * Created by user on 06.09.2017.
 */
public class Books {
    private long id;
    private String callNo;
    private String nameOfBook;
    private String nameOfAuthor;
    private String publisher;
    private int quantity;
    private int issued;
    private Date added;

    public Books(long id, String callNo, String nameOfBook, String nameOfAuthor, String publisher,
                 int quantity, int issued, Date added) {
        this.id = id;
        this.callNo = callNo;
        this.nameOfBook = nameOfBook;
        this.nameOfAuthor = nameOfAuthor;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issued = issued;
        this.added = added;
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
}
