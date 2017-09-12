package model;

/**
 * Created by user on 12.09.2017.
 */
public class User {
    private long id;
    private String name;
    private String password;
    User[] users = new User[5];
    private UserDAO userDAO = new UserDAO();
    private Librarian librarian;
    private Admin admin;
    private LoginType loginType;
    private UserType userType;

    public User(long id, String name, String password, LoginType loginType,UserType userType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.loginType = loginType;
        this.userType = userType;
    }

    public void loginUser(UserDAO userDAO, String name, String password) {
        for (int i = 0; i < userDAO.getArray().length; i++) {
            if (userDAO.getArray() != null &&
                  !(userDAO.getArray()[i]==null) &&
                    userDAO.getArray()[i].getName().equals(name) &&
                    userDAO.getArray()[i].getPassword().equals(password)) {
                setLoginType(LoginType.AUTH);
                break;
            } }
        }

   /* public void loginUser(String name, String password) {
        for (int i = 0; i < userDAO.getArray().length; i++) {
            if (userDAO.getArray() != null &&
                    !(userDAO.getArray()[i] == null) &&
                    userDAO.getArray()[i].getName().equals(name) &&
                    userDAO.getArray()[i].getPassword().equals(password)) {
                setLoginType(LoginType.AUTH);
                break;
            }
        }}*/

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public User[] getUsers() {
        return users;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public Admin getAdmin() {
        return admin;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public UserType getUserType() {
        return userType;

    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", loginType=" + loginType +
                ", userType=" + userType +
                '}';
    }
}