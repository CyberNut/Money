package model;

public class User {

    private String login;
    private String name;

    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[Login: " + login + " name: " + name + "]";
    }
}
