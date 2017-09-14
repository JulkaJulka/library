package model;

import exception.BadRequestException;
import exception.InternalServerException;

import java.util.Objects;

/**
 * Created by user on 11.09.2017.
 */
public class UserDAO<T extends User> {
    private T[] array = (T[]) new User[5];
    private User loginUser;


    public T[] getArray() {
        return array;
    }

    public  void validate(T t) throws Exception {
        int countNull = 0;
       /* for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                countNull++;
            }
        }*/
        for (T el : array) {
            if (el == null)
                countNull++;
        }
        if (countNull == 0) {
            throw new InternalServerException("Method add in  class failed to complete ");
        }

    }

    public void addUser(T t, User loginUser) throws Exception {
        checkLoginUser(loginUser);
        if (t == null)
            throw new BadRequestException("Wrong user");
        validate(t);
        for (T el : array) {
            if (el != null && el.equals(t))
                throw new BadRequestException("User with id  is already exist." +
                        " Method add failed to complete.");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = t;
                System.out.println("User " + t.getUserType() + " added successfully!" );
                break;
            }
        }
    }

    public T[] viewUsers(User loginUser) throws Exception{
        checkLoginUser(loginUser);
        int countFullPosition = 0;
        for (T el : array) {
            if(el != null){
                countFullPosition++;
            }
        }
        T[] arrayEmpty = (T[]) new User[0];
        if(countFullPosition == 0)
            return arrayEmpty;

        T[] userList = (T[])new User[countFullPosition];
        int index = 0;
        for (T el : array) {
            if(el != null){
                userList[index] = el;
                index++;
            }
        }
        return userList;

    }

    public  T findObjectInDB(T[] array, T t) throws Exception {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(t)) {
                return array[i];
            }
        }
        throw new BadRequestException("User not found");
    }



    public void deleteUser(T t, User loginUser) throws Exception {
        checkLoginUser(loginUser);
        findObjectInDB(array, t);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(t)) {
                array[i] = null;
                System.out.println("Record deleted successfully!");
                break;
            }
        }
    }

    public boolean checkLoginUser(User loginUser) throws Exception{

        if(!(loginUser.getLoginType() == LoginType.AUTH))
            throw new BadRequestException("Try again enter");
        return true;
    }

    public  void resetPasswordForLibrarian(T toUserNeedChangePassword, String newPassword, T loginUser) throws Exception{
        checkLoginUser(loginUser);
        if(loginUser.getUserType() == UserType.LIBRARIAN)
            throw new Exception("A method is not accessible to you");
        for (int i = 0; i < array.length ; i++) {
            if(array[i].equals(toUserNeedChangePassword) ){
                toUserNeedChangePassword.setPassword(newPassword);
                System.out.println("Password changed successfully!!!");
                break;
            }
        }
    }



}
