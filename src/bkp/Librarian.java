package bkp;

/**
 * Created by user on 06.09.2017.
 */
public class Librarian extends User {
    private String email;
    private String address;
    private String city;
    private long number;

    public Librarian() {
    }

    public Librarian(long id, String name, String password, String email, String address, String city, long number) {
        super(id, name, password);
        this.email = email;
        this.address = address;
        this.city = city;
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", number=" + number +
                '}';
    }
}
