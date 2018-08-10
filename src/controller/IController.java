package controller;

import model.Account;

import java.util.List;

public interface IController {

    boolean authoriseUser(String userName, String password);
    boolean createUser(String userName, String password);
    List<Account> getAccounts();

}
