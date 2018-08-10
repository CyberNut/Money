package model;

import java.util.List;

public interface DataStore {

    boolean authoriseUser(String userName, String password);
    boolean createUser(String userName, String password);
    User findUserByName(String userName);
    boolean createAccount(String description, String moneyType, String userName);
    List<Account> getAccounts();
    boolean createCategory(String name);
    List<Category> getCategories();

}
