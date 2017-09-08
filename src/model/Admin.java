package model;

/**
 * Created by user on 06.09.2017.
 */
public class Admin {

    private long id;
    private String name;
    private String password;

    public Admin(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
