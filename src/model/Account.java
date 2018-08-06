package model;

public class Account {

    private User user;
    private MoneyType type;
    private String name;


    public Account( User user, MoneyType type, String name) {
        this.user = user;
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + user.toString() + " type: " + type.toString() ;
    }
}
