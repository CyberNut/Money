package model;

public class User {

    private String name;
    private String password;

    public User(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "[Name: " + name + "]";
    }
}
