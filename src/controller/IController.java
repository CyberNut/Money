package controller;

public interface IController {

    boolean authoriseUser(String userName, String password);
    boolean createUser(String userName, String password);

}
