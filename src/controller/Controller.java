package controller;

import model.DBDataStore;
import model.DataStore;

public class Controller implements IController {

    DataStore dataStore;

    public Controller() {
        this.dataStore = new DBDataStore();
    }

    @Override
    public boolean authoriseUser(String userName, String password) {
        return dataStore.authoriseUser(userName, password);
    }

    @Override
    public boolean createUser(String userName, String password) {
        return dataStore.createUser(userName, password);
    }
}
