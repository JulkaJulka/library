package model;

/**
 * Created by user on 06.09.2017.
 */
public class Student {
    private int id;
    private String nameStudent;
    private long phoneNumber;
    private String bookCallNo;
    private long bookId;

    public Student(int id, String nameStudent, long phoneNumber, String bookCallNo, long bookId) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.phoneNumber = phoneNumber;
        this.bookCallNo = bookCallNo;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getBookCallNo() {
        return bookCallNo;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookCallNo(String bookCallNo) {
        this.bookCallNo = bookCallNo;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nameStudent='" + nameStudent + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", bookCallNo='" + bookCallNo + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
