import controller.Controller;
import controller.IController;
import model.*;
import view.AuthorizationWindow;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        DataStore dataStore = new ArraysDataStore();
        IController controller = Controller.getInstance();
        controller.setDataStore(dataStore);
        authoriseUser(controller);
    }

    private static void authoriseUser(IController controller) {
        AuthorizationWindow dialog = new AuthorizationWindow(controller);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
