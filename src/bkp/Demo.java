package bkp;

import java.util.Arrays;

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

        LibrarianDAO librarianDAO = new LibrarianDAO();

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
       // System.out.println(Arrays.toString(librarianDAO.viewLibrarian()));


    }



}
