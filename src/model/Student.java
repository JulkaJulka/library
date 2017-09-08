package model;

/**
 * Created by user on 06.09.2017.
 */
public class Student {
    private int id;
    private String nameStudent;
    private int phoneNumber;
    private String bookCallNo;

    public Student(int id, String nameStudent, int phoneNumber, String bookCallNo) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.phoneNumber = phoneNumber;
        this.bookCallNo = bookCallNo;
    }

    public int getId() {
        return id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getBookCallNo() {
        return bookCallNo;
    }
}
