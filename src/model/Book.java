package model;

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
    private Date issuedDate;

    public Book(long id, String callNo, String nameOfBook, String nameOfAuthor, String publisher,
                int quantity, int issued, Date added, Student student, Date issuedDate) {
        this.id = id;
        this.callNo = callNo;
        this.nameOfBook = nameOfBook;
        this.nameOfAuthor = nameOfAuthor;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issued = issued;
        this.added = added;
        this.student = student;
        this.issuedDate = issuedDate;
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

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStudent(Student student) {
        this.student = student;

    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", callNo='" + callNo + '\'' +
                ", nameOfBook='" + nameOfBook + '\'' +
                ", nameOfAuthor='" + nameOfAuthor + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                ", issued=" + issued +
                ", added=" + added +
                ", student=" + student +
                ", issuedDate=" + issuedDate +
                '}';
    }
}
