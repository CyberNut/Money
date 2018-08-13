package controller;

import model.*;

import java.util.List;

public class Controller implements IController {

    private static Controller instance;
    private DataStore dataStore;

    private Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    @Override
    public DataStore getDataStore() {
        return dataStore;
    }

    @Override
    public void setDataStore(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public boolean authoriseUser(String userName, String password) {
        return dataStore.authoriseUser(userName, password);
    }

    @Override
    public boolean createUser(String userName, String password) {
        return dataStore.createUser(userName, password);
    }

    @Override
    public User getUserByName(String userName) {
        return dataStore.findUserByName(userName);
    }

    @Override
    public List<Account> getAccounts() {
        return dataStore.getAccounts();
    }

    @Override
    public boolean addAccount(Account account) {
        return dataStore.createAccount(account);
    }

    @Override
    public List<Category> getCategories() {
        return null;
    }

    @Override
    public boolean addCategory(Category category) {
        return false;
    }
}
