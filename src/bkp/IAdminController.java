package bkp;

/**
 * Created by user on 06.09.2017.
 */
public interface IAdminController {
    void addLibrarian(Librarian librarian);
    Librarian[] viewLibrarian();
    void deleteLibrarian(long id);

}
