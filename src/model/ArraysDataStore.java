package model;

import java.util.ArrayList;
import java.util.List;

//for tests

public class ArraysDataStore implements DataStore {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();

    public ArraysDataStore() {
        initArrays();
    }

    private void initArrays() {
        //users
        User tempUser = new User("Andrey");
        tempUser.setPassword("12345");
        users.add(tempUser);
        tempUser = new User("anna");
        tempUser.setPassword("123");
        users.add(tempUser);
        //accounts
        Account tempAccount = new Account(users.get(0), MoneyType.CASH, "Andrey cash");
        accounts.add(tempAccount);
        tempAccount = new Account(users.get(0), MoneyType.CASHLESS, "Andrey Tinkoff card");
        accounts.add(tempAccount);
        tempAccount = new Account(users.get(0), MoneyType.CASHLESS, "Andrey Sberbank card");
        accounts.add(tempAccount);
        tempAccount = new Account(users.get(1), MoneyType.CASHLESS, "Anna Tinkoff card");
        accounts.add(tempAccount);
        tempAccount = new Account(users.get(1), MoneyType.CASH, "Anna cash");
        accounts.add(tempAccount);
        //categories
        Category tempCategory = new Category("Food");
        categories.add(tempCategory);
        tempCategory = new Category("Kids");
        categories.add(tempCategory);
        tempCategory = new Category("Transport");
        categories.add(tempCategory);
        tempCategory = new Category("Clothes and Shoes");
        categories.add(tempCategory);
    }

    @Override
    public boolean authoriseUser(String userName, String password) {
        User tempUser = findUserByName(userName);
        if (tempUser != null) {
            if(tempUser.getPassword().equals(password)==true) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean createUser(String userName, String password) {
        if (findUserByName(userName) != null) {
            User tempUser = new User(userName);
            tempUser.setPassword(password);
            users.add(tempUser);
            return true;
        }
        return false;
    }

    @Override
    public User findUserByName(String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean createAccount(String description, MoneyType moneyType, User user) {
        for (Account account : accounts) {
            if (account.getName().equals(description) == true && account.getType() == moneyType && account.getUser() == user) {
                return false;
            }
        }
        Account tempAccount = new Account(user, moneyType, description);
        accounts.add(tempAccount);
        return true;
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public boolean createCategory(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name) == true) {
                return false;
            }
        }
        Category tempCategory = new Category(name);
        categories.add(tempCategory);
        return true;
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }
}
