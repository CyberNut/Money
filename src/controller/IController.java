package controller;

import model.Account;
import model.Category;
import model.DataStore;
import model.User;

import java.util.List;

public interface IController {

    void setDataStore(DataStore dataStore);
    DataStore getDataStore();
    boolean authoriseUser(String userName, String password);
    boolean createUser(String userName, String password);
    User getUserByName(String userName);
    List<Account> getAccounts();
    boolean addAccount(Account account);
    List<Category> getCategories();
    boolean addCategory(Category category);

}
