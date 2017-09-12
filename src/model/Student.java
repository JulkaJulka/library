package model;

import java.util.Arrays;

/**
 * Created by user on 06.09.2017.
 */
public class Student {
    private int id;
    private String nameStudent;
    private long phoneNumber;
    private Book[] books = new Book[4];
    private String bookCallNo;
    private long bookId;

    public Student(int id, String nameStudent, long phoneNumber, String bookCallNo, long bookId) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.phoneNumber = phoneNumber;
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

    public Book[] getBooks() {
        return books;
    }

    public String getBookCallNo() {
        return bookCallNo;
    }

    public void setBookCallNo(String bookCallNo) {
        this.bookCallNo = bookCallNo;
    }

    public long getBookId() {
        return bookId;
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
              //  ", books=" + Arrays.toString(books) +
                ", bookCallNo='" + bookCallNo + '\'' +
                ", bookId=" + bookId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
