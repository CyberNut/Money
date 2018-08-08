package controller;

public class Controller implements IController {


    @Override
    public boolean authoriseUser(String userName, String password) {
        return false;
    }

    @Override
    public boolean createUser(String userName, String password) {
        return false;
    }
}
