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
        UserDAO userDAO = new UserDAO();

        Book book1 = new Book(1, "2@a6","Java", "Sierra","Znanie",0, new Date(),null, null);
        Book book2 = new Book(2, "2@a689908","Java", "Sierra","Znanie",0, new Date(),null, null);
        Student student1 = new Student(1001,"Yuliia", 979107799, null, 0);
        Student student2 = new Student(1002,"Oleg", 979107799, null, 0);

        System.out.println("---Test21_addBook");
        booksDAO.addBook(book1);
        System.out.println(Arrays.toString(booksDAO.getArrayBooks()));
        System.out.println();

        System.out.println(Arrays.toString(student1.getBooks()));

        System.out.println("---Test22_issueBook");
        booksDAO.issueBook(book1, student1);
        System.out.println(Arrays.toString(booksDAO.getArrayBooks()));
       System.out.println(Arrays.toString(student1.getBooks()));
        System.out.println();

        System.out.println("---Test22-2_issueBook existing in Student");
        try{
        booksDAO.issueBook(book1, student1);}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(booksDAO.getArrayBooks()));
        System.out.println(Arrays.toString(student1.getBooks()));
        System.out.println();

        System.out.println("--Test23_issueBook that is not available");
        booksDAO.issueBook(book1, student2);
        System.out.println(Arrays.toString(booksDAO.getArrayBooks()));
        System.out.println(student2);
        System.out.println();

        System.out.println("--Test24_returnedBook");
        booksDAO.addBook(book2);
        booksDAO.issueBook(book2, student1);
        System.out.println(Arrays.toString(student1.getBooks()));
        booksDAO.returnBook(student1,book2);
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
        userDAO.addUser(admin1);
        System.out.println(Arrays.toString(userDAO.viewUsers()));
        userDAO.addUser(librarian5);
        System.out.println(Arrays.toString(userDAO.viewUsers()));
        System.out.println();
        userDAO.addUser(book1);
        System.out.println(Arrays.toString(userDAO.viewUsers()));

        System.out.println("---Test32_UserDaO deleteUser delete not existing User");
        try{
            userDAO.deleteUser(librarian6);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("---Test32_UserDaO deleteUser delete existing User");
        userDAO.deleteUser(admin1);
        userDAO.deleteUser(librarian5);
        System.out.println(Arrays.toString(userDAO.viewUsers()));


    }




}
