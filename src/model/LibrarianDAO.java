package model;

import exception.BadRequestException;
import exception.InternalServerException;

/**
 * Created by user on 06.09.2017.
 */
public class LibrarianDAO {
    private Librarian[] librarians = new Librarian[5];

    public Librarian[] getLibrarians() {
        return librarians;
    }

    public void validate(Librarian librarian) throws Exception {
        int countNull = 0;
        for (Librarian lib : librarians) {
            if (lib == null)
                countNull++;
        }
        if (countNull == 0) {
            throw new InternalServerException("Method add in LibrarianDAO class " +
                    "failed to complete. Not enough space for librarian with id " + librarian.getId());
        }

    }

    public void addLibrarian(Librarian librarian) throws Exception {
        if (librarian == null)
            throw new BadRequestException("Wrong librarian");
        validate(librarian);
        for (Librarian lib : librarians) {
            if (lib != null && lib.equals(librarian))
                throw new BadRequestException("Librarian with id " + librarian.getId() + " is already exist." +
                        " Method add failed to complete.");
        }

        for (int i = 0; i < librarians.length; i++) {
            if (librarians[i] == null) {
                librarians[i] = librarian;
                System.out.println("Librarian added successfully!");
                break;
            }

        }

    }

    public Librarian[] viewLibrarian() {
        int countFullPosition = 0;
        for (Librarian lib:librarians) {
            if(lib != null){
                countFullPosition++;
            }
        }
        if(countFullPosition == 0)
            return new Librarian[] {};

        Librarian[] libList = new Librarian[countFullPosition];
        int index = 0;
        for (Librarian lib:librarians) {
            if(lib != null){
                libList[index] = lib;
                index++;
            }
        }
        return libList;

    }
    public  Librarian findById(long id) throws Exception {
        for (int i = 0; i < librarians.length; i++) {
            if (librarians[i] != null && librarians[i].getId() == id) {
                return librarians[i];
            }
        }
        throw new BadRequestException("Librarian with id: " + id + " not found");
    }



    public void deleteLibrarian(long id) throws Exception {
        findById(id);
        for (int i = 0; i < librarians.length; i++) {
            if (librarians[i].getId() == id) {
                librarians[i] = null;
                System.out.println("Record deleted successfully!");
                break;
            }
        }
    }



}
