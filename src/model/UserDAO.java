package model;

import exception.BadRequestException;
import exception.InternalServerException;

import java.util.Objects;

/**
 * Created by user on 11.09.2017.
 */
public class UserDAO<T extends User> {
    private T[] array = (T[]) new User[5];
    //private User user;

    public T[] getArray() {
        return array;
    }

    public  void validate(T t) throws Exception {
        int countNull = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                countNull++;
            }
        }
       /* for (T el : array) {
            if (el == null)
                countNull++;
        }*/
        if (countNull == 0) {
            throw new InternalServerException("Method add in  class failed to complete ");
        }

    }

    public void addUser(T t) throws Exception {
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

    public T[] viewUsers() {
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



    public void deleteUser(T t) throws Exception {
        checkLoginUser(t);
        findObjectInDB(array, t);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(t)) {
                array[i] = null;
                System.out.println("Record deleted successfully!");
                break;
            }
        }
    }

    public boolean checkLoginUser(T t) throws Exception{

        if(!(t.getLoginType() == LoginType.AUTH))
            throw new BadRequestException("Try again enter");
        return true;
    }



}
