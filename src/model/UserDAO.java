package model;

import exception.BadRequestException;
import exception.InternalServerException;

import java.util.Objects;

/**
 * Created by user on 11.09.2017.
 */
public class UserDAO<T> {
    private T[] array = (T[]) new Object[5];

    public T[] getArray() {
        return array;
    }

    public void validate(T t) throws Exception {
        int countNull = 0;
        for (T el : array) {
            if (el == null)
                countNull++;
        }
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
                System.out.println("User added successfully!");
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
        T[] arrayEmpty = (T[]) new Object[0];
        if(countFullPosition == 0)
            return arrayEmpty;

        T[] userList = (T[])new Object[countFullPosition];
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
        findObjectInDB(array, t);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(t)) {
                array[i] = null;
                System.out.println("Record deleted successfully!");
                break;
            }
        }
    }

}
