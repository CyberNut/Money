package model;

import controller.Controller;
import controller.IController;

import java.sql.Connection;

public class UserManager {

    private static IController controller = Controller.getInstance();
    private static Connection connection;
    public static boolean authoriseUser(String userName, String password) {

        return true;
    }

    public User getUserByName(String name) {
        return controller.getUserByName(name);
    }



}
