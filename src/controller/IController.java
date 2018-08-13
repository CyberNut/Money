package controller;

import model.Account;
import model.Category;

import java.util.List;

public interface IController {

    boolean authoriseUser(String userName, String password);
    boolean createUser(String userName, String password);
    List<Account> getAccounts();
    boolean addAccount(Account account);
    List<Category> getCategories();
    boolean addCategory(Category category);

}
