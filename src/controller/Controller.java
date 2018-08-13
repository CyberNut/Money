package controller;

import model.Account;
import model.Category;
import model.DBDataStore;
import model.DataStore;

import java.util.List;

public class Controller implements IController {

    private static Controller instance;
    private static DataStore dataStore;

    private Controller() {
        this.dataStore = new DBDataStore();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
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
    public List<Account> getAccounts() {
        return dataStore.getAccounts();
    }

    @Override
    public boolean addAccount(Account account) {
        return false;
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
