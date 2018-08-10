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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MoneyType getType() {
        return type;
    }

    public void setType(MoneyType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + user.toString() + " type: " + type.toString() ;
    }
}
