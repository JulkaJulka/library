package model;

import model.*;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by user on 06.09.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Librarian librarian1 = new Librarian(1, "Oleg", "passwo", "prutic@yandex.ru", "Mury, 3", "Mykolaiv", 979107718);
        Librarian librarian2 = new Librarian(2, "Tetyana", "passwo1", "krutic@yandex.ru", "Mury, 3", "Kyiv", 979107710);
        Librarian librarian3 = new Librarian(3, "Yuliia", "passwo2", "kghutic@yandex.ru", "Mury, 3", "Kyiv", 979107780);
        Librarian librarian4 = new Librarian(4, "Yuliia", "passwo3", "kghutic@yandex.ru", "Mury, 3", "Kyiv", 979107780);
        Librarian librarian5 = new Librarian(5, "Yuliia", "passwo3", "boomba@yandex.ru", "Mury, 3", "Kyiv", 979107780);
        Librarian librarian6 = new Librarian(6, "Yuliia", "passwo3", "boomba@yandex.ru", "Mury, 3", "Kyiv", 979107780);

        Admin admin1 = new Admin(7, "Kostya", "pass45");

        LibrarianDAO librarianDAO = new LibrarianDAO();
        BooksDAO booksDAO = new BooksDAO();

        User user1 = new User(1,"Mykola","qwerty",LoginType.AUTH,UserType.ADMIN);
        User user2 = new User(1,"Tetyana","qwerty1",LoginType.NONAUTH,UserType.LIBRARIAN);
        User user3 = new User(2,"Tetyana","qwerty2",LoginType.NONAUTH,UserType.LIBRARIAN);
        User user4 = new User(3,"Tetyana","qwerty3",LoginType.NONAUTH,UserType.LIBRARIAN);
        User user5 = new User(4,"Tetyana","qwerty4",LoginType.AUTH,UserType.LIBRARIAN);
        User user6 = new User(5,"Olya","qwerty5",LoginType.NONAUTH,UserType.LIBRARIAN);

        UserDAO<User> userDAO1 = new UserDAO<>();
        UserDAO<User> userDAO2 = new UserDAO<>();
        userDAO1.addUser(user1,user1);

        System.out.println("---Test0");
      System.out.println(Arrays.toString(userDAO1.viewUsers(user1)));

        Book book1 = new Book(1, "2@a6","Java", "Sierra","Znanie",0, new Date(),null, null);
        Book book2 = new Book(2, "2@a689908","Java", "Sierra","Znanie",0, new Date(),null, null);
        Student student1 = new Student(1001,"Yuliia", 979107799, null, 0);
        Student student2 = new Student(1002,"Oleg", 979107799, null, 0);



        System.out.println("---Test21_addBook");
        booksDAO.addBook(book1,user5);
        System.out.println(Arrays.toString(booksDAO.getArrayBooks()));
        System.out.println();

        System.out.println("---Test22_issueBook");
        user2.loginUser(userDAO2,"Tetyana", "qwerty1");
        booksDAO.issueBook(book1, student1, user5);
        System.out.println(Arrays.toString(booksDAO.getArrayBooks()));
       System.out.println(Arrays.toString(student1.getBooks()));
        System.out.println();

        System.out.println("---Test22-2_issueBook existing in Student");
        try{
        booksDAO.issueBook(book1, student1,user5);}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(booksDAO.getArrayBooks()));
        System.out.println(Arrays.toString(student1.getBooks()));
        System.out.println();

        System.out.println("--Test23_issueBook that is not available");
        booksDAO.issueBook(book1, student2, user5);
        System.out.println(Arrays.toString(booksDAO.getArrayBooks()));
        System.out.println(student2);
        System.out.println();

        System.out.println("--Test24_returnedBook");
        userDAO2.addUser(user4, user1);
        booksDAO.addBook(book2,user5);
        booksDAO.issueBook(book2, student1,user5);
        System.out.println(Arrays.toString(student1.getBooks()));
        user4.loginUser(userDAO2,"Tetyana","qwerty3");
        booksDAO.returnBook(student1,book2, user4);
        System.out.println(Arrays.toString(booksDAO.getArrayBooks()));
        System.out.println(Arrays.toString(student1.getBooks()));
        System.out.println();


        System.out.println("---Test1_addLibrarian with existing ID");
        librarianDAO.addLibrarian(librarian1);
        librarianDAO.addLibrarian(librarian2);
        librarianDAO.addLibrarian(librarian3);
        librarianDAO.addLibrarian(librarian4);
        try {
            librarianDAO.addLibrarian(librarian4);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(librarianDAO.viewLibrarian()));
        System.out.println();

        System.out.println("---Test2_addLibrarian");
        librarianDAO.addLibrarian(librarian5);
        System.out.println(Arrays.toString(librarianDAO.viewLibrarian()));
        System.out.println();

        System.out.println("---Test3_addLibrarian fullDB");
        try{
        librarianDAO.addLibrarian(librarian6);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("---Test4_viewLibrarians");
        System.out.println(Arrays.toString(librarianDAO.viewLibrarian()));
        System.out.println();

        System.out.println("---Test5_selete existing Librarian");
        librarianDAO.deleteLibrarian(5);
        System.out.println(Arrays.toString(librarianDAO.viewLibrarian()));
        System.out.println();

        System.out.println("---Test6_selete not existing Librarian");
        try {
            librarianDAO.deleteLibrarian(6);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();
       // System.out.println(Arrays.toString(librarianDAO.viewLibrarian()));

        System.out.println("---Test31_UserDaO addUser viewUser");
        userDAO2.addUser(user2,user1);
        userDAO2.addUser(user3,user1);
        System.out.println(Arrays.toString(userDAO2.getArray()));
        user3.loginUser(userDAO2,"Tetyana", "qwerty2");
        System.out.println("****");
        System.out.println(user3);
        System.out.println();


        System.out.println("---Test32_UserDaO deleteUser delete existing User");
        userDAO2.deleteUser(user4,user3);
        System.out.println(Arrays.toString(userDAO2.getArray()));
        System.out.println();


        System.out.println("---Test33_UserDaO deleteUser delete not existing User");
        try{
            userDAO2.deleteUser(user4,user3);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("---Test41_UserDaO viewUsers");
        System.out.println(Arrays.toString(userDAO2.viewUsers(user3)));
        System.out.println();


        /*System.out.println("---Test32_UserDaO deleteUser delete existing User");
        userDAO.deleteUser(admin1);
        userDAO.deleteUser(librarian5);
        System.out.println(Arrays.toString(userDAO.viewUsers()));*/
        System.out.println("---Test41_UserDaO resetPassword");
        userDAO2.addUser(user6, user1);
        System.out.println(user6);
        userDAO2.resetPasswordForLibrarian(user6,"0000", user1);
        System.out.println(user6);



    }




}
