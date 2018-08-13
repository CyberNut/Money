package model;

import java.util.List;

public interface DataStore {

    boolean authoriseUser(String userName, String password);
    boolean createUser(String userName, String password);

    User findUserByName(String userName);

    boolean createAccount(Account account);
    //boolean createAccount(String description, MoneyType moneyType, User user);
    List<Account> getAccounts();

    boolean createCategory(String name);
    List<Category> getCategories();

}
